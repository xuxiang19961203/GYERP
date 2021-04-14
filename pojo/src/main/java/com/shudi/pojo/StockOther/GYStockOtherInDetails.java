package com.shudi.pojo.StockOther;

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
 * @Package com.shudi.pojo.StockOther
 * @date Date : 2021年04月13日 20:23
 * @Description: TODO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GYStockOtherInDetails {
    private String item_code;
    private String sku_code;
    private String qty;
    private String uniqueCode;
    private String batchNumber;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date manufacturingDate;
    private String shelfLife;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date stockDate;
    private String note;
}