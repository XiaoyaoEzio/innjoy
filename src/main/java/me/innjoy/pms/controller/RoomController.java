package me.innjoy.pms.controller;

import me.innjoy.pms.service.MeituanApiService;
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

    public RoomController(MeituanApiService meituanApiService) {
        this.meituanApiService = meituanApiService;
    }

    @PutMapping("/list")
    public void updateRoom() throws IOException {
        meituanApiService.updateRoomInfo();
    }


    @PostMapping("/customerPassword")
    public void enableCustomerPassword() throws IOException {
        meituanApiService.enableCustomerPassword();
    }

    @DeleteMapping("/customerPassword")
    public void disableCustomerPassword() throws IOException {
        Map<String, String> map = meituanApiService.disableCustomerPassword();
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }
}
