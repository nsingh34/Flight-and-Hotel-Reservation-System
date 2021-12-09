package com.project.travel.rest;

import com.project.travel.entity.RoomEntity;
import com.project.travel.entity.RoomReservationEntity;
import com.project.travel.model.request.RoomReservationRequest;
import com.project.travel.model.response.ReservableRoomResponse;
import com.project.travel.model.response.RoomReservationResponse;
import com.project.travel.repository.PageableRoomRepository;
import com.project.travel.repository.RoomRepository;
import com.project.travel.repository.RoomReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class RoomReservationResource {

    @Autowired
    PageableRoomRepository pageableRoomRepository;

    @Autowired
    ConversionService conversionService;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomReservationRepository roomReservationRepository;

    @RequestMapping(path = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservableRoomResponse> getAvailableRoom(
            @RequestParam(value = "checkin") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate checkin,
            @RequestParam(value = "checkout") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate checkout,
            Pageable pageable){

        Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
        List<RoomEntity> roomEntityList1 = roomEntityList.toList();
        List<ReservableRoomResponse> toBeReturned = new ArrayList<>();

        for(RoomEntity roomEntity:roomEntityList1){
            ReservableRoomResponse reservableRoomResponse = conversionService.convert(roomEntity,ReservableRoomResponse.class);
            toBeReturned.add(reservableRoomResponse);
        }

        Page<ReservableRoomResponse> page = new PageImpl<>(toBeReturned);

        return page;
    }

    @RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RoomEntity> getRoomById(
            @PathVariable
                    Long roomId) {

        RoomEntity roomEntity = roomRepository.findById(roomId).get();

        return new ResponseEntity<>(roomEntity, HttpStatus.OK);
    }

    @RequestMapping(path = "",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RoomReservationResponse> createRoomReservation(
            @RequestBody RoomReservationRequest roomReservationRequest){
        RoomReservationEntity roomReservationEntity = conversionService.convert(roomReservationRequest,RoomReservationEntity.class);
        roomReservationRepository.save(roomReservationEntity);

        Optional<RoomEntity> roomEntity = roomRepository.findById(roomReservationRequest.getRoomId());
        roomEntity.get().addReservationEntity(roomReservationEntity);
        roomRepository.save(roomEntity.get());
        roomReservationEntity.setRoomEntity(roomEntity.get());

        RoomReservationResponse roomReservationResponse =
                conversionService.convert(roomReservationEntity, RoomReservationResponse.class);


        return new ResponseEntity<>(roomReservationResponse, HttpStatus.CREATED);
    }

    @RequestMapping(path = "",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableRoomResponse> updateRoomReservation(
            @RequestBody RoomReservationRequest roomReservationRequest){
        return new ResponseEntity<>(new ReservableRoomResponse(),HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRoomReservation(
            @PathVariable long reservationId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
