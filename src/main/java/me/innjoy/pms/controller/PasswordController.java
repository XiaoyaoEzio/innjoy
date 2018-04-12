package me.innjoy.pms.controller;

import com.meituan.hotel.lock.client.params.EnableCustomerPasswordParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.service.MeituanApiService;
import me.innjoy.pms.service.PasswordService;
import me.innjoy.pms.utils.EnableCustomerPasswordParamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/password")
public class PasswordController {
    private MeituanApiService meituanApiService;
    private PasswordService passwordService;

    public PasswordController(MeituanApiService meituanApiService, PasswordService passwordService) {
        this.meituanApiService = meituanApiService;
        this.passwordService = passwordService;
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

    /**
     * 设置（启用）用户密码
     */
    @PostMapping("/customerPassword")
    public ResultDto enableCustomerPassword(EnableCustomerPasswordParam param) throws IOException {
        ResultDto verifyResult = EnableCustomerPasswordParamUtils.verifyNull(param);
        // 参数验证失败，直接返回
        if (verifyResult.getCode() == 1) {
            return verifyResult;
        }

        ResultDto result = passwordService.enableCustomerPassword(param);
        return result;
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
