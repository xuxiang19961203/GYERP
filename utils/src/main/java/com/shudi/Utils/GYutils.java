package com.shudi.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.Utils
 * @date Date : 2021年04月08日 10:39
 * @Description:
 */
//@Component
@Slf4j
public class GYutils {

    public static String toCastGYJsonString(Object object, String secret) {
        log.info("ShopRequest=" + object);
        String shopJsonString = JSON.toJSONString(object,
                //SerializerFeature.PrettyFormat,//格式化输出
                SerializerFeature.WriteDateUseDateFormat); //使用默认时间格式

        //在json首尾拼接secret并加密得到最终含有sign签名的Json
        JSONObject jsonObject = getJsonObject(secret, shopJsonString);
        return jsonObject.toJSONString();
    }

    public static JSONObject getJsonObject(String secret, String shopJsonString) {
        //在json首尾拼接secret
        String data = secret + shopJsonString + secret;
        log.info("data=" + data);
        //转换成MD5(32位大写加密)
        String sign = DigestUtils.md5DigestAsHex(data.getBytes()).toUpperCase();
        log.info("sign=" + sign);
        //JSONObject jsonObject = JSON.parseObject(shopJsonString);//无需排列会导致请求失败
        //将javabean转换成jsonObject对象,对象属性按照JSON属性排列,然后再json尾部添加sign参数
        JSONObject jsonObject = JSON.parseObject(shopJsonString, Feature.OrderedField);
        jsonObject.put("sign", sign);
        log.info(jsonObject.toJSONString());
        return jsonObject;
    }


}
