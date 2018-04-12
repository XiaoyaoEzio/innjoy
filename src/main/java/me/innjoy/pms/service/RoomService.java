package me.innjoy.pms.service;

import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.pojo.entity.RoomEntity;

/**
 *
 */
public interface RoomService {
    ResultDto addRoom(RoomEntity roomEntity);

    RoomEntity findByRoomId(String roomId);
}
