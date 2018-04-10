package me.innjoy.pms.pojo.entity;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "room", schema = "innjoy")
public class RoomEntity {
    private String hotelId;
    private String roomId;
    private String uploadPhoto;
    private String cameraPhoto;
    private String lockId;
    private String roomAddress;

    @Basic
    @Column(name = "hotel_id", nullable = false, length = 11)
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Id
    @Column(name = "room_id", nullable = false, length = 11)
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "upload_photo", nullable = true, length = 255)
    public String getUploadPhoto() {
        return uploadPhoto;
    }

    public void setUploadPhoto(String uploadPhoto) {
        this.uploadPhoto = uploadPhoto;
    }

    @Basic
    @Column(name = "camera_photo", nullable = true, length = 255)
    public String getCameraPhoto() {
        return cameraPhoto;
    }

    public void setCameraPhoto(String cameraPhoto) {
        this.cameraPhoto = cameraPhoto;
    }

    @Basic
    @Column(name = "lock_id", nullable = true, length = 255)
    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    @Basic
    @Column(name = "room_address", nullable = true, length = 255)
    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (uploadPhoto != null ? !uploadPhoto.equals(that.uploadPhoto) : that.uploadPhoto != null) return false;
        if (cameraPhoto != null ? !cameraPhoto.equals(that.cameraPhoto) : that.cameraPhoto != null) return false;
        if (lockId != null ? !lockId.equals(that.lockId) : that.lockId != null) return false;
        if (roomAddress != null ? !roomAddress.equals(that.roomAddress) : that.roomAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelId != null ? hotelId.hashCode() : 0;
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (uploadPhoto != null ? uploadPhoto.hashCode() : 0);
        result = 31 * result + (cameraPhoto != null ? cameraPhoto.hashCode() : 0);
        result = 31 * result + (lockId != null ? lockId.hashCode() : 0);
        result = 31 * result + (roomAddress != null ? roomAddress.hashCode() : 0);
        return result;
    }
}
