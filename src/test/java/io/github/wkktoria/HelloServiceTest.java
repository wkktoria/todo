package io.github.wkktoria;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    private final static String GREETING_PREFIX = "Hello";

    @Test
    public void test_prepareGreeting_nullName_returnsGreetingWithFallbackName() {
        // given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);

        // when
        var result = SUT.prepareGreeting(null, null);

        // then
        assertEquals(GREETING_PREFIX + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() {
        // given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);
        var name = "test";

        // when
        var result = SUT.prepareGreeting(name, null);

        // then
        assertEquals(GREETING_PREFIX + " " + name + "!", result);
    }

    @Test
    public void test_prepareGreeting_nullLanguage_returnsGreetingWithFallbackLanguageId() {
        // given
        var fallbackGreetingPrefix = "Hallo";
        var mockRepository = new LanguageRepository() {
            @Override
            Optional<Language> findById(Long id) {
                if (id.equals(HelloService.FALLBACK_LANGUAGE.getId())) {
                    return Optional.of(new Language(null, fallbackGreetingPrefix, null));
                }
                return Optional.empty();
            }
        };
        var SUT = new HelloService(mockRepository);

        // when
        var result = SUT.prepareGreeting(null, null);

        // then
        assertEquals(fallbackGreetingPrefix + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    private LanguageRepository alwaysReturningHelloRepository() {
        return new LanguageRepository() {
            @Override
            Optional<Language> findById(Long id) {
                return Optional.of(new Language(null, GREETING_PREFIX, null));
            }
        };
    }
}
