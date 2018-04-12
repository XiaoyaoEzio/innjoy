package me.innjoy.pms.service;

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
}
