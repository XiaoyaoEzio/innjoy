package me.innjoy.pms.controller;

import com.meituan.hotel.lock.client.params.BaseQueryParam;
import com.meituan.hotel.lock.client.params.CustomerPasswordParam;
import com.meituan.hotel.lock.client.params.EnableCustomerPasswordParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.service.MeituanApiService;
import me.innjoy.pms.service.PasswordService;
import me.innjoy.pms.utils.ParamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    /**
     * 设置（启用）客人密码
     */
    @PostMapping("/customer")
    public ResultDto enableCustomerPassword(EnableCustomerPasswordParam param) throws IOException {
        // todo 测试阶段取消验证
        /*ResultDto verifyResult = ParamUtils.verifyNull(param);
        // 参数验证失败，直接返回
        if (verifyResult.getCode() == 1) {
            return verifyResult;
        }*/
        return passwordService.enableCustomerPassword(param);
    }

    /**
     * 查询客人密码
     */
    @GetMapping("/customer")
    public ResultDto queryCustomerPassword(BaseQueryParam param) throws IOException {
        ResultDto verifyResult = ParamUtils.verifyNull(param);
        if (verifyResult.getCode() == 1) {
            return verifyResult;
        }
        return passwordService.queryCustomerPassword(param);
    }

    /**
     * 停用客人密码
     */
    @DeleteMapping("/customer")
    public ResultDto disableCustomerPassword(CustomerPasswordParam param) throws IOException {
        // todo 测试
        /*ResultDto verifyResult = ParamUtils.verifyNull(param);
        if (verifyResult.getCode() == 1) {
            return verifyResult;
        }*/
        return passwordService.disableCustomerPassword(param);
    }

    /**
     * 设置管家密码
     */
    @PostMapping("/manager")
    public ResultDto sendManagerPassword(BaseQueryParam param) throws IOException {
        ResultDto verifyResult = ParamUtils.verifyNull(param);
        if (verifyResult.getCode() == 1) {
            return verifyResult;
        }
        return passwordService.sendManagerPassword(param);
    }

    /**
     * 查询管家密码
     */
    @GetMapping("/manager")
    public ResultDto queryManagerPassword(BaseQueryParam param) throws IOException {
        ResultDto verifyResult = ParamUtils.verifyNull(param);
        if (verifyResult.getCode() == 1) {
            return verifyResult;
        }
        return passwordService.queryManagerPassword(param);
    }

    /**
     * 查询临时密码，可以开反锁
     */
    @GetMapping("/temporary")
    public ResultDto getTemporaryPassword(BaseQueryParam param) throws IOException {
        ResultDto verifyResult = ParamUtils.verifyNull(param);
        if (verifyResult.getCode() == 1) {
            return verifyResult;
        }
        return passwordService.queryTemporaryPassword(param);
    }
}
