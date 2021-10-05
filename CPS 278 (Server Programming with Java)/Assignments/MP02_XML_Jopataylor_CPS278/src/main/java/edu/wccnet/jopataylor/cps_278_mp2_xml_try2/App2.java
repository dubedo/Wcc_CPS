package edu.wccnet.jopataylor.cps_278_mp2_xml_try2;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App2 {

	public static void main(String[] args) {

		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beans.xml");

		Battle theBattle = (Battle) context.getBean("battle");
		theBattle.fight();

		((FileSystemXmlApplicationContext) context).close();

	}

}
 