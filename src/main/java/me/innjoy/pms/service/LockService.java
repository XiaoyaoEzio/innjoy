package me.innjoy.pms.service;

import com.meituan.hotel.lock.client.params.BaseQueryParam;
import me.innjoy.pms.pojo.dto.ResultDto;

/**
 *
 */
public interface LockService {
    ResultDto openDoor(BaseQueryParam param);
}
