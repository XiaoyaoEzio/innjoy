package me.innjoy.pms.test;

import com.alibaba.fastjson.JSON;
import me.innjoy.pms.params.RoomParam;
import me.innjoy.pms.params.UpdateRoomListParam;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestApi {
    @Test
    public void name() throws Exception {
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
        updateRoomListParam.setAppId("ispms");
        updateRoomListParam.setRooms(JSON.toJSONString(roomList));
        updateRoomListParam.setTimestamp(System.currentTimeMillis());
        System.out.println(updateRoomListParam.toString());

        System.out.println(JSON.toJSON(updateRoomListParam).toString());
        System.out.println(JSON.toJSONString(updateRoomListParam));
    }
}
