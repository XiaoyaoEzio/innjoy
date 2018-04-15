package me.innjoy.pms.pojo.result;

import com.meituan.hotel.lock.client.results.LockStatusResult;

/**
 *
 */
public class BatteryLockStatusResult extends LockStatusResult {
    private Integer lockBattery;

    public Integer getLockBattery() {
        return lockBattery;
    }

    public void setLockBattery(Integer lockBattery) {
        this.lockBattery = lockBattery;
    }


}
