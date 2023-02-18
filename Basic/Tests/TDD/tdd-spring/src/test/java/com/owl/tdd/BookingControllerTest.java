package com.owl.tdd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owl.tdd.controller.BookingController;
import com.owl.tdd.model.BookingModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void bookingTestGetAll() throws Exception {
        this.mockMvc.perform(get("/bookings").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void bookingTestSave() throws Exception {
        LocalDate checkIn = LocalDate.parse("2022-11-10");
        LocalDate checkOut = LocalDate.parse("2022-11-20");
        BookingModel bookingModel = new BookingModel("1", "Felipe D. Santos", checkIn, checkOut, 2);
        this.mockMvc.perform(post("/bookings")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType("application/json")
                        .content(this.objectMapper.writeValueAsString(bookingModel)))
                    .andExpect(status().isOk());
    }

}
