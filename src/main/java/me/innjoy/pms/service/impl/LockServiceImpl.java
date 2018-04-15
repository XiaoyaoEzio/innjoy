package me.innjoy.pms.service.impl;

import com.alibaba.fastjson.JSON;
import com.meituan.hotel.lock.client.params.BaseQueryParam;
import com.meituan.hotel.lock.client.results.APIResult;
import com.meituan.hotel.lock.client.results.OpenDoorResult;
import me.innjoy.pms.consts.MeituanUriConsts;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.pojo.params.QueryLockStatusListParam;
import me.innjoy.pms.pojo.params.QueryMultiLockStatusParam;
import me.innjoy.pms.pojo.result.BatteryLockStatusResult;
import me.innjoy.pms.service.LockService;
import me.innjoy.pms.utils.HttpUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ResultDto queryLockStatus(BaseQueryParam param) {
        APIResult<BatteryLockStatusResult> apiResult = HttpUtils.sendRequest(MeituanUriConsts
                .QUERY_LOCK_STATUS, param, BatteryLockStatusResult.class);
        return HttpUtils.reverse(apiResult);
    }

    @Override
    public ResultDto queryLockStatusList(QueryLockStatusListParam param) {
        QueryMultiLockStatusParam mParam = new QueryMultiLockStatusParam();
        mParam.setHotelId(param.getHotelId());
        mParam.setRoomIds(JSON.toJSONString(JSON.toJSONString(param.getRoomId())));
        APIResult<List> apiResult = HttpUtils.sendRequest(MeituanUriConsts
                .QUERY_MULTI_LOCK_STATUS, mParam, List.class);
        return HttpUtils.reverse(apiResult);
    }
}
