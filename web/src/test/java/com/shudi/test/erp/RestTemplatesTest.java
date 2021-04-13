package com.shudi.test.erp;

import com.alibaba.fastjson.JSON;
import com.shudi.pojo.shop.GYShopVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

/**
 * @author : Xux
 * @version V1.0
 * @Project: store
 * @Package com.shudi.test.erp
 * @date Date : 2021年04月07日 19:38
 * @Description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RestTemplatesTest {

    @Test
    public void encryptByMD5(){
        String data ="6de56616f8aa4c56ba49109bd55e3b61{\"appkey\":\"157516\",\"sessionkey\":\"f6acc7ce597d4d07999bdbf8acef2d03\",\"method\":\"gy.erp.shop.get\",\"page_no\":\"1\",\"page_size\":\"10\"}6de56616f8aa4c56ba49109bd55e3b61";
        System.out.println("data = " + data);
        //E455F04209E161D72A5EF6D8ED1D728C
        String sign = DigestUtils.md5DigestAsHex(data.getBytes());
        System.out.println("sign = " + sign.toUpperCase());
    }

    @Test
    public void test1(){
        String response = "{\"success\":true,\"errorCode\":\"\",\"subErrorCode\":\"\",\"errorDesc\":\"\",\"subErrorDesc\":\"\",\"requestMethod\":\"gy.erp.shop.get\",\"shops\":[{\"id\":3302759178,\"nick\":\"天猫测试店铺\",\"code\":\"TM_TEST_001\",\"name\":\"天猫测试店铺\",\"create_date\":\"2015-07-16 14:44:55\",\"modify_date\":\"2015-07-16 14:44:55\",\"note\":\"\",\"type_name\":\"天猫\"},{\"id\":4259075078,\"nick\":\"571549806@qq.com\",\"code\":\"08\",\"name\":\"当当文豪\",\"create_date\":\"2015-08-10 13:35:35\",\"modify_date\":\"2015-08-10 13:35:35\",\"note\":\"\",\"type_name\":\"当当V2\"},{\"id\":4623441496,\"nick\":\"狐狸的心00\",\"code\":\"TB\",\"name\":\"狐狸的心00\",\"create_date\":\"2015-08-20 21:20:25\",\"modify_date\":\"2015-08-20 21:20:28\",\"note\":\"\",\"type_name\":\"淘宝\"},{\"id\":113625940655,\"nick\":\"杭州丁香健康管理有限公司\",\"code\":\"WKKH0003\",\"name\":\"杭州丁香健康管理有333333333\",\"create_date\":\"2019-03-20 11:51:51\",\"modify_date\":\"2019-11-12 18:16:04\",\"note\":\"\",\"type_name\":\"其他\"},{\"id\":114531091219,\"nick\":\"华时测试店\",\"code\":\"HS001\",\"name\":\"华时测试店\",\"create_date\":\"2019-03-25 14:00:49\",\"modify_date\":\"2019-03-25 14:00:49\",\"note\":\"\",\"type_name\":\"淘宝\"},{\"id\":117237083486,\"nick\":\"佛山三水同福路营业部\",\"code\":\"100189\",\"name\":\"佛山三水同福路营业部\",\"create_date\":\"2019-04-09 15:14:27\",\"modify_date\":\"2019-04-09 15:17:55\",\"note\":\"集成云测试客户\",\"type_name\":\"其他\"},{\"id\":117237174960,\"nick\":\"云南华夏国际旅行社广州分公司\",\"code\":\"100094\",\"name\":\"云南华夏国际旅行社广州分公司\",\"create_date\":\"2019-04-09 15:15:02\",\"modify_date\":\"2019-04-09 15:17:47\",\"note\":\"集成云测试客户\",\"type_name\":\"其他\"},{\"id\":117237279531,\"nick\":\"羊城之旅德政北\",\"code\":\"100296\",\"name\":\"羊城之旅德政北\",\"create_date\":\"2019-04-09 15:15:30\",\"modify_date\":\"2019-04-09 15:17:41\",\"note\":\"集成云测试客户\",\"type_name\":\"其他\"},{\"id\":117237496212,\"nick\":\"广东风光国旅\",\"code\":\"100297\",\"name\":\"广东风光国旅\",\"create_date\":\"2019-04-09 15:16:41\",\"modify_date\":\"2019-04-09 15:17:34\",\"note\":\"集成云测试客户\",\"type_name\":\"其他\"},{\"id\":117237639155,\"nick\":\"快事达旅游\",\"code\":\"100298\",\"name\":\"快事达旅游\",\"create_date\":\"2019-04-09 15:17:25\",\"modify_date\":\"2019-04-09 15:17:25\",\"note\":\"集成云测试\",\"type_name\":\"其他\"}],\"total\":116}\n";
        GYShopVo gyBodyVo = JSON.parseObject(response, GYShopVo.class);
        log.info("gyBodyVo ="+gyBodyVo);

    }

}
