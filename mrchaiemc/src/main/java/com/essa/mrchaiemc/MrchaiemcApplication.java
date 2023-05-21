package com.essa.mrchaiemc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value={"rpc"})
public class MrchaiemcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrchaiemcApplication.class, args);
	}

}
