package me.innjoy.pms.utils;

import com.meituan.hotel.lock.client.params.EnableCustomerPasswordParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class EnableCustomerPasswordParamUtils {
    public static ResultDto verifyNull(EnableCustomerPasswordParam param) {
        if (StringUtils.isBlank(param.getContactMobile())) {
            return ResultDto.failure("contactMobile 为空");
        }
        if (StringUtils.isBlank(param.getContactName())) {
            return ResultDto.failure("contactName 为空");
        }
        return CustomerPasswordParamUtils.verifyNull(param);
    }
}
