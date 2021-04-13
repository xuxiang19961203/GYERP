package com.shudi.pojo.shop;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : Xux
 * @version V1.0
 * @Project: store
 * @Package com.shudi.pojo
 * @date Date : 2021年04月07日 19:52
 * @Description: TODO
 */
@Data
@Component
@Builder
public class GYShop {

    private String id;//ID
    private String nick;//昵称
    private String code;//代码
    private String name;//名称
    //请求时,时间格式转换为下面格式
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //类转json时,时间格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_date;//创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modify_date;//修改时间
    private String note;//备注
    private String type_name;//类型

    @Tolerate
    public GYShop() {
    }


}
