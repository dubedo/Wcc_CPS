package edu.wccnet.jopataylor.cps_278_mp2_xml_try2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Battle theBattle = (Battle) context.getBean("battle");
		theBattle.fight();

		((ClassPathXmlApplicationContext) context).close();

	}

}
