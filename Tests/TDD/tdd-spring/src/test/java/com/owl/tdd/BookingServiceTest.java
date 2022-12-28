package com.owl.tdd;

import com.owl.tdd.model.BookingModel;
import com.owl.tdd.repository.BookingRepository;
import com.owl.tdd.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration {

        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }

    }

    @Autowired
    BookingService bookingService;
    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDayCalculator() {
        String name = "Felipe D. Santos";
        int days = this.bookingService.daysCalculatorWithDataBase(name);
        Assertions.assertEquals(10, days);
    }

    @Before
    public void setup() {
        LocalDate checkIn = LocalDate.parse("2022-11-10");
        LocalDate checkOut = LocalDate.parse("2022-11-20");
        BookingModel bookingModel = new BookingModel("1", "Felipe D. Santos", checkIn, checkOut, 2);
        Mockito.when(this.bookingRepository.findByReserveName(bookingModel.getReserveName()))
                .thenReturn(Optional.of(bookingModel));
    }

}
