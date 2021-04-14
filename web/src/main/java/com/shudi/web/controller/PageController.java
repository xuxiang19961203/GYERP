package com.shudi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Xux
 * @version V1.0
 * @Project: maven_store
 * @Package com.shudi.web
 * @date Date : 2021年03月25日 21:18
 * @Description:
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


}
