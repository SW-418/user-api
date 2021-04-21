package userapi.app.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(HealthController.class)
public class HealthControllerTests {
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void healthCheckReturnsOkResponse() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/health/check").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        int actualStatus = result.getResponse().getStatus();

        assertEquals( 200, actualStatus);
    }
}
