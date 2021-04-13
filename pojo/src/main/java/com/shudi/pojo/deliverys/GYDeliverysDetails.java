package com.shudi.pojo.deliverys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.pojo.deliverys
 * @date Date : 2021年04月11日 22:39
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GYDeliverysDetails {

    private String code;
    private int qty;
    private int refund;
    private String itemCategoryName;
    private String itemUnitName;
    private String barcode;
    private int tariff;
    private String memo;
    private String picUrl;
    private String oid;
    private String discount_fee;
    private String amount_after;
    private String trade_code;
    private String item_id;
    private String item_sku_id;
    private String item_code;
    private String item_name;
    private String sku_code;
    private String sku_name;
    private String sku_note;
    private String combine_item_code;
    private String location_code;
    private String platform_code;
    private int tax_rate;
    private int tax_amount;
    private String order_type;
    private int platform_flag;
    private String detail_unique;
    private List<GYDeliverysDetail_batch> detail_batch;
    private int is_gift;
    private String businessman_name;
    private String item_add_attribute;
    private String gift_source_view;
    private String currency_code;
    private String currency_name;
    private String tax_no;
    private String origin_price;
    private String post_fee;
    private String post_cost;
    private String other_service_fee;
    private String total_cost_price;
    private String price;
    private String amount;
}