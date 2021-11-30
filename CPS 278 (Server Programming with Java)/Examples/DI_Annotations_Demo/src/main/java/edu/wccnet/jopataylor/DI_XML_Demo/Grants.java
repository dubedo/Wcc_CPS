package edu.wccnet.jopataylor.DI_XML_Demo;

import org.springframework.stereotype.Component;

@Component
public class Grants implements FinaidService {

	public String getFinAidType() {
		return "Grants";
	}

}
