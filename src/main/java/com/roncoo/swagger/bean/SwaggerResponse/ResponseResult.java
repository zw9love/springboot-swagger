package com.roncoo.swagger.bean.SwaggerResponse;

import com.roncoo.swagger.bean.SwaggerResponse.bean.Store;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zenngwei
 * @date 2019/6/10
 */


@ApiModel(value = "ResponseResult",parent = ResponseObject.class)
public class ResponseResult extends ResponseObject {

    @ApiModelProperty(value = "数据列表",dataType = "List")
    private PageResponse<Store> result;

    public PageResponse<Store> getResult() {
        return result;
    }

    public void setResult(PageResponse<Store> result) {
        this.result = result;
    }

    public ResponseResult(int code, String message) {
        super(code, message);
    }

//    public PageResponse<Store> getResult() {
//        return result;
//    }
//
//    public void setResult(PageResponse<Store> result) {
//        this.result = result;
//    }
}
