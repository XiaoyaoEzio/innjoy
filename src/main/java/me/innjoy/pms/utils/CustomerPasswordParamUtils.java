package me.innjoy.pms.utils;

import com.meituan.hotel.lock.client.params.CustomerPasswordParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class CustomerPasswordParamUtils {
    public static ResultDto verifyNull(CustomerPasswordParam param) {
        if (StringUtils.isBlank(param.getChannelOrderNo())) {
            return ResultDto.failure("channelOrderNo 为空");
        }
        if (param.getCheckInTime() == null) {
            return ResultDto.failure("checkInTime 为空");
        }
        if (param.getCheckOutTime() == null) {
            return ResultDto.failure("checkInOut 为空");
        }
        return BaseQueryParamUtils.verifyNull(param);
    }
}
