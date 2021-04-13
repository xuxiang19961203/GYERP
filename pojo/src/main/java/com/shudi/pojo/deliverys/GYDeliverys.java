package com.shudi.pojo.deliverys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.pojo.deliverys
 * @date Date : 2021年04月11日 22:37
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GYDeliverys {

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_date;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modify_date;
    private String code;
    private int qty;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date pay_time;
    private boolean cod;
    private int refund;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date invoiceDate;
    private String bigchar;
    private int cancel;
    private String picture_bill;
    private String post_fee;
    private String cod_fee;
    private String discount_fee;
    private String post_cost;
    private String unpaid_amount;
    private String platform_code;
    private String plan_delivery_date;
    private String buyer_memo;
    private String seller_memo;
    private String receiver_name;
    private String receiver_phone;
    private String receiver_mobile;
    private String receiver_zip;
    private String receiver_address;
    private String create_name;
    private String express_no;
    private String vip_name;
    private String shop_name;
    private String area_name;
    private String warehouse_name;
    private String express_code;
    private String express_name;
    private String tag_name;
    private String seller_memo_late;
    private String shelf_no;
    private List<GYDeliverysDetails> details;
    private GYDelivery_statusInfo delivery_statusInfo;
    private List<String> invoices;
    private String vip_code;
    private String warehouse_code;
    private String shop_code;
    private String vip_real_name;
    private String vip_id_card;
    private String package_center_code;
    private String package_center_name;
    private int sync_status;
    private String sync_memo;
    private String drp_tenant_name;
    private String drp_tenant_mobile;
    private String payment;
    private String amount;
    private String store_name;
    private String store_code;
}