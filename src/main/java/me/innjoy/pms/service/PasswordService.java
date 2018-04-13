package me.innjoy.pms.service;

import com.meituan.hotel.lock.client.params.BaseQueryParam;
import com.meituan.hotel.lock.client.params.CustomerPasswordParam;
import com.meituan.hotel.lock.client.params.EnableCustomerPasswordParam;
import me.innjoy.pms.pojo.dto.ResultDto;

/**
 *
 */
public interface PasswordService {
    /**
     * 启用客户密码
     */
    ResultDto enableCustomerPassword(EnableCustomerPasswordParam param);

    /**
     * 查询客户密码
     */
    ResultDto queryCustomerPassword(BaseQueryParam param);

    /**
     * 查询临时密码
     */
    ResultDto queryTemporaryPassword(BaseQueryParam param);


    ResultDto disableCustomerPassword(CustomerPasswordParam param);

    ResultDto sendManagerPassword(BaseQueryParam param);

    ResultDto queryManagerPassword(BaseQueryParam param);
}
