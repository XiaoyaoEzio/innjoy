package me.innjoy.pms.service.impl;

import me.innjoy.pms.pojo.entity.HotelEntity;
import me.innjoy.pms.pojo.entity.RoomEntity;
import me.innjoy.pms.repo.HotelRepo;
import me.innjoy.pms.repo.RoomRepo;
import me.innjoy.pms.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class HotelServiceImpl implements HotelService {
    private HotelRepo hotelRepo;
    private RoomRepo roomRepo;

    @Autowired
    public HotelServiceImpl(HotelRepo hotelRepo, RoomRepo roomRepo) {
        this.hotelRepo = hotelRepo;
        this.roomRepo = roomRepo;
    }

    @Override
    public List<HotelEntity> listHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public List<RoomEntity> listRooms(String hotelId) {
        return roomRepo.findAllByHotelId(hotelId);
    }
}
