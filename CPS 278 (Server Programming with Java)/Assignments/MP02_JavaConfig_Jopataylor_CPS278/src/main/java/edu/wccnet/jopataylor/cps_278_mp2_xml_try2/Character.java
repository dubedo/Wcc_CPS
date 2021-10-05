package edu.wccnet.jopataylor.cps_278_mp2_xml_try2;

public class Character {

	String name;
	int health;
	int strength;

	FightingPower fightingPower;

	public String useFightingPower() {
		return name + fightingPower.getFightingPowerDesc();
	}

	public Character(String name) {

		this.name = name;
	}

	public void setFightingPower(FightingPower fightingPower) {
		this.fightingPower = fightingPower;
	}

	public String getName() {
		return name;
	}

	public void setName(String string) {
		this.name = string;

	}

}
