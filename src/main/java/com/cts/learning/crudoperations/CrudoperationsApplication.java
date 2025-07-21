package com.cts.learning.crudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CrudoperationsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CrudoperationsApplication.class, args);
		/*
		 * // * beans //
		 */
//		String[] beans = context.getBeanDefinitionNames();
//		Arrays.sort(beans);
//		/*
//		 * printing the beans
//		 */
//		for (String bean : beans) {
//			System.err.println(bean);
//		}
		// Employee emp = context.getBean("employee1",Employee.class);
		// System.out.println(em.getName() + " : " + em.getId());

	}

}
