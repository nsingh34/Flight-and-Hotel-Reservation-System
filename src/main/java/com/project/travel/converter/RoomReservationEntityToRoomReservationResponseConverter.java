package com.project.travel.converter;

import com.project.travel.entity.RoomReservationEntity;
import com.project.travel.model.response.RoomReservationResponse;
import org.springframework.core.convert.converter.Converter;

public class RoomReservationEntityToRoomReservationResponseConverter implements Converter<RoomReservationEntity, RoomReservationResponse> {
    @Override
    public RoomReservationResponse convert(RoomReservationEntity source) {
        RoomReservationResponse roomReservationResponse = new RoomReservationResponse();
        roomReservationResponse.setCheckin(source.getCheckin());
        roomReservationResponse.setCheckout(source.getCheckout());
        if (null != source.getRoomEntity())
            roomReservationResponse.setId(source.getRoomEntity().getId());
        return roomReservationResponse;
    }
}
