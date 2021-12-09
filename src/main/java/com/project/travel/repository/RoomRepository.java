package com.project.travel.repository;

import com.project.travel.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<RoomEntity,Long> {
    Optional<RoomEntity> findById(Long id);
}
