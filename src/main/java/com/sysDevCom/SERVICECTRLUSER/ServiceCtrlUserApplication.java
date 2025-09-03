package com.sysDevCom.SERVICECTRLUSER;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ServiceCtrlUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCtrlUserApplication.class, args);
    }
}
