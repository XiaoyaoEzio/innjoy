package me.innjoy.pms.controller;

import me.innjoy.pms.service.MeituanApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *
 */
@RestController
@RequestMapping("/lock")
public class LockController {
    private MeituanApiService meituanApiService;

    public LockController(MeituanApiService meituanApiService) {
        this.meituanApiService = meituanApiService;
    }

    @GetMapping("/status")
    public void getLockStatus() throws IOException {
        meituanApiService.queryLockStatus();
    }

    @GetMapping("/open")
    public String openDoor() throws IOException {
        return meituanApiService.openDoor();
    }

    @GetMapping("/openDoorLog")
    public void getOpenDoorLog() throws IOException {
        meituanApiService.queryOpenDoorLog();
    }
}
