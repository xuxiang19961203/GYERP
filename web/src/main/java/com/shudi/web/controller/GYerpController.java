package com.shudi.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shudi.Utils.GYutils;
import com.shudi.pojo.StockOther.GYStockOtherIn;
import com.shudi.pojo.StockOther.GYStockOtherInDetails;
import com.shudi.pojo.config.GyErpConfig;
import com.shudi.pojo.deliverys.GYDeliverysRequest;
import com.shudi.pojo.deliverys.GYDeliverysVO;
import com.shudi.pojo.shop.GYShop;
import com.shudi.pojo.shop.GYShopRequest;
import com.shudi.pojo.shop.GYShopVo;
import com.shudi.service.GYerpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Xux
 * @version V1.0
 * @product: store
 * @Package com.shudi.web.controller
 * @date Date : 2021年04月07日 19:50
 * @Description: erp
 */
@Controller
@RequestMapping("/erp")
@Slf4j
public class GYerpController {

    @Autowired
    private GYerpService GYerpService;

    @Autowired
    private GyErpConfig GyErpConfig;

    //获取店铺
    @RequestMapping("getShops")
    public String getShops(GYShopRequest GYShopRequest, String secret, Model model) {
        //String url = "http://v2.api.guanyierp.com/rest/erp_open";
        String url = GyErpConfig.getUrl();
        //获取最终的请求JSON
        String shopJson = GYutils.toCastGYJsonString(GYShopRequest, secret);
        GYShopVo GYShopVo = null;
        try {
            GYShopVo = GYerpService.getShops(shopJson, url, GYShopVo.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        model.addAttribute("GYShopVo", GYShopVo);
        return "gyShopList";
    }

    //获取发货单
    @RequestMapping("getDeliverys")
    @ResponseBody
    public ModelAndView getDeliverys(GYDeliverysRequest GYDeliverysRequest, String secret) {
        String url = GyErpConfig.getUrl();
        //获取最终的请求JSON
        log.info("GYDeliverysRequest=" + GYDeliverysRequest);
        String deliverysJson = GYutils.toCastGYJsonString(GYDeliverysRequest, secret);
        GYDeliverysVO gyDeliverysVO;
        ModelAndView modelAndView = new ModelAndView();
        try {
            gyDeliverysVO = GYerpService.getGYDeliverys(deliverysJson, url, GYDeliverysVO.class);
            modelAndView.addObject("gyDeliverysVO", gyDeliverysVO);
            modelAndView.setViewName("gyDeliverysList");
        } catch (Exception e) {
            log.error(e.getMessage());
            modelAndView.addObject("Msg", "主键重复:" + e.getMessage());
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping("stockOtherIn")
    public ModelAndView stockOtherIn(GYStockOtherIn GYStockOtherIn, String secret) {
        String url = GyErpConfig.getUrl();
        ModelAndView ModelAndView = new ModelAndView();
        String finalJson = GYutils.toCastGYJsonString(GYStockOtherIn, secret);
        try {
            JSONObject jsonObject = GYerpService.addStockOtherIn(finalJson, url);
            boolean success = Boolean.parseBoolean(jsonObject.get("success").toString());
            if (success) {
                String code = jsonObject.get("code").toString();
                log.info("code=" + code);
                ModelAndView.setViewName("successPage");
                ModelAndView.addObject("code", code);
                return ModelAndView;
            } else {
                String errorDesc = jsonObject.get("errorDesc").toString();
                String subErrorDesc = jsonObject.get("subErrorDesc").toString();
                log.info("errorDesc=" + errorDesc + "\r\n" + subErrorDesc);
                ModelAndView.addObject("Msg", errorDesc + "\r\n" + subErrorDesc);
                ModelAndView.setViewName("errorPage");
                return ModelAndView;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ModelAndView;
    }

    @RequestMapping("addDetails")
    @ResponseBody
    public ModelAndView addDetails() {
        List<GYStockOtherInDetails> detailsList = null;
        ModelAndView modelAndView = new ModelAndView();
        if (detailsList == null) {
            detailsList = new ArrayList<>();
            detailsList.add(new GYStockOtherInDetails("test001", "test001", "10", null, null, null, null, null, "测试"));
        }
        modelAndView.addObject("detailsList", detailsList);
        modelAndView.setViewName("gyStockOtherInRequest");
        return modelAndView;
    }

    //测试
    @RequestMapping("test/{create_date}")
    @ResponseBody
    public GYShop getShops(GYShop gyShop) {
        Date create_date = gyShop.getCreate_date();
        log.info("gyShop.create_date=" + create_date);
        return gyShop;
    }

    //测试
    @RequestMapping("getDetails")
    @ResponseBody
    public String getDetails() {
        String data = "{\"total\":121,\"errorDesc\":\"\",\"success\":true,\"subErrorDesc\":\"\",\"requestMethod\":\"gy.erp.shop.get\",\"shops\":[{\"nick\":\"天猫测试店铺\",\"note\":\"\",\"type_name\":\"天猫\",\"code\":\"TM_TEST_001\",\"name\":\"天猫测试店铺\",\"id\":3302759178,\"create_date\":\"2015-07-16 14:44:55\",\"modify_date\":\"2015-07-16 14:44:55\"},{\"nick\":\"571549806@qq.com\",\"note\":\"\",\"type_name\":\"当当V2\",\"code\":\"08\",\"name\":\"当当文豪\",\"id\":4259075078,\"create_date\":\"2015-08-10 13:35:35\",\"modify_date\":\"2015-08-10 13:35:35\"},{\"nick\":\"狐狸的心00\",\"note\":\"\",\"type_name\":\"淘宝\",\"code\":\"TB\",\"name\":\"狐狸的心00\",\"id\":4623441496,\"create_date\":\"2015-08-20 21:20:25\",\"modify_date\":\"2015-08-20 21:20:28\"},{\"nick\":\"杭州丁香健康管理有限公司\",\"note\":\"\",\"type_name\":\"其他\",\"code\":\"WKKH0003\",\"name\":\"杭州丁香健康管理有333333333\",\"id\":113625940655,\"create_date\":\"2019-03-20 11:51:51\",\"modify_date\":\"2019-11-12 18:16:04\"},{\"nick\":\"华时测试店\",\"note\":\"\",\"type_name\":\"淘宝\",\"code\":\"HS001\",\"name\":\"华时测试店\",\"id\":114531091219,\"create_date\":\"2019-03-25 14:00:49\",\"modify_date\":\"2019-03-25 14:00:49\"},{\"nick\":\"佛山三水同福路营业部\",\"note\":\"集成云测试客户\",\"type_name\":\"其他\",\"code\":\"100189\",\"name\":\"佛山三水同福路营业部\",\"id\":117237083486,\"create_date\":\"2019-04-09 15:14:27\",\"modify_date\":\"2019-04-09 15:17:55\"},{\"nick\":\"云南华夏国际旅行社广州分公司\",\"note\":\"集成云测试客户\",\"type_name\":\"其他\",\"code\":\"100094\",\"name\":\"云南华夏国际旅行社广州分公司\",\"id\":117237174960,\"create_date\":\"2019-04-09 15:15:02\",\"modify_date\":\"2019-04-09 15:17:47\"},{\"nick\":\"羊城之旅德政北\",\"note\":\"集成云测试客户\",\"type_name\":\"其他\",\"code\":\"100296\",\"name\":\"羊城之旅德政北\",\"id\":117237279531,\"create_date\":\"2019-04-09 15:15:30\",\"modify_date\":\"2019-04-09 15:17:41\"},{\"nick\":\"广东风光国旅\",\"note\":\"集成云测试客户\",\"type_name\":\"其他\",\"code\":\"100297\",\"name\":\"广东风光国旅\",\"id\":117237496212,\"create_date\":\"2019-04-09 15:16:41\",\"modify_date\":\"2019-04-09 15:17:34\"},{\"nick\":\"快事达旅游\",\"note\":\"集成云测试\",\"type_name\":\"其他\",\"code\":\"100298\",\"name\":\"快事达旅游\",\"id\":117237639155,\"create_date\":\"2019-04-09 15:17:25\",\"modify_date\":\"2019-04-09 15:17:25\"},{\"nick\":\"一块去旅游\",\"note\":\"\",\"type_name\":\"其他\",\"code\":\"100299\",\"name\":\"一块去旅游\",\"id\":117237890008,\"create_date\":\"2019-04-09 15:18:33\",\"modify_date\":\"2019-04-09 15:18:33\"}],\"errorCode\":\"\",\"subErrorCode\":\"\"}";
        JSONObject jsonObject = JSON.parseObject(data);
        log.info("jsonObject=" + jsonObject);
        Object shops = jsonObject.get("shops");
        log.info("shops=" + shops);
        JSONArray JSONArray = jsonObject.getJSONArray("shops");
        log.info("JSONArray=" + JSONArray);
        String jsonString = JSONObject.toJSONString(JSONArray);
        log.info("jsonString=" + jsonString);
        //List<GYShop> shopList = JSONObject.parseArray(jsonString, GYShop.class);
        List<GYShop> shopList = JSONObject.parseArray(JSONArray.toJSONString(), GYShop.class);
        log.info("shopList=" + shopList);
        return "测试";
    }
}
