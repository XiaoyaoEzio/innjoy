package me.innjoy.pms.test;

import com.alibaba.fastjson.JSON;
import me.innjoy.pms.pojo.params.RoomParam;
import me.innjoy.pms.pojo.params.UpdateRoomListParam;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestListToString {
    @Test
    public void name() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("1001");
        list.add("1001");
        list.add("1001");
        System.out.println(JSON.toJSONString(list));

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

        String a = "\"\"";
        UpdateRoomListParam updateRoomListParam = new UpdateRoomListParam();
        updateRoomListParam.setRooms(JSON.toJSONString(roomList));
        System.out.println(updateRoomListParam);
        System.out.println(JSON.toJSONString(updateRoomListParam));
    }
}
