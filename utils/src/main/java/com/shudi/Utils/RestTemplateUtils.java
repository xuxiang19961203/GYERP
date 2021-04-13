package com.shudi.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;

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
public class RestTemplateUtils {

    @Autowired
    private  RestTemplate restTemplate;

    public  JSONObject getJSONObject(String data, String url) {
        JSONObject jsonObject = null;
        try {
            ResponseEntity<String> gyShopResponseEntity = restTemplate.postForEntity(url, data, String.class);
            log.info("gyShopResponseEntity=" + gyShopResponseEntity);
            //获取请求体
            String gyShopResponseBody = gyShopResponseEntity.getBody();
            log.info("gyShopResponseBody=" + gyShopResponseBody);
            //将请求体转换成类,使用fastJson转换
            jsonObject = JSON.parseObject(gyShopResponseBody);
            log.info("jsonObject=" + jsonObject);
        } catch (RestClientException e) {
            log.error("Caught Exception in getJSONObject(): " + e.getClass().getName() + ": " + e.getMessage());
            if (e.getCause() instanceof UnknownHostException) {
                throw new RuntimeException(this.getClass().getName()+"中抛出异常: " +e.getMessage());
            }
        }
        return jsonObject;
    }
}
