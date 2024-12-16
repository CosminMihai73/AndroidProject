package com.example.androidproject.models;

import java.util.Date;

public class Reservation {
    private String reservationId; // ID unic pentru rezervare
    private Product product;      // Produsul rezervat
    private User user;            // Utilizatorul care a făcut rezervarea
    private Date reservationDate; // Data și ora rezervării
    private String status;        // Starea rezervării (ex: "în așteptare", "confirmată", "finalizată")

    // Constructor
    public Reservation(String reservationId, Product product, User user, Date reservationDate, String status) {
        this.reservationId = reservationId;
        this.product = product;
        this.user = user;
        this.reservationDate = reservationDate;
        this.status = status;
    }

    // Getters și Setters
    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
