package me.innjoy.pms.pojo.params;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meituan.hotel.lock.client.common.BaseParam;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRoomListParam extends BaseParam {
    private String rooms;

    public UpdateRoomListParam() {
    }

    public UpdateRoomListParam(String rooms) {
        this.rooms = rooms;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "{rooms=\"" + rooms + "\", \n" +
                "timestamp=" + getTimestamp() + ", \n" +
                '}';
    }
}
