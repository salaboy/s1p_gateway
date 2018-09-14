package org.activiti.cloud.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    private static final Log log = LogFactory.getLog(GatewayApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,
                args);
    }
    
}
