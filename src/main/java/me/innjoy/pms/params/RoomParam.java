package me.innjoy.pms.params;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomParam {
    private String hotelId;
    private String hotelName;
    private String partnerId;
    private String bizAccountId;
    private String bizLogin;
    private String roomId;
    private String roomName;
    private String roomTypeName;
    private Integer roomStatus;
    private String cityName;
    private Integer cityAdCode;

    public RoomParam() {
    }

    public RoomParam(String hotelId, String hotelName, String partnerId, String roomId, String roomName,
                     String roomTypeName, Integer roomStatus, String cityName) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.partnerId = partnerId;
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomTypeName = roomTypeName;
        this.roomStatus = roomStatus;
        this.cityName = cityName;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getBizAccountId() {
        return bizAccountId;
    }

    public void setBizAccountId(String bizAccountId) {
        this.bizAccountId = bizAccountId;
    }

    public String getBizLogin() {
        return bizLogin;
    }

    public void setBizLogin(String bizLogin) {
        this.bizLogin = bizLogin;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityAdCode() {
        return cityAdCode;
    }

    public void setCityAdCode(Integer cityAdCode) {
        this.cityAdCode = cityAdCode;
    }
}
