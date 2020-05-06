package com.izum286.coviddashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoviddashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoviddashboardApplication.class, args);
    }

}
