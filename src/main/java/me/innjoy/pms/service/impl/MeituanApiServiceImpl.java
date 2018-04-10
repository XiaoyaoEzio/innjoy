package me.innjoy.pms.service.impl;

import com.alibaba.fastjson.JSON;
import com.meituan.hotel.lock.client.params.*;
import me.innjoy.pms.params.QueryOpenDoorLogParam;
import me.innjoy.pms.params.RoomParam;
import me.innjoy.pms.params.UpdateRoomListParam;
import me.innjoy.pms.service.MeituanApiService;
import me.innjoy.pms.utils.PostUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class MeituanApiServiceImpl implements MeituanApiService {
    private Logger logger = LoggerFactory.getLogger(MeituanApiServiceImpl.class);

    @Override
    public void updateRoomInfo() throws IOException {
        System.out.println(" ");
        String url = "/room/updateRoomList";
        List<RoomParam> roomList = new ArrayList<>();
        RoomParam room = new RoomParam(
                "001",
                "测试公寓",
                "001",
                "1001",
                "1001",
                "大床房",
                0,
                "西安");
        roomList.add(room);

        UpdateRoomListParam updateRoomListParam = new UpdateRoomListParam();
        updateRoomListParam.setRooms(JSON.toJSONString(roomList));
        updateRoomListParam.setTimestamp(System.currentTimeMillis());

        Map<String, String> map = PostUtils.executePost(url, updateRoomListParam);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }

    @Override
    public String openDoor() throws IOException {
        OpenDoorParam openDoorParam = new OpenDoorParam();
        openDoorParam.setTimestamp(System.currentTimeMillis());
        openDoorParam.setHotelId("001");
        openDoorParam.setRoomId("1001");

        String url = "/lock/openDoor";
        Map<String, String> map = PostUtils.executePost(url, openDoorParam);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        logger.info(response);
        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
        return response;
    }

    @Override
    public void enableCustomerPassword() throws IOException {
        long aDay = 24 * 60 * 60 * 1000L;
        long now = System.currentTimeMillis();
        EnableCustomerPasswordParam param = new EnableCustomerPasswordParam();
        param.setChannelOrderNo("123456");
        param.setCheckInTime(1521787935572L);
        param.setCheckOutTime(1521874335572L);
        param.setContactName("特朗普");
        param.setContactMobile("13279797979");
        param.setHotelId("001");
        param.setRoomId("1001");
        param.setTimestamp(now);

        String url = "/lock/enableCustomerPassword";
        Map<String, String> map = PostUtils.executePost(url, param);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }

    @Override
    public Map<String, String> disableCustomerPassword() throws IOException {
        DisableCustomerPasswordParam param = new DisableCustomerPasswordParam();
        param.setChannelOrderNo("123456");
        param.setCheckInTime(1521787935572L);
        param.setCheckOutTime(1521874335572L);
        param.setHotelId("001");
        param.setRoomId("1001");

        String url = "/lock/disableCustomerPassword";
        return PostUtils.executePost(url, param);

    }

    @Override
    public void queryCustomerPassword() throws IOException {
        BaseQueryParam param = new OpenDoorParam();
        param.setHotelId("001");
        param.setRoomId("1001");

        String url = "/lock/queryCustomerPassword";
        Map<String, String> map = PostUtils.executePost(url, param);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }

    @Override
    public void setManagerPassword() throws IOException {
        long exp = 5 * 60 * 1000L;
        long now = System.currentTimeMillis();
        SendManagerPasswordParam param = new SendManagerPasswordParam();
        param.setManagerPassword("123456");
        param.setValidTime((now + exp) / 1000L);
        param.setHotelId("001");
        param.setRoomId("1001");

        String url = "/lock/sendManagerPassword";
        Map<String, String> map = PostUtils.executePost(url, param);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }

    @Override
    public void getManagerPassword() throws IOException {
        BaseQueryParam param = new OpenDoorParam();
        param.setHotelId("001");
        param.setRoomId("1001");

        String url = "/lock/queryManagerPassword";
        Map<String, String> map = PostUtils.executePost(url, param);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }

    @Override
    public void getTemporaryPassword() throws IOException {
        BaseQueryParam param = new OpenDoorParam();
        param.setHotelId("001");
        param.setRoomId("1001");

        String url = "/lock/queryTemporaryPassword";
        Map<String, String> map = PostUtils.executePost(url, param);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }

    @Override
    public void queryLockStatus() throws IOException {
        BaseQueryParam param = new OpenDoorParam();
        param.setHotelId("001");
        param.setRoomId("1001");

        String url = "/lock/queryLockStatus";
        Map<String, String> map = PostUtils.executePost(url, param);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }

    @Override
    public void queryOpenDoorLog() throws IOException {
        QueryOpenDoorLogParam param = new QueryOpenDoorLogParam();
        param.setHotelId("001");
        param.setRoomId("1001");
        param.setPageIndex(1);
        param.setPageSize(10);

        String url = "/lock/queryOpenDoorLog";
        Map<String, String> map = PostUtils.executePost(url, param);
        Integer code = Integer.valueOf(map.get("code"));
        String response = map.get("response");

        System.out.println(" ");
        System.out.println(code);
        System.out.println(response);
    }
}
