package me.innjoy.pms.utils;

import com.meituan.hotel.lock.client.params.BaseQueryParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class BaseQueryParamUtils {
    public static ResultDto verifyNull(BaseQueryParam param) {
        if (StringUtils.isBlank(param.getHotelId())) {
            return ResultDto.failure("hotelId 为空");
        }
        if (StringUtils.isBlank(param.getRoomId())) {
            return ResultDto.failure("roomId 为空");
        }
        return ResultDto.success();
    }
}
