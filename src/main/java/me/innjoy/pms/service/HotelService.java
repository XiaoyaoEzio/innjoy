package me.innjoy.pms.service;

import me.innjoy.pms.pojo.entity.HotelEntity;
import me.innjoy.pms.pojo.entity.RoomEntity;

import java.util.List;

/**
 *
 */
public interface HotelService {
    List<HotelEntity> listHotels();

    List<RoomEntity> listRooms(String hotelId);
}
