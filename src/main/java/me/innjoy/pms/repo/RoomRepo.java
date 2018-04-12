package me.innjoy.pms.repo;

import me.innjoy.pms.pojo.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface RoomRepo extends JpaRepository<RoomEntity, String> {
    List<RoomEntity> findAllByHotelId(String hotelId);

    RoomEntity findByRoomId(String roomId);
}
