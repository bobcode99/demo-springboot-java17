package com.example.demo.util;

import com.example.demo.data.GuestRepo;
import com.example.demo.data.ReservationRepo;
import com.example.demo.data.RoomRepo;
import com.example.demo.data.RoomReservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationService reservationService;
    private final DateUtils dateUtils;
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    GuestRepo guestRepo;
    @Autowired
    ReservationRepo reservationRepo;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);
    }

//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//
//        System.out.println("onApplicationEvent");
//        Iterable<Room> rooms = this.roomRepo.findAll();
//        rooms.forEach(System.out::println);
//
//        Iterable<Guest> guests = this.guestRepo.findAll();
//        guests.forEach(System.out::println);
//
//        Iterable<Reservation> reservations = this.reservationRepo.findAll();
//        reservations.forEach(System.out::println);
//
//        System.out.println("onApplicationEvent end");
//
//
//    }
}
