package com.shudi.pojo.shop;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.pojo.shop
 * @date Date : 2021年04月08日 10:28
 * @Description: TODO
 */
@Component
@Data
@Builder
public class GYShopRequest {

    /*fastjson默认按照首字母排序
    javabean转json时, 按照以下顺序输出属性*/
    @JSONField(ordinal = 0)
    private String appkey;
    @JSONField(ordinal = 1)
    private String sessionkey;
    @JSONField(ordinal = 2)
    private String method;
    @JSONField(ordinal = 3)
    private String page_no;
    @JSONField(ordinal = 4)
    private String page_size;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(ordinal = 5)
    private Date modify_start_date;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(ordinal = 6)
    private Date modify_end_date;
    @JSONField(ordinal = 7)
    private String code;
    @JSONField(ordinal = 8)
    private String sign;

    @Tolerate
    public GYShopRequest() {
    }
}
