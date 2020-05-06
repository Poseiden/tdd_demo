package com.poseiden.controller.base;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TravelExpenseControllerTest extends APIBaseTest {

    @Test
    public void should_pay_6_yuan_when_km_less_than_2_km()  throws Exception {
        long km = 1;

        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s", km)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(6, Integer.parseInt(contentAsString));
    }

    @Test
    public void should_pay_6_yuan_when_km_equals_2_km() throws Exception {
        long km = 2;

        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s", km)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(6, Integer.parseInt(contentAsString));
    }

    @Test
    public void should_pay_per_km_2_yuan_when_exceed_2_km() throws Exception {
        long km = 3;

        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s", km)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(9, Integer.parseInt(contentAsString));
    }

    @Test
    public void should_pay_long_distance_fee_by_per_km_when_more_than_8_km() throws Exception {
        long km = 9;

        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s", km)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(29, Integer.parseInt(contentAsString));
    }
}
