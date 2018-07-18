package com.terafunding.test.yitest

import mu.KLogger
import mu.KLogging
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@EnableConfigurationProperties
@SpringBootApplication
@ComponentScan(basePackages = ["com.terafunding.test"])
class YiTestApplication {
    companion object {
        val logger = KotlinLogging.logger { }

        @JvmStatic
        fun main(args: Array<String>) {
//            runApplication<YiTestApplication>(*args)
            SpringApplication.run(YiTestApplication::class.java)
        }
    }

    init {
        logger.info { "configurationProjectProperties.projectName = $cp.getProjectName()" }
    }

    @Autowired
    lateinit var cp: ConfigurationProjectProperties


}

@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties {
    lateinit var projectName: String
}


@Service
class ConfigConfirmService {
    companion object : KLogging()

    @Autowired
    lateinit var cp: ConfigurationProjectProperties

    fun readConfig(): String {
        logger.info { cp.projectName }
        return cp.projectName
    }
}