package com.wyl.tms.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Created by Yhw on 2019-04-22
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value = {"page_no", "page_total", "total", "page_size", "data"})
public class DataList<T> {

    public List<T> data;

    @JsonProperty("next_id")
    public Long nextId;

    @JsonProperty("page_index")
    public Integer pageIndex;

    @JsonProperty("page_no")
    public Integer pageNo;

    @JsonProperty("page_size")
    public Integer pageSize;

    public Integer total;

    @JsonProperty("page_total")
    public Integer pageTotal;

    public DataList() {

    }

    public DataList(List<T> data) {
        this.data = data;
    }

    public DataList(Integer pageIndex, Integer total, List<T> data) {
        this.pageIndex = pageIndex;
        this.total = total;
        this.data = data;
    }

    public DataList(Long nextId, List<T> data) {
        this.nextId = nextId;
        this.data = data;
    }

    public DataList(List<T> data, Integer pageIndex, Integer pageSize, Integer total) {
        this.data = data;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
    }

    public DataList(Integer pageNo, Integer pageTotal, Integer pageSize, Integer total, List<T> data) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }
}
