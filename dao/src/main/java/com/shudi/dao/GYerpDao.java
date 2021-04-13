package com.shudi.dao;

import com.shudi.pojo.deliverys.GYDelivery_statusInfo;
import com.shudi.pojo.deliverys.GYDeliverys;
import com.shudi.pojo.deliverys.GYDeliverysDetail_batch;
import com.shudi.pojo.deliverys.GYDeliverysDetails;
import com.shudi.pojo.shop.GYShop;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.dao
 * @date Date : 2021年04月11日 16:15
 * @Description: TODO
 */

@Component
public interface GYerpDao {

    //保存GY店铺
    @Insert("INSERT INTO gyshop (" +
            "`id`,`nick`,`name`,`type_name`,`note`,`code`,`create_date`,`modify_date`) " +
            "VALUES(" +
            "#{id},#{nick},#{name},#{type_name},#{note},#{code},#{create_date},#{modify_date} ) ;")
    void addShops(GYShop GYShop);

    //保存GY发货单主表
    @Insert("INSERT INTO `ssm`.`gydeliverys` (`code`,`create_date`,`modify_date`,`qty`,`pay_time`,`cod`,`refund`,`invoiceDate`,`bigchar`,`cancel`,`picture_bill`,`post_fee`,`cod_fee`,`discount_fee`,`post_cost`,`unpaid_amount`,`platform_code`,`plan_delivery_date`,`buyer_memo`,`seller_memo`,`receiver_name`,`receiver_phone`,`receiver_mobile`,`receiver_zip`,`receiver_address`,`create_name`,`express_no`,`vip_name`,`shop_name`,`area_name`,`warehouse_name`,`express_code`,`express_name`,`tag_name`,`seller_memo_late`,`shelf_no`,`vip_code`,`warehouse_code`,`shop_code`,`vip_real_name`,`vip_id_card`,`package_center_code`,`package_center_name`,`sync_status`,`sync_memo`,`drp_tenant_name`,`drp_tenant_mobile`,`payment`,`amount`,`store_name`,`store_code`" +
            ") " +
            "VALUES( #{code}, #{create_date}, #{modify_date}, #{qty}, #{pay_time}, #{cod}, #{refund}, #{invoiceDate}, #{bigchar}, #{cancel}, #{picture_bill}, #{post_fee}, #{cod_fee}, #{discount_fee}, #{post_cost}, #{unpaid_amount}, #{platform_code}, #{plan_delivery_date}, #{buyer_memo}, #{seller_memo}, #{receiver_name}, #{receiver_phone}, #{receiver_mobile}, #{receiver_zip}, #{receiver_address}, #{create_name}, #{express_no}, #{vip_name}, #{shop_name}, #{area_name}, #{warehouse_name}, #{express_code}, #{express_name}, #{tag_name}, #{seller_memo_late}, #{shelf_no}, #{vip_code}, #{warehouse_code}, #{shop_code}, #{vip_real_name}, #{vip_id_card}, #{package_center_code}, #{package_center_name}, #{sync_status}, #{sync_memo}, #{drp_tenant_name}, #{drp_tenant_mobile}, #{payment}, #{amount}, #{store_name}, #{store_code});")
    void addDelivery(GYDeliverys delivery);

    //保存GY发货单明细
    @Insert("INSERT INTO `ssm`.`gydeliverysdetails` (`code`,`qty`,`refund`,`itemCategoryName`,`itemUnitName`,`barcode`,`tariff`,`memo`,`picUrl`,`oid`,`discount_fee`,`amount_after`,`trade_code`,`item_id`,`item_sku_id`,`item_code`,`item_name`,`sku_code`,`sku_name`,`sku_note`,`combine_item_code`,`location_code`,`platform_code`,`tax_rate`,`tax_amount`,`order_type`,`platform_flag`,`detail_unique`,`is_gift`,`businessman_name`,`item_add_attribute`,`gift_source_view`,`currency_code`,`currency_name`,`tax_no`,`origin_price`,`post_fee`,`post_cost`,`other_service_fee`,`total_cost_price`,`price`,`amount`" +
            ") " +
            "VALUES(  #{code},  #{qty},  #{refund},  #{itemCategoryName},  #{itemUnitName},  #{barcode},  #{tariff},  #{memo},  #{picUrl},  #{oid},  #{discount_fee},  #{amount_after},  #{trade_code},  #{item_id},  #{item_sku_id},  #{item_code},  #{item_name},  #{sku_code},  #{sku_name},  #{sku_note},  #{combine_item_code},  #{location_code},  #{platform_code},  #{tax_rate},  #{tax_amount},  #{order_type},  #{platform_flag},  #{detail_unique},  #{is_gift},  #{businessman_name},  #{item_add_attribute},  #{gift_source_view},  #{currency_code},  #{currency_name},  #{tax_no},  #{origin_price},  #{post_fee},  #{post_cost},  #{other_service_fee},  #{total_cost_price},  #{price},  #{amount})")
    void addDeliverysDetail(GYDeliverysDetails gyDeliverysDetail);

    //保存GY发货单批次明细
    @Insert("INSERT INTO `ssm`.`gydeliverysdetail_batch` (`code`,`qty`,`productionTime`,`validTime`,`warehousingTime`,`shelfLife`,`batchNumber`" +
            ") " +
            "VALUES(  #{code},  #{qty},  #{productionTime},  #{validTime},  #{warehousingTime},  #{shelfLife},  #{batchNumber});")
    void addDeliverysDetail_batch(GYDeliverysDetail_batch gyDeliverysDetail_batch);

    //保存GY发货单状态表
    @Insert("INSERT INTO `ssm`.`gydelivery_statusinfo` (`code`,`scan`,`weight`,`wms`,`delivery`,`cancel`,`intercept`,`print_express`,`express_print_name`,`express_print_date`,`print_delivery`,`delivery_print_name`,`delivery_print_date`,`scan_name`,`scan_date`,`weight_name`,`weight_date`,`wms_order`,`delivery_name`,`delivery_date`,`cancel_name`,`cancel_date`,`weight_qty`,`thermal_print`,`thermal_print_status`,`picking_user`,`picking_date`,`standard_weight`,`pick_finish`" +
            ") " +
            "VALUES(#{code},#{scan},#{weight},#{wms},#{delivery},#{cancel},#{intercept},#{print_express},#{express_print_name},#{express_print_date},#{print_delivery},#{delivery_print_name},#{delivery_print_date},#{scan_name},#{scan_date},#{weight_name},#{weight_date},#{wms_order},#{delivery_name},#{delivery_date},#{cancel_name},#{cancel_date},#{weight_qty},#{thermal_print},#{thermal_print_status},#{picking_user},#{picking_date},#{standard_weight},#{pick_finish}) ;")
    void addDelivery_statusInfo(GYDelivery_statusInfo delivery_statusInfo);
}
