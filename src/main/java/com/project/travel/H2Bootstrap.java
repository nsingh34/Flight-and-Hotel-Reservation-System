package com.project.travel;

import com.project.travel.entity.RoomEntity;
import com.project.travel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
        roomRepository.save(new RoomEntity(405,"200"));
        roomRepository.save(new RoomEntity(406,"220"));
        roomRepository.save(new RoomEntity(407,"250"));
    }
}
