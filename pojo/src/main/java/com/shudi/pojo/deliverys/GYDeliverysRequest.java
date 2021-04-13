package com.shudi.pojo.deliverys;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.pojo.deliverys
 * @date Date : 2021年04月11日 18:52
 * @Description: TODO
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GYDeliverysRequest {

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
    private Date start_create;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(ordinal = 6)
    private Date end_create;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(ordinal = 7)
    private Date start_delivery_date;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(ordinal = 8)
    private Date end_delivery_date;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(ordinal = 9)
    private Date start_modify_date;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(ordinal = 10)
    private Date end_modify_date;

    @JSONField(ordinal = 11)
    private String del;

    @JSONField(ordinal = 12)
    private String code;

    @JSONField(ordinal = 13)
    private String warehouse_code;

    @JSONField(ordinal = 14)
    private String shop_code;

    @JSONField(ordinal = 15)
    private String outer_code;

    @JSONField(ordinal = 16)
    private String prString;

    @JSONField(ordinal = 17)
    private String scan;

    @JSONField(ordinal = 18)
    private String delivery;

    @JSONField(ordinal = 19)
    private String cod;

    @JSONField(ordinal = 20)
    private String vip_name;

    @JSONField(ordinal = 21)
    private String wms;

    @JSONField(ordinal = 22)
    private String mail_no;

    @JSONField(ordinal = 23)
    private String sync_status;
}