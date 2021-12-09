package com.project.travel.repository;

import com.project.travel.entity.RoomReservationEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomReservationRepository extends CrudRepository<RoomReservationEntity,Long> {
}
