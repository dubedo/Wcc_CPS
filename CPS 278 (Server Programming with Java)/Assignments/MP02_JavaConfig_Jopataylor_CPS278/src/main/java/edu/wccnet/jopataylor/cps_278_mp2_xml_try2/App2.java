package edu.wccnet.jopataylor.cps_278_mp2_xml_try2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		Battle theBattle = (Battle) context.getBean("battle");
		theBattle.fight();

		context.close();

	}

}
