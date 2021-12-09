package com.project.travel.model.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class RoomReservationRequest {

    private Long id;
    private Long roomId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkin;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkout;

    public RoomReservationRequest() {
    }

    public RoomReservationRequest(Long id, Long roomId, LocalDate checkin, LocalDate checkout) {
        this.id = id;
        this.roomId = roomId;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }
}
