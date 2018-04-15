package me.innjoy.pms.pojo.result;

import com.meituan.hotel.lock.client.results.CustomerPasswordResult;

/**
 *
 */
public class ValidTimeCustomerPasswordResult extends CustomerPasswordResult {
    private Long validTime;

    public Long getValidTime() {
        return validTime;
    }

    public void setValidTime(Long validTime) {
        this.validTime = validTime;
    }
}
