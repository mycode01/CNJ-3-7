package com.terafunding.test.yitest

import mu.KLogging
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.assertj.core.api.Assertions.assertThat

@RunWith(SpringRunner::class)
@SpringBootTest
class YiTestApplicationTests {
    companion object : KLogging()
    @Test
    fun contextLoads() {
    }

    @Autowired
    lateinit var configService : ConfigConfirmService

    @Test
    fun propsTest() {
        val conf = configService.readConfig()
        logger.info { "asdfasdfasdf" }
        assertThat(conf).isEqualTo("Spring Boot")
    }

}
