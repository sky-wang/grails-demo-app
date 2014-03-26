databaseChangeLog = {

	changeSet(author: "wangfei (generated)", id: "1395801212366-1") {
		createTable(tableName: "person") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "personPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "sex", type: "varchar(255)")
		}
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-2") {
		createTable(tableName: "profile") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "profilePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-3") {
		createTable(tableName: "profile_role") {
			column(name: "role_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "profile_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-4") {
		createTable(tableName: "role") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-5") {
		addPrimaryKey(columnNames: "role_id, profile_id", constraintName: "profile_rolePK", tableName: "profile_role")
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-8") {
		createIndex(indexName: "username_uniq_1395801212250", tableName: "profile", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-9") {
		createIndex(indexName: "authority_uniq_1395801212265", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-10") {
		createSequence(sequenceName: "hibernate_sequence")
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-6") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "profile_role", constraintName: "FK48F2514C459A10AA", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "wangfei (generated)", id: "1395801212366-7") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "profile_role", constraintName: "FK48F2514C13F4D46A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

    include file: 'add-date-created-to-person.groovy'


	include file: 'add-asanas.groovy'
}
