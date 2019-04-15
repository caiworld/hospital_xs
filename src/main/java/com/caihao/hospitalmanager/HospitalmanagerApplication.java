package com.caihao.hospitalmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.caihao.hospitalmanager.mapper")
public class HospitalmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalmanagerApplication.class, args);
	}

}
