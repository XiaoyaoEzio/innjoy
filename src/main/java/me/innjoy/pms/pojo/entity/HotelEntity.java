package me.innjoy.pms.pojo.entity;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "hotel", schema = "innjoy")
public class HotelEntity {
    private String hotelId;
    private String hotelName;
    private String hotelAddress;

    @Id
    @Column(name = "hotel_id", nullable = false, length = 20)
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "hotel_name", nullable = false, length = 255)
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Basic
    @Column(name = "hotel_address", nullable = false, length = 255)
    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelEntity that = (HotelEntity) o;

        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (hotelName != null ? !hotelName.equals(that.hotelName) : that.hotelName != null) return false;
        if (hotelAddress != null ? !hotelAddress.equals(that.hotelAddress) : that.hotelAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelId != null ? hotelId.hashCode() : 0;
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (hotelAddress != null ? hotelAddress.hashCode() : 0);
        return result;
    }
}
