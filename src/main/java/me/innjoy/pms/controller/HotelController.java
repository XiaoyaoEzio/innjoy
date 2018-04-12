package me.innjoy.pms.controller;

import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.pojo.entity.HotelEntity;
import me.innjoy.pms.pojo.entity.RoomEntity;
import me.innjoy.pms.service.HotelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {
    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(value = "/list")
    public ResultDto listRooms() {
        List<HotelEntity> list = hotelService.listHotels();
        if (list == null) {
            ResultDto resultDto = ResultDto.failure("没有酒店信息");
            System.out.println(resultDto);
            return resultDto;
        }
        ResultDto resultDto = ResultDto.success(list);
        System.out.println(resultDto);
        return resultDto;
    }

    @GetMapping("/{id}")
    public ResultDto catRooms(@PathVariable("id") String hotelId) {
        if (StringUtils.isBlank(hotelId)) {
            return ResultDto.failure("id 为空");
        }
        List<RoomEntity> rooms = hotelService.listRooms(hotelId);
        if (rooms == null) {
            return ResultDto.failure("没有房间");
        }
        return ResultDto.success(rooms);
    }
}
