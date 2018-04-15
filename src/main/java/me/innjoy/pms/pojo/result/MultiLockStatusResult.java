package me.innjoy.pms.pojo.result;

/**
 *
 */
public class MultiLockStatusResult extends BatteryLockStatusResult {
    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
