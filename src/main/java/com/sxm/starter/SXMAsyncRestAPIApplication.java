package com.sxm.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.sxm"})
public class SXMAsyncRestAPIApplication {

    public static void main(String[] args) {


        SpringApplication.run(SXMAsyncRestAPIApplication.class,args);


    }

}
