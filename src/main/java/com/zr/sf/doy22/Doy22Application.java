package com.zr.sf.doy22;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zr.sf.doy22.dao")
public class Doy22Application {

    public static void main(String[] args) {
        SpringApplication.run(Doy22Application.class, args);
    }

}
