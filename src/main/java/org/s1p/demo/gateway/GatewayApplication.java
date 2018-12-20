package org.s1p.demo.gateway;

import io.fabric8.kubernetes.api.model.HasMetadata;
import me.snowdrop.istio.client.IstioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class GatewayApplication implements CommandLineRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private IstioClient istioClient;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,
                args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>> Services: " + System.currentTimeMillis());
        for (String s : discoveryClient.getServices()) {
            System.out.println("\t >>>> Service: " + s);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
    }

    @Scheduled(fixedDelay = 5000)
    public void printServices() {
        System.out.println(">>>> Services: " + System.currentTimeMillis());
        for (String s : discoveryClient.getServices()) {
            System.out.println("\t >>>> Service: " + s);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");

        List<HasMetadata> list = istioClient.resourceList().get();
        System.out.println("Metadata Size:  " + list.size());
        for (HasMetadata m : list) {

            System.out.println(">> Metadata:  " + m);
        }

    }


}
