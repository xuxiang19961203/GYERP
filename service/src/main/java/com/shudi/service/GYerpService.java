package com.shudi.service;

import com.shudi.pojo.deliverys.GYDeliverysVO;
import com.shudi.pojo.shop.GYShopVo;

/**
 * @author : Xux
 * @version V1.0
 * @Project: store
 * @Package com.shudi.service
 * @date Date : 2021年04月07日 19:56
 * @Description: TODO
 */
public interface GYerpService {

    GYShopVo getShops(String shopJson,String url, Class<GYShopVo> gyShopVoClass);

    GYDeliverysVO getGYDeliverys(String deliverysJson, String url,  Class<GYDeliverysVO> gyDeliverysVOClass);
}
