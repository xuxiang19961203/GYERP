package com.shudi.Utils;

import com.alibaba.fastjson.JSON;
import com.shudi.pojo.shop.GYShopVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Xux
 * @version V1.0
 * @Project: store
 * @Package com.shudi.Utils
 * @date Date : 2021年04月07日 20:16
 * @Description: TODO
 */
@Component
@Slf4j
public class RestTemplateUtils2 {

    @Autowired
    private RestTemplateBuilder RestTemplateBuilder;

    private  RestTemplate restTemplate;

    public GYShopVo getObject(String data, String url){
        restTemplate = RestTemplateBuilder.build();
        log.info("data="+data);
        log.info("url="+url);
        ResponseEntity<String> gyShopResponseEntity = restTemplate.postForEntity(url, data, String.class);
        log.info("gyShopResponseEntity="+gyShopResponseEntity);
        //获取请求体
        String gyShopResponseBody = gyShopResponseEntity.getBody();
        log.info("gyShopResponseBody="+gyShopResponseBody);
        //将请求体转换成类
        /*ObjectMapper ObjectMapper =new ObjectMapper();
        GYBodyVo GYBodyVo =null;
        try {
            GYBodyVo = ObjectMapper.readValue(gyShopResponseBody, GYBodyVo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
        //使用fastJson转换
        GYShopVo GYBodyVo = JSON.parseObject(gyShopResponseBody, GYShopVo.class);
        return GYBodyVo;

        /*MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("shopid","1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        return restTemplate.postForEntity(url, request,String.class);*/
        //下面开始报错
        //GYShop gyShop = restTemplate.postForObject(url, data, GYShop.class);
        //GYShop gyShop = restTemplate.postForEntity(url, data, GYShop.class);
        //System.out.println("gyShop = " + gyShop);
        //return null;
    }
}
