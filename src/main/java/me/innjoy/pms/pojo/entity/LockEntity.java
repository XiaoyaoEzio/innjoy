package me.innjoy.pms.pojo.entity;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "lock", schema = "innjoy")
public class LockEntity {
    private String lockId;
    private String customerPassword;
    private String managerPassword;
    private String temporaryPassword;

    @Id
    @Column(name = "lock_id", nullable = false, length = 255)
    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    @Basic
    @Column(name = "customer_password", nullable = true, length = 255)
    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    @Basic
    @Column(name = "manager_password", nullable = true, length = 255)
    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    @Basic
    @Column(name = "temporary_password", nullable = true, length = 255)
    public String getTemporaryPassword() {
        return temporaryPassword;
    }

    public void setTemporaryPassword(String temporaryPassword) {
        this.temporaryPassword = temporaryPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LockEntity that = (LockEntity) o;

        if (lockId != null ? !lockId.equals(that.lockId) : that.lockId != null) return false;
        if (customerPassword != null ? !customerPassword.equals(that.customerPassword) : that.customerPassword != null)
            return false;
        if (managerPassword != null ? !managerPassword.equals(that.managerPassword) : that.managerPassword != null)
            return false;
        if (temporaryPassword != null ? !temporaryPassword.equals(that.temporaryPassword) : that.temporaryPassword !=
                null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lockId != null ? lockId.hashCode() : 0;
        result = 31 * result + (customerPassword != null ? customerPassword.hashCode() : 0);
        result = 31 * result + (managerPassword != null ? managerPassword.hashCode() : 0);
        result = 31 * result + (temporaryPassword != null ? temporaryPassword.hashCode() : 0);
        return result;
    }
}
