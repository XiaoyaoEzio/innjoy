package me.innjoy.pms.params;

import com.meituan.hotel.lock.client.params.BaseQueryParam;

/**
 *
 */
public class QueryOpenDoorLogParam extends BaseQueryParam {
    private String startTime;
    private String endTime;
    private Integer pageIndex;
    private Integer pageSize;

    public QueryOpenDoorLogParam() {
    }

    public QueryOpenDoorLogParam(String startTime, String endTime, Integer pageIndex, Integer pageSize) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
