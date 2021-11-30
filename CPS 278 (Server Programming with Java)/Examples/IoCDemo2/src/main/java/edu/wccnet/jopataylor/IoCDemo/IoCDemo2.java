package edu.wccnet.jopataylor.IoCDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IoCDemo2 {

	public static void main(String[] args) {

		// IBird chickadee = new SeedEaters();

		// System.out.println(chickadee.getEatingHabit());

		ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig2.xml");

		IBird bird = (IBird) context.getBean("bird");

		System.out.println(bird.getEatingHabit());

		((ClassPathXmlApplicationContext) context).close();

	}

}
