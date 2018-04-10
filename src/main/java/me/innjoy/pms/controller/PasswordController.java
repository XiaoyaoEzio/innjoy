package me.innjoy.pms.controller;

import me.innjoy.pms.service.MeituanApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *
 */
@RestController
@RequestMapping("/password")
public class PasswordController {
    private MeituanApiService meituanApiService;

    public PasswordController(MeituanApiService meituanApiService) {
        this.meituanApiService = meituanApiService;
    }

    @GetMapping("/customerPassword")
    public void queryCustomerPassword() throws IOException {
        meituanApiService.queryCustomerPassword();
    }

    @PostMapping("/managerPassword")
    public void setManagerPassword() throws IOException {
        meituanApiService.setManagerPassword();
    }

    @GetMapping("/managerPassword")
    public void getManagerPassword() throws IOException {
        meituanApiService.getManagerPassword();
    }

    @GetMapping("/temporaryPassword")
    public void getTemporaryPassword() throws IOException {
        meituanApiService.getTemporaryPassword();
    }
}
