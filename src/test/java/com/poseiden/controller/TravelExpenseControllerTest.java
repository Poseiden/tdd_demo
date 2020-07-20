package com.poseiden.controller;

import com.poseiden.controller.base.APIBaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TravelExpenseControllerTest extends APIBaseTest {

    @Test
    public void should_pay_6_yuan_when_km_less_than_2_km()  throws Exception {
        //given
        long km = 1;

        //when
        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s", km)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //then
        assertEquals(6, Integer.parseInt(contentAsString));
    }

    @Test
    public void should_pay_6_yuan_when_km_equals_2_km() throws Exception {
        //given
        long km = 2;

        //when
        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s", km)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //then
        assertEquals(6, Integer.parseInt(contentAsString));
    }

    @Test
    public void should_pay_per_km_2_yuan_when_exceed_2_km() throws Exception {
        //given
        long km = 3;

        //when
        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s", km)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //then
        assertEquals(9, Integer.parseInt(contentAsString));
    }

    @Test
    public void should_pay_long_distance_fee_by_per_km_when_more_than_8_km() throws Exception {
        //given
        long km = 9;

        //when
        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s", km)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //then
        assertEquals(29, Integer.parseInt(contentAsString));
    }

    @Test
    public void should_generate_waiting_expense_by_1_yuan_per_min_when_waiting() throws Exception {
        long km = 2;
        int waiting = 2;

        String contentAsString = this.mockMvc.perform(get(String.format("/expense?km=%s&waiting=%s", km, waiting)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(8, Integer.parseInt(contentAsString));
    }
}
