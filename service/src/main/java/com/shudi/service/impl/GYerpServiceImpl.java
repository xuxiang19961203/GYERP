package com.shudi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shudi.Utils.RestTemplateUtils;
import com.shudi.dao.GYerpDao;
import com.shudi.pojo.deliverys.*;
import com.shudi.pojo.shop.GYShop;
import com.shudi.pojo.shop.GYShopVo;
import com.shudi.service.GYerpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Xux
 * @version V1.0
 * @Project: store
 * @Package com.shudi.service.impl
 * @date Date : 2021年04月07日 19:58
 * @Description: TODO
 */
@Service
@Slf4j
public class GYerpServiceImpl implements GYerpService {

    @Autowired
    private GYerpDao GYerpDao;

    @Autowired
    private RestTemplateUtils RestTemplateUtils;

    @Override
    public GYShopVo getShops(String shopJson, String url, Class<GYShopVo> gyShopVoClass) throws DataAccessException {
        JSONObject jsonObject = RestTemplateUtils.getJSONObject(shopJson, url);
        if (jsonObject == null) return null;
        GYShopVo gyShopVo = JSON.parseObject(jsonObject.toString(), gyShopVoClass);
        if (gyShopVo.getTotal() > 0) {
            List<GYShop> shops = gyShopVo.getShops();
            for (GYShop shop : shops) {
                System.out.println("shop = " + shop);
                GYerpDao.addShops(shop);
            }
        }
        return gyShopVo;
    }

    @Override
    public GYDeliverysVO getGYDeliverys(String deliverysJson, String url,
                                        Class<GYDeliverysVO> gyDeliverysVOClass) throws DataAccessException {
        JSONObject jsonObject = RestTemplateUtils.getJSONObject(deliverysJson, url);
        //接口没有数据则直接返回
        if (jsonObject == null) return null;
        GYDeliverysVO gyDeliverysVO = JSON.parseObject(jsonObject.toString(), gyDeliverysVOClass);
        this.addGYDeliverys(gyDeliverysVO);
        return gyDeliverysVO;
    }

    public void addGYDeliverys(GYDeliverysVO gyDeliverysVO) {
        if (gyDeliverysVO.getTotal() > 0) {
            //如果主表存在,则存储主表数据
            List<GYDeliverys> deliverysList = gyDeliverysVO.getDeliverys();
            log.info("deliverysList=" + deliverysList);
            for (GYDeliverys delivery : deliverysList) {
                GYerpDao.addDelivery(delivery);
                //获取主表code编码存入明细
                String code = delivery.getCode();
                //存取状态表
                GYDelivery_statusInfo delivery_statusInfo = delivery.getDelivery_statusInfo();
                delivery_statusInfo.setCode(code);//保持主子表code唯一
                GYerpDao.addDelivery_statusInfo(delivery_statusInfo);
                List<GYDeliverysDetails> gyDeliverysDetailsList = delivery.getDetails();
                log.info("gyDeliverysDetailsList=" + gyDeliverysDetailsList);
                //如果明细行存在,则储存
                if (gyDeliverysDetailsList.size() > 0) {
                    for (GYDeliverysDetails gyDeliverysDetail : gyDeliverysDetailsList) {
                        gyDeliverysDetail.setCode(code);//保持主子表code唯一
                        GYerpDao.addDeliverysDetail(gyDeliverysDetail);
                        List<GYDeliverysDetail_batch> detail_batchList = gyDeliverysDetail.getDetail_batch();
                        log.info("detail_batchList=" + detail_batchList);
                        //如果明细行有批号,则储存
                        if (detail_batchList.size() > 0) {
                            for (GYDeliverysDetail_batch gyDeliverysDetail_batch : detail_batchList) {
                                gyDeliverysDetail_batch.setCode(code);//保持主表和批次code一致
                                GYerpDao.addDeliverysDetail_batch(gyDeliverysDetail_batch);
                            }
                        }
                    }
                }
            }
        }
    }
}
