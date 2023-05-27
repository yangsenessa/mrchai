package com.essa.mrchaiemc;

import com.essa.mrchaiemc.common.integration.Sysinit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MrchaiemcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrchaiemcApplication.class, args);
		Sysinit.intiConfig();
	}

}
