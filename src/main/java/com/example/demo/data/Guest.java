package com.example.demo.data;//package com.example.demospringboot.data;

import jakarta.persistence.*;

@Entity
@Table(name = "GUEST")
public class Guest {
//
//    GUEST_ID BIGSERIAL PRIMARY KEY,
//    FIRST_NAME VARCHAR(64),
//    LAST_NAME VARCHAR(64),
//    EMAIL_ADDRESS VARCHAR(64),
//    ADDRESS VARCHAR(64),
//    COUNTRY VARCHAR(32),
//    STATE VARCHAR(12),
//    PHONE_NUMBER VARCHAR(24)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GUEST_ID")
    private long id;

    @Column(name = "FIRST_NAME", length = 64)
    private String firstName;

    @Column(name = "LAST_NAME", length = 64)
    private String lastName;

    @Column(name = "EMAIL_ADDRESS", length = 64)
    private String emailAddress;

    @Column(name = "ADDRESS", length = 64)
    private String address;

    @Column(name = "COUNTRY", length = 32)
    private String country;

    @Column(name = "STATE", length = 12)
    private String state;

    @Column(name = "PHONE_NUMBER", length = 24)
    private String phoneNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
