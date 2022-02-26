package br.com.uniesp.entidate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class PageResponse {

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("per_page")
    private Integer per_page;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("total_pages")
    private Integer total_pages;

    @JsonProperty("data")
    private List<UnknownResponse> data;

    @JsonProperty("support")
    private Map<String, String> support;

    public PageResponse() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public List<UnknownResponse> getData() {
        return data;
    }

    public void setData(List<UnknownResponse> data) {
        this.data = data;
    }
}
