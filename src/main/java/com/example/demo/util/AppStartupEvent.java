package com.example.demo.util;

import com.example.demo.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    GuestRepo guestRepo;
    @Autowired
    ReservationRepo reservationRepo;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        System.out.println("onApplicationEvent");
        Iterable<Room> rooms = this.roomRepo.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guests = this.guestRepo.findAll();
        guests.forEach(System.out::println);

        Iterable<Reservation> reservations = this.reservationRepo.findAll();
        reservations.forEach(System.out::println);

        System.out.println("onApplicationEvent end");


    }
}
