package io.github.wkktoria;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    private final static String GREETING_PREFIX = "Hello";
    private final static String FALLBACK_LANGUAGE_ID_GREETING_PREFIX = "Hallo";


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
        var mockRepository = fallbackLanguageIdHelloRepository();
        var SUT = new HelloService(mockRepository);

        // when
        var result = SUT.prepareGreeting(null, null);

        // then
        assertEquals(FALLBACK_LANGUAGE_ID_GREETING_PREFIX + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_textLanguage_returnGreetingWithFallbackLanguageId() {
        // given
        var mockRepository = fallbackLanguageIdHelloRepository();
        var SUT = new HelloService(mockRepository);

        // when
        var result = SUT.prepareGreeting(null, "abc");

        // then
        assertEquals(FALLBACK_LANGUAGE_ID_GREETING_PREFIX + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_nonExistingLanguage_returnGreetingWithFallbackLanguage() {
        // given
        var mockRepository = new LanguageRepository() {
            @Override
            Optional<Language> findById(Long id) {
                return Optional.empty();
            }
        };
        var SUT = new HelloService(mockRepository);

        // when
        var result = SUT.prepareGreeting(null, "-1");

        // then
        assertEquals(HelloService.FALLBACK_LANGUAGE.getGreetingPrefix() + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    private LanguageRepository alwaysReturningHelloRepository() {
        return new LanguageRepository() {
            @Override
            Optional<Language> findById(Long id) {
                return Optional.of(new Language(null, GREETING_PREFIX, null));
            }
        };
    }

    private LanguageRepository fallbackLanguageIdHelloRepository() {
        return new LanguageRepository() {
            @Override
            Optional<Language> findById(Long id) {
                if (id.equals(HelloService.FALLBACK_LANGUAGE.getId())) {
                    return Optional.of(new Language(null, FALLBACK_LANGUAGE_ID_GREETING_PREFIX, null));
                }
                return Optional.empty();
            }
        };
    }
}
