package me.innjoy.pms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.meituan.hotel.lock.client.common.APIResultCode;
import com.meituan.hotel.lock.client.params.BaseQueryParam;
import com.meituan.hotel.lock.client.params.CustomerPasswordParam;
import com.meituan.hotel.lock.client.params.EnableCustomerPasswordParam;
import com.meituan.hotel.lock.client.params.SendManagerPasswordParam;
import com.meituan.hotel.lock.client.results.*;
import me.innjoy.pms.consts.MeituanUriConsts;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.service.PasswordService;
import me.innjoy.pms.utils.HttpUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 */
@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public ResultDto enableCustomerPassword(EnableCustomerPasswordParam param) {
        // todo 测试数据
        param.setContactName("特朗普");
        param.setContactMobile("13200009999");
        param.setChannelOrderNo("123345");
        param.setCheckInTime(System.currentTimeMillis());

        // 日期加一天
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 1);
        param.setCheckOutTime(c.getTimeInMillis());

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

    @Override
    public ResultDto disableCustomerPassword(CustomerPasswordParam param) {
        // todo 测试数据
        param.setChannelOrderNo("123345");
        param.setCheckInTime(System.currentTimeMillis());

        // 日期加一天
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 1);
        param.setCheckOutTime(c.getTimeInMillis());

        APIResult<DisableCustomerPasswordResult> apiResult = HttpUtils.sendRequest
                (MeituanUriConsts.DISABLE_CUSTOMER_PASSWORD, param, DisableCustomerPasswordResult.class);
        return HttpUtils.reverse(apiResult);
    }

    @Override
    public ResultDto sendManagerPassword(BaseQueryParam baseQueryParam) {
        // todo 密码
        SendManagerPasswordParam param = new SendManagerPasswordParam();
        param.setRoomId(baseQueryParam.getRoomId());
        param.setHotelId(baseQueryParam.getHotelId());
        String pwd = getManagerPassword();
        param.setManagerPassword(pwd);
        long fiveMinutes = 5 * 60 * 1000L;
        param.setValidTime((System.currentTimeMillis() + fiveMinutes) / 1000L);

        APIResult<SendManagerPasswordResult> apiResult = HttpUtils.sendRequest
                (MeituanUriConsts.SEND_MANAGER_PASSWORD, param, SendManagerPasswordResult.class);

        if (APIResultCode.SUCCESS.getCode() == apiResult.getStatus()) {
            JSONObject json = new JSONObject();
            json.put("managerPassword", pwd);
            return ResultDto.success(json);
        } else {
            return HttpUtils.reverse(apiResult);
        }
    }

    @Override
    public ResultDto queryManagerPassword(BaseQueryParam param) {
        // todo 有效期处理
        APIResult<ManagerPasswordResult> apiResult = HttpUtils.sendRequest(MeituanUriConsts
                .QUERY_MANAGER_PASSWORD, param, ManagerPasswordResult.class);
        Long validTime = apiResult.getData().getValidTime();
        long now = System.currentTimeMillis();
        long time = (validTime - now / 1000L) / 60 + 1;
        System.out.println(time);
        apiResult.getData().setValidTime(time);
        return HttpUtils.reverse(apiResult);
    }

    private String getManagerPassword() {
        // 随机获得 0 - 899999 的数字，加 100000 后获得 100000 - 999999 的数字
        return String.valueOf(new Random().nextInt(900000) + 100000);
    }
}
