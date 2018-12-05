package com.springcloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: luosai
 * @Date: 2018/12/5 18:27
 */
@FeignClient(value = "eureka-client-provider",fallback = FallbackService.class )
public interface IHelloService {
  @RequestMapping(value = "/hello",method = RequestMethod.GET)
  String hello();
}

@Component
class FallbackService implements IHelloService{
  @Override
  public String hello() {
    return " hystrix ... ";
  }
}
