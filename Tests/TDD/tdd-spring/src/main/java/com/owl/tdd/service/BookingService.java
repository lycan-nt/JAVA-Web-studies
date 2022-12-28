package com.owl.tdd.service;

import com.owl.tdd.model.BookingModel;
import com.owl.tdd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysCalculatorWithDataBase(String name) {
        Optional<BookingModel> bookingModelOptional = this.bookingRepository.findByReserveName(name);
        return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
    }

}
