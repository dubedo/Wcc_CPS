package jingExamplesVid3;

import java.util.ArrayList;

class RegistrationInfo {
	String className;
	String option;
	String note;

	@Override
	public String toString() {
		return "Registration [className=" + className + ", option=" + option + ", note=" + note + "]";
	}

	public RegistrationInfo(String className, String option, String note) {

		this.className = className;
		this.option = option;
		this.note = note;
	}

}

public class Registration {
	ArrayList<RegistrationInfo> regList = new ArrayList<>();

	public void addToList(RegistrationInfo r) {
		regList.add(r);
	}

	public String toString() {
		String str = "";
		for (RegistrationInfo registration : regList) {
			str = str + registration.toString() + "\n";
		}
		return str;
	}

}