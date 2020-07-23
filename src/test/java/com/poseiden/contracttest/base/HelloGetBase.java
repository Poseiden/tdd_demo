package com.poseiden.contracttest.base;

import com.poseiden.HelloService;
import com.poseiden.controller.base.APIBaseTest;
import org.junit.Before;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

public abstract class HelloGetBase extends APIBaseTest {

    @MockBean
    private HelloService helloService;

    @Before
    public void setUp() throws Exception {
        super.setupMockMvc();

        when(this.helloService.getTrueValue()).thenReturn("this should be a mock value");
    }
}
