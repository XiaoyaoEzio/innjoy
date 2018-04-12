package me.innjoy.pms.service.impl;

import com.meituan.hotel.lock.client.params.BaseQueryParam;
import com.meituan.hotel.lock.client.params.EnableCustomerPasswordParam;
import com.meituan.hotel.lock.client.results.APIResult;
import com.meituan.hotel.lock.client.results.CustomerPasswordResult;
import com.meituan.hotel.lock.client.results.EnableCustomerPasswordResult;
import com.meituan.hotel.lock.client.results.TemporaryPasswordResult;
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
        APIResult<EnableCustomerPasswordResult> apiResult = HttpUtils.sendRequest
                (MeituanUriConsts.ENABLE_CUSTOMER_PASSWORD, param, EnableCustomerPasswordResult.class);

        return HttpUtils.reverse(apiResult);
    }

    @Override
    public ResultDto queryCustomerPassword(BaseQueryParam param) {
        APIResult<CustomerPasswordResult> apiResult = HttpUtils.sendRequest(MeituanUriConsts
                .QUERY_CUSTOMER_PASSWORD, param, CustomerPasswordResult.class);
        return HttpUtils.reverse(apiResult);
    }

    @Override
    public ResultDto queryTemporaryPassword(BaseQueryParam param) {
        APIResult<TemporaryPasswordResult> apiResult = HttpUtils.sendRequest(MeituanUriConsts
                .QUERY_TEMPORARY_PASSWORD, param, TemporaryPasswordResult.class);
        return HttpUtils.reverse(apiResult);
    }
}
