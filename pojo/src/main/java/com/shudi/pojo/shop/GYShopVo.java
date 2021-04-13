package com.shudi.pojo.shop;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Xux
 * @version V1.0
 * @Project: store
 * @Package com.shudi.pojo
 * @date Date : 2021年04月07日 22:30
 * @Description: TODO
 */
@Component
@Data
@Builder
public class GYShopVo {

    private boolean success;
    private String errorCode;
    private String subErrorCode;
    private String errorDesc;
    private String subErrorDesc;
    private String requestMethod;
    private List<GYShop> shops;
    private int total;

    @Tolerate
    public GYShopVo() {
    }
}
