package me.innjoy.pms.service;

import com.meituan.hotel.lock.client.params.BaseQueryParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.pojo.params.QueryLockStatusListParam;

/**
 *
 */
public interface LockService {
    ResultDto openDoor(BaseQueryParam param);

    ResultDto queryLockStatus(BaseQueryParam param);

    ResultDto queryLockStatusList(QueryLockStatusListParam param);
}
