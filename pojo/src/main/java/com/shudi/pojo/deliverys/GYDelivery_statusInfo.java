package com.shudi.pojo.deliverys;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @date Date : 2021年04月11日 22:43
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GYDelivery_statusInfo {

    private String code;
    private boolean scan;
    private boolean weight;
    private int wms;
    private int delivery;
    private boolean cancel;
    private boolean intercept;
    private boolean print_express;
    private String express_print_name;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date express_print_date;
    private boolean print_delivery;
    private String delivery_print_name;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date delivery_print_date;
    private String scan_name;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date scan_date;
    private String weight_name;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date weight_date;
    private int wms_order;
    private String delivery_name;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date delivery_date;
    private String cancel_name;
    private String cancel_date;
    private String weight_qty;
    private int thermal_print;
    private int thermal_print_status;
    private String picking_user;
    private String picking_date;
    private int standard_weight;
    private boolean pick_finish;
}