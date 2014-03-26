databaseChangeLog = {

    changeSet(author: "wangfei (generated)", id: "add-date-created-to-person") {
        addColumn(tableName: "person") {
            column(name: "date_created", type: "timestamp")
        }

        grailsChange {
            change {
                sql.execute("UPDATE person SET date_created = NOW()")
            }
            rollback {
            }
        }

        addNotNullConstraint(tableName: "person", columnName: "date_created")
    }
}