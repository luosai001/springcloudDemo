package com.springcloud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: luosai
 * @Date: 2018/12/5 17:57
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class ClientApplication {
  @Autowired
  IHelloService iHelloService;


  private AtomicInteger count = new AtomicInteger() ;
  private AtomicInteger count2 = new AtomicInteger() ;

  @RequestMapping("/hello")
  public String hello(){
    System.out.println("request:"+count2.getAndIncrement());
    String str =  iHelloService.hello();
    System.out.println(str+count.getAndIncrement());
    return str ;
  }
  public static void main(String[] args) {
    SpringApplication.run(ClientApplication.class, args);
  }
}