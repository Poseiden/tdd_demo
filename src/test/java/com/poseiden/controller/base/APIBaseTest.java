package com.poseiden.controller.base;

import com.poseiden.controller.HelloController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@Transactional
@AutoConfigureMessageVerifier
public abstract class APIBaseTest {
    protected MockMvc mockMvc;
    protected MockMvc unAuthMockMvc;

    @Autowired
    private HelloController helloController;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setupMockMvc() {
        this.mockMvc =
                MockMvcBuilders
                        .webAppContextSetup(this.wac)
                        .build();
        this.unAuthMockMvc = MockMvcBuilders.
                webAppContextSetup(this.wac).
                apply(springSecurity()).
                build();

        RestAssuredMockMvc.standaloneSetup(helloController,
                springSecurity((request, response, chain) -> chain.doFilter(request, response)));
    }
}
