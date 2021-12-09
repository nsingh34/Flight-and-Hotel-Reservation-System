package com.project.travel.converter;


import com.project.travel.entity.RoomReservationEntity;
import com.project.travel.model.request.RoomReservationRequest;
import org.springframework.core.convert.converter.Converter;


public class RoomReservationRequestToRoomReservationEntityConverter implements Converter<RoomReservationRequest, RoomReservationEntity> {

    @Override
    public RoomReservationEntity convert(RoomReservationRequest source) {
        RoomReservationEntity roomReservationEntity = new RoomReservationEntity();

        roomReservationEntity.setCheckin(source.getCheckin());
        roomReservationEntity.setCheckout(source.getCheckout());

        if(source.getId() != null){
            roomReservationEntity.setId(source.getId());
        }

        return roomReservationEntity;
    }
}
