# todo

There is also Spring version of this application available
at [spring branch](https://github.com/wkktoria/todo/tree/spring).

## Run the application

> [!CAUTION]
> Running application requires to set VM options for `hibernate_db_path`, `hibernate_username` and `hibernate_password`.
> It is possible to use VM options with Jetty by configuring the `MAVEN_OPTS`.

> [!WARNING]
> Running database migrations requires to create `flyway.conf` file, see [flyway_example.conf](flyway_example.conf).

1. Configure `MAVEN_OPTS`.
2. Run the following command in terminal window in the root directory:

```console
./mvnw jetty:run
```