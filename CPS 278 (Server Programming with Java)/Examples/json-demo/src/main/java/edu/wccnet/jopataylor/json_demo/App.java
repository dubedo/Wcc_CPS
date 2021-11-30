package edu.wccnet.jopataylor.json_demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		try {

			Student student = mapper.readValue(new File("data/student.json"), Student.class);
			System.out.println(student);
			for (String course : student.getCourseList()) {
				System.out.println(course);
			}

			mapper.writeValue(new File("data/newStudent.json"), student);

		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
