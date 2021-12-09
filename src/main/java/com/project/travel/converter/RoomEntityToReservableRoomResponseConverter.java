package com.project.travel.converter;

import com.project.travel.entity.RoomEntity;
import com.project.travel.model.Links;
import com.project.travel.model.Self;
import com.project.travel.model.response.ReservableRoomResponse;
import com.project.travel.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;


public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

    @Override
    public ReservableRoomResponse convert(RoomEntity source) {

        ReservableRoomResponse reservableRoomResponse = new ReservableRoomResponse();
        reservableRoomResponse.setRoomNumber(source.getRoomNumber());
        reservableRoomResponse.setPrice(Integer.valueOf(source.getPrice()));

        Links links = new Links();
        Self self =  new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
        links.setSelf(self);

        reservableRoomResponse.setLinks(links);

        return reservableRoomResponse;
    }
}
