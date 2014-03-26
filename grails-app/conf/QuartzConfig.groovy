
quartz {
    waitForJobsToCompleteOnShutdown = true
    exposeSchedulerInRepository = false

    props {
        scheduler.skipUpdateCheck = true
    }
}

jdbcProps = {
    scheduler.instanceName = "reporting_quartz"
    scheduler.instanceId = "AUTO"

    threadPool.class = "org.quartz.simpl.SimpleThreadPool"
    threadPool.threadCount = 3
    threadPool.threadPriority = 5

    jobStore.misfireThreshold = 60000

    jobStore.class = "org.quartz.impl.jdbcjobstore.JobStoreTX"
    jobStore.driverDelegateClass = "org.quartz.impl.jdbcjobstore.PostgreSQLDelegate"

    jobStore.useProperties = false
    jobStore.tablePrefix = "qrtz_"
    jobStore.isClustered = true
    jobStore.clusterCheckinInterval = 5000

    plugin.shutdownhook.class = "org.quartz.plugins.management.ShutdownHookPlugin"
    plugin.shutdownhook.cleanShutdown = true
}

environments {
    test {
        quartz {
            autoStartup = false
            jdbcStore = false
        }
    }
    development {
        quartz {
            autoStartup = true
            jdbcStore = true
            props(jdbcProps)
        }
    }
    production {
        quartz {
            jdbcStore = true
            autoStartup = true
            props(jdbcProps)
        }
    }
}
