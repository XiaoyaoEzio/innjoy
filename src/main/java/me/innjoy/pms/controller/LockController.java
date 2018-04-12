package me.innjoy.pms.controller;

import com.meituan.hotel.lock.client.params.BaseQueryParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.service.LockService;
import me.innjoy.pms.service.MeituanApiService;
import me.innjoy.pms.utils.BaseQueryParamUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    private LockService lockService;

    @Autowired
    public LockController(MeituanApiService meituanApiService, LockService lockService) {
        this.meituanApiService = meituanApiService;
        this.lockService = lockService;
    }

    @GetMapping("/status")
    public void getLockStatus() throws IOException {
        meituanApiService.queryLockStatus();
    }

    @GetMapping("/open")
    public ResultDto openDoor(BaseQueryParam param) throws IOException {
        ResultDto resultDto = BaseQueryParamUtils.verifyNull(param);
        if (resultDto.getCode() == 1) {
            return resultDto;
        }
        return lockService.openDoor(param);
    }

    @GetMapping("/openDoorLog")
    public void getOpenDoorLog() throws IOException {
        meituanApiService.queryOpenDoorLog();
    }
}
