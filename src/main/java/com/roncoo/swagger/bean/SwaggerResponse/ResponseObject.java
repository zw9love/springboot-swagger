package com.roncoo.swagger.bean.SwaggerResponse;

import com.roncoo.swagger.bean.SwaggerResponse.bean.Store;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zenngwei
 * @date 2019/6/5
 */

@ApiModel(value="api接口通用返回对象")
public class ResponseObject  implements Serializable {
    @ApiModelProperty(value="状态码")
    private int code;
//    @ApiModelProperty(value="返回结果")
//    private PageResponse result;
    @ApiModelProperty(value="信息")
    private String message;

    public ResponseObject(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
//
//    public ResponseObject(int code, PageResponse result) {
//        super();
//        this.code = code;
//        this.result = result;
//    }
//
//    public ResponseObject(int code, PageResponse result, String message) {
//        super();
//        this.code = code;
//        this.result = result;
//        this.message = message;
//    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String desc) {
        this.message = desc;
    }

//    public Object getResult() {
//        return result;
//    }

//    public void setResult(PageResponse data) {
//        this.result = data;
//    }
}
