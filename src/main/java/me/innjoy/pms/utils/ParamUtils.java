package me.innjoy.pms.utils;

import com.meituan.hotel.lock.client.common.BaseParam;
import com.meituan.hotel.lock.client.params.BaseQueryParam;
import com.meituan.hotel.lock.client.params.CustomerPasswordParam;
import com.meituan.hotel.lock.client.params.EnableCustomerPasswordParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class ParamUtils {
    public static <T extends BaseParam> ResultDto verifyNull(T param) {
        if (param instanceof EnableCustomerPasswordParam) {
            return verifyEcpp((EnableCustomerPasswordParam) param);
        }

        if (param instanceof CustomerPasswordParam) {
            return verifyCpp((CustomerPasswordParam) param);
        }

        if (param instanceof BaseQueryParam) {
            return verifyBqp((BaseQueryParam) param);
        }

        return ResultDto.failure("不支持判断");
    }

    private static ResultDto verifyEcpp(EnableCustomerPasswordParam param) {
        if (StringUtils.isBlank(param.getContactMobile())) {
            return ResultDto.failure("contactMobile 为空");
        }
        if (StringUtils.isBlank(param.getContactName())) {
            return ResultDto.failure("contactName 为空");
        }
        return verifyCpp(param);
    }

    private static ResultDto verifyCpp(CustomerPasswordParam param) {
        if (StringUtils.isBlank(param.getChannelOrderNo())) {
            return ResultDto.failure("channelOrderNo 为空");
        }
        if (param.getCheckInTime() == null) {
            return ResultDto.failure("checkInTime 为空");
        }
        if (param.getCheckOutTime() == null) {
            return ResultDto.failure("checkInOut 为空");
        }
        return verifyBqp(param);
    }

    private static ResultDto verifyBqp(BaseQueryParam param) {
        if (StringUtils.isBlank(param.getHotelId())) {
            return ResultDto.failure("hotelId 为空");
        }
        if (StringUtils.isBlank(param.getRoomId())) {
            return ResultDto.failure("roomId 为空");
        }
        return ResultDto.success();
    }
}
