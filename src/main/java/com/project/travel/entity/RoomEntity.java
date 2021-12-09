package com.project.travel.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer roomNumber;

    @NotNull
    private String price;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<RoomReservationEntity> reservationEntityList;

    public RoomEntity() {
    }

    public RoomEntity(Integer roomNumber, String price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<RoomReservationEntity> getReservationEntityList() {
        return reservationEntityList;
    }

    public void setReservationEntityList(List<RoomReservationEntity> reservationEntityList) {
        this.reservationEntityList = reservationEntityList;
    }

    public void addReservationEntity(RoomReservationEntity reservationEntity) {
        if (null == reservationEntityList)
            reservationEntityList = new ArrayList<>();

        reservationEntityList.add(reservationEntity);
    }

}
