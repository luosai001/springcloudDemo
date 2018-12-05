package com.springcloud.gateway;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sai.luo on 2017-12-6.
 */
@RestController
@RequestMapping("/")
public class Controller {
    @RequestMapping("/{param}")
    public String getString(@PathVariable String param){
        String res = "response : "+param ;
        System.out.println(res);
        return res;
    }
}
