package com.sinosoft.fgw.listmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 发改委治理类街乡镇清单管理系统
 * @author tongmingjian
 */
@MapperScan("com.sinosoft.fgw.listmanage.mapper")
@EnableSwagger2
@SpringBootApplication
public class ListManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListManageApplication.class, args);
    }

}
