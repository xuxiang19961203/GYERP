package com.shudi.test.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.test.pojo
 * @date Date : 2021年04月08日 14:37
 * @Description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class fastJson {


    @Test
    public void  test1(){
        String data = "{\n" +
                "\t\"appkey\":\"157516\",\n" +
                "\t\"code\":\"test01\",\n" +
                "\t\"method\":\"gy.erp.shop.get\",\n" +
                "\t\"modify_end_date\":\"2021-04-08 10:56:58\",\n" +
                "\t\"modify_start_date\":\"2021-03-08 10:56:58\",\n" +
                "\t\"page_no\":\"1\",\n" +
                "\t\"page_size\":\"10\",\n" +
                "\t\"sessionkey\":\"f6acc7ce597d4d07999bdbf8acef2d03\"\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(data);
        Object sign = jsonObject.put("sign", "123");
        System.out.println(jsonObject);
        System.out.println(sign);
    }


}
