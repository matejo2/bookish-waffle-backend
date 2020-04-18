package com.example.userbackend

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@WebMvcTest
@AutoConfigureWebMvc
class ControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @SpringBean
    private UserService service = Mock()

    def "getting users works"() {
        given: "an uri"
        def uri = "/users"

        when: "controller is called"
        def response = mockMvc.perform(get(uri)).andReturn().response

        then: "status is ok"
        response.getStatus() == HttpStatus.OK.value()
        and: "service was called"
        1 * service.allUsers
    }
}
