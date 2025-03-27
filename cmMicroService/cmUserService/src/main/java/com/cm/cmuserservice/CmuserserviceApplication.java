package com.cm.cmuserservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.h2.tools.Server;

@SpringBootApplication
public class CmuserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmuserserviceApplication.class, args);
    }


    // CommandLineRunner to start H2 TCP server on application startup
    @Bean
    public CommandLineRunner startH2Server() {
        return args -> {
            Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
        };
    }
}
