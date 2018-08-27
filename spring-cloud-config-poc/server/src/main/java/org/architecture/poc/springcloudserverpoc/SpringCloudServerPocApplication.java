package org.architecture.poc.springcloudserverpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudServerPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServerPocApplication.class, args);
    }
}
