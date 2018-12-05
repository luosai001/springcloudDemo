package com.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: luosai
 * @Date: 2018/12/5 18:00
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProviderApplication {
  private AtomicInteger count = new AtomicInteger() ;

  @RequestMapping("/hello")
  public String hello(){
    System.out.println("hello: "+count.getAndIncrement());
    return "hello";
  }
  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class, args);
  }
}
