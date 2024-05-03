<h1 style="text-align: center;">todo</h1>

> [!NOTE]
> There is also Spring version of this application available
> at [spring branch](https://github.com/wkktoria/todo/tree/spring).

<h3 style="text-align: center;">Simple todo-list application.</h3>

![demo](demo.gif)

<p style="text-align: center;">
  • <a href="#run-the-application">Run the Application</a> •
  <a href="#run-database-migration">Run Database Migration</a> •
</p>

## Run the Application

1. Configure `MAVEN_OPTS` - set up `hibernate_db_path`, `hibernate_username`, and `hibernate_password`.
2. Run the following command:

```console
./mvnw jetty:run
```

## Run Database Migration

1. Create `flyway.conf` file, see [flyway_example.conf](flyway_example.conf).
2. Run the following command:

```console
./mvnw flyway:migrate
```
