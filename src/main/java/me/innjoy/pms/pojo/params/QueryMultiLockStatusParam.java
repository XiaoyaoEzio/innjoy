package me.innjoy.pms.pojo.params;

import com.meituan.hotel.lock.client.common.BaseParam;

/**
 *
 */
public class QueryMultiLockStatusParam extends BaseParam {
    private String hotelId;
    private String roomIds;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(String roomIds) {
        this.roomIds = roomIds;
    }
}
