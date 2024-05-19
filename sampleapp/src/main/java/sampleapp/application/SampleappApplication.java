package sampleapp.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sampleapp")
@MapperScan("sampleapp.mapper")
public class SampleappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleappApplication.class, args);
    }

}
