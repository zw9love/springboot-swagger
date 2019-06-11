package com.roncoo.swagger.bean.SwaggerResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author zenngwei
 * @date 2019/6/5
 */


@ApiModel("PageResponse")
public class PageResponse<T> implements Serializable {
    @ApiModelProperty(value="是否有下一页")
    private boolean hasNextPage;
    @ApiModelProperty(value="是否有上一页")
    private boolean hasPreviousPage;
    @ApiModelProperty(value="是否第一页")
    private boolean isFirstPage;
    @ApiModelProperty(value="是否最后一页")
    private boolean isLastPage;
    @ApiModelProperty(value="页码（当前所处页号）。页码从1开始")
    private int pageNumber;
    @ApiModelProperty(value="每页显示数据量")
    private int pageSize;
    @ApiModelProperty(value="页面总数")
    private int pageTotal;
    @ApiModelProperty(value="行记录总数")
    private int rowCount;
    @ApiModelProperty(value="分页结果集")
    private List<T> result;

    public PageResponse() {
        super();
    }

//    public PageResponse(boolean hasNextPage, boolean hasPreviousPage, boolean isFirstPage, boolean isLastPage, int pageNumber, int pageSize, int pageTotal, int rowCount, Object result) {
//        this.hasNextPage = hasNextPage;
//        this.hasPreviousPage = hasPreviousPage;
//        this.isFirstPage = isFirstPage;
//        this.isLastPage = isLastPage;
//        this.pageNumber = pageNumber;
//        this.pageSize = pageSize;
//        this.pageTotal = pageTotal;
//        this.rowCount = rowCount;
//        this.result = result;
//    }

//    public PageResponse(boolean hasNextPage, boolean hasPreviousPage) {
//        this.hasNextPage = hasNextPage;
//        this.hasPreviousPage = hasPreviousPage;
//    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
