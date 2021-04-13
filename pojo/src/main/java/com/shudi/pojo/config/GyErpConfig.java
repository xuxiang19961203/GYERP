package com.shudi.pojo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.pojo.config
 * @date Date : 2021年04月11日 14:51
 * @Description: TODO
 */
@Component
@Data
@Configuration
@PropertySource("classpath:config/gyerp.properties")
@ConfigurationProperties(prefix = "gyerp", ignoreUnknownFields = false) //前缀不符合抛异常?false
public class GyErpConfig {

    private  String Url;


}
