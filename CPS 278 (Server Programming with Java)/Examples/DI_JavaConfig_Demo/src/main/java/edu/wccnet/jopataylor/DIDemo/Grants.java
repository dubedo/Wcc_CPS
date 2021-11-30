package edu.wccnet.jopataylor.DIDemo;

import org.springframework.stereotype.Component;

@Component
public class Grants implements FinaidService {

	public String getFinAidType() {
		return "Grants";
	}

}
