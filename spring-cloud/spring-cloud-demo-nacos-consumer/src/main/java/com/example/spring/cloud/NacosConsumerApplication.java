package com.example.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerApplication.class, args);
	}

	@RestController
    public class NacosController{

        @Autowired
        NacosProviderService nacosProviderService;

        @Value("${spring.application.name}")
        private String appName;

        @GetMapping("/echo/app")
        public String echoAppName(){
            return nacosProviderService.echo(appName);
        }
    }

    @Service
    @FeignClient(name = "spring-cloud-demo-nacos-provider")
    public interface NacosProviderService {
    
        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string);
    }

}
