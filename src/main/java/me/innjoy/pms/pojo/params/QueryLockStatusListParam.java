package me.innjoy.pms.pojo.params;

import com.meituan.hotel.lock.client.common.BaseParam;

import java.util.List;


/**
 *
 */
public class QueryLockStatusListParam extends BaseParam {
    private String hotelId;
    private List<String> roomId;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public List<String> getRoomId() {
        return roomId;
    }

    public void setRoomId(List<String> roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "QueryLockStatusListParam{" +
                "hotelId='" + hotelId + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
