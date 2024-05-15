# Todo

Simple todo application.

![demo](demo.gif)

- [Run Application](#run-application)
- [Run Database Migration](#run-database-migration)

> [!NOTE]
> There is also Spring version of this application available
> at [spring branch](https://github.com/wkktoria/todo/tree/spring).

## Run Application

1. Configure `MAVEN_OPTS` - set up `hibernate_db_path`, `hibernate_username`, and `hibernate_password`.
2. Run the following command:

```shell
./mvnw jetty:run
```

## Run Database Migration

1. Create `flyway.conf` file, see [flyway_example.conf](flyway_example.conf).
2. Run the following command:

```shell
./mvnw flyway:migrate
```
