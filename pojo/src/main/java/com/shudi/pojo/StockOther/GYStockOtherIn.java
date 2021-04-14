package com.shudi.pojo.StockOther;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.pojo.StockOther
 * @date Date : 2021年04月13日 20:26
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GYStockOtherIn {

    private String appkey;
    private String sessionkey;
    private String method;
    private String warehouse_code;
    private String type;
    private String note;
    private String wms_bizcode;
    private List<GYStockOtherInDetails> details;
}