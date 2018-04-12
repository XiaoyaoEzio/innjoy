package me.innjoy.pms.service.impl;

import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.pojo.entity.RoomEntity;
import me.innjoy.pms.repo.RoomRepo;
import me.innjoy.pms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepo roomRepo;

    @Autowired
    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public ResultDto addRoom(RoomEntity roomEntity) {
        roomEntity.getRoomId();
        return null;
    }

    @Override
    public RoomEntity findByRoomId(String roomId) {
        return roomRepo.findByRoomId(roomId);
    }
}
