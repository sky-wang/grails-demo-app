#grails-demo-app

## Summary
The grails-demo-app writtern in Grails(2.x) and relies on a SQL database for storage(currently PostgreSQL).

## Environment
* Grails - YYoga server based on grails 2.3.5, can choose either one from the two options to install it:
  1. use grails binary, [http://www.grails.org/download](http://www.grails.org/download)
  2. use [gvm](http://gvmtool.net) to manage grails install and versions (Recommended). Once gvm installed, issue below command to install grails 2.0.4:
  ```$ gvm install grails 2.3.5```
* Postgres - Assume Postgres 9.x installed
* Git - Assume git installed
* IDE support - Develop yyoga server with your favorite IDE
  1. [IDEA](http://www.jetbrains.com/idea/)
  2. [GGTS](http://grails.org/products/ggts)

## Quickstart
1. Setup database
  * create user "yoga" with password "yoga" for yoga server
    ```$ createuser -h localhost -P -e yoga```
  * create database sample for yoga server
    ```$ createdb -h localhost -U yoga -e sample```
  * create quartz tables(quartz_tables_postgres.sql which located in the root of the project)
    ```$ psql -h localhost -U yoga -d sample -f ./quartz_tables_postgres.sql```

2. Configure db
  * configure datasource(/grails-app/conf/DataSource.groovy), make sure the datasource section match your dev database:
  ```
    environments {
      development {
          dataSource {
              dbCreate = "update" // one of 'create', 'create-drop','update'
              driverClassName = "org.postgresql.Driver"
              url = "jdbc:postgresql://localhost:5432/sample"
              username = "yoga"
              password = "yoga"
          }

          hibernate {
              show_sql = false
          }
      }
      ...
  ```
3. Start server
    ```$ grails run-app```
