package com.example.userbackend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import spock.lang.Specification

@SpringBootTest
class ApplicationTest extends Specification {

    @Autowired
    private Environment environment

    def "startup works"() {
        expect:
        environment != null
    }
}
