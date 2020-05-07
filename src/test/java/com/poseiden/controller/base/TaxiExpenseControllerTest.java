package com.poseiden.controller.base;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class TaxiExpenseControllerTest extends APIBaseTest {
    @Test
    public void should_pay_6_yuan_when_km_less_than_2() throws Exception{
        //given
        int distance = 1;

        //when
        MvcResult mvcResult = this.mockMvc.perform(get(String.format("/fee?distance=%s", distance))).andReturn();

        //then
        assertEquals(6, Integer.parseInt(mvcResult.getResponse().getContentAsString()));
    }
}
