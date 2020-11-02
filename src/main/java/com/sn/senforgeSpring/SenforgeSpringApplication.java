package com.sn.senforgeSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SenforgeSpringApplication {

	public static void main(String[] args) {
        SpringApplication.run(SenforgeSpringApplication.class, args);
		/*
		 * org.springframework.context.ApplicationContext ctx = RoleRepository rolerepo
		 * = ctx.getBean(RoleRepository.class); Role r = new Role();
		 * r.setLibelle("responsable"); rolerepo.save(r);
		 */
	}

}
