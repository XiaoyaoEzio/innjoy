package me.innjoy.pms.controller;

import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.pojo.entity.RoomEntity;
import me.innjoy.pms.service.MeituanApiService;
import me.innjoy.pms.service.RoomService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/room")
public class RoomController {
    private MeituanApiService meituanApiService;
    private RoomService roomService;

    @Autowired
    public RoomController(MeituanApiService meituanApiService, RoomService roomService) {
        this.meituanApiService = meituanApiService;
        this.roomService = roomService;
    }

    @PostMapping()
    public ResultDto addRoom(RoomEntity roomEntity) {
        if (roomEntity == null) {
            return ResultDto.failure("房间信息为空");
        }
        ResultDto resultDto = roomService.addRoom(roomEntity);
        return resultDto;
    }

    @PutMapping("/list")
    public void updateRoom() throws IOException {
        meituanApiService.updateRoomInfo();
    }


    /**
     * 查看房间信息
     */
    @GetMapping("/{roomId}")
    public ResultDto catRoom(@PathVariable("roomId") String roomId) {
        if (StringUtils.isBlank(roomId)) {
            return ResultDto.failure("roomId 为空");
        }
        RoomEntity room = roomService.findByRoomId(roomId);
        if (room == null) {
            return ResultDto.failure("未查询到房间");
        }
        return ResultDto.success(room);
    }
}
