package com.roncoo.swagger.bean.SwaggerResponse.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zenngwei
 * @date 2019/6/10
 */
@ApiModel("Store")
public class Store implements Serializable {

    @ApiModelProperty(value = "storeId",dataType = "int")
    private int id;

    @ApiModelProperty(value = "名称",dataType = "String")
    private String name;

    @ApiModelProperty(value = "描述",dataType = "String")
    private String description;

    @ApiModelProperty(value = "地址",dataType = "String")
    private String address;

    @ApiModelProperty(value = "创建时间",dataType = "Date")
    private Date createTime;


    @ApiModelProperty(value = "地址来源编号: 10 EPO-POS; 20 FP-POS; 30 官网; 40 微商城; 50 Tmall; 60 JD; 70 MiniSite; 80 微信; 90 导购通; 100 SAP; 110 Hybris; 120 HR",dataType = "int")
    private int addresssourceid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public int getAddresssourceid() {
        return addresssourceid;
    }

    public void setAddresssourceid(int addresssourceid) {
        this.addresssourceid = addresssourceid;
    }
}