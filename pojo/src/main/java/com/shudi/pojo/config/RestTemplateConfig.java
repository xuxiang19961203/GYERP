package com.shudi.pojo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.pojo.config
 * @date Date : 2021年04月08日 10:23
 * @Description: TODO
 */

@Configuration
public class RestTemplateConfig {

    @Autowired
    private RestTemplateBuilder RestTemplateBuilder;

    @Bean
    public RestTemplate getRestTemplate(){
        return  RestTemplateBuilder.build();
    }


}
