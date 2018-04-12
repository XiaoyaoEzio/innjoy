package me.innjoy.pms.service.impl;

import com.meituan.hotel.lock.client.params.EnableCustomerPasswordParam;
import com.meituan.hotel.lock.client.results.EnableCustomerPasswordResult;
import me.innjoy.pms.consts.MeituanUriConsts;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.service.PasswordService;
import me.innjoy.pms.utils.HttpUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public ResultDto enableCustomerPassword(EnableCustomerPasswordParam param) {
        return HttpUtils.sendRequest
                (MeituanUriConsts.ENABLE_CUSTOMER_PASSWORD, param, EnableCustomerPasswordResult.class);
    }
}
