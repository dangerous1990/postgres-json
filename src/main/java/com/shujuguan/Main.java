package com.shujuguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by limeng on 17-5-15.
 */
@SpringBootApplication
@ComponentScan("com.shujuguan")
@ServletComponentScan("com.shujuguan.config")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
