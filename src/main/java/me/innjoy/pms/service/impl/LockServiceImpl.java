package me.innjoy.pms.service.impl;

import com.meituan.hotel.lock.client.params.BaseQueryParam;
import com.meituan.hotel.lock.client.results.APIResult;
import com.meituan.hotel.lock.client.results.OpenDoorResult;
import me.innjoy.pms.consts.MeituanUriConsts;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.service.LockService;
import me.innjoy.pms.utils.HttpUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class LockServiceImpl implements LockService {
    @Override
    public ResultDto openDoor(BaseQueryParam param) {
        APIResult<OpenDoorResult> apiResult = HttpUtils.sendRequest(MeituanUriConsts.OPEN_DOOR, param,
                OpenDoorResult.class);
        return HttpUtils.reverse(apiResult);
    }
}
