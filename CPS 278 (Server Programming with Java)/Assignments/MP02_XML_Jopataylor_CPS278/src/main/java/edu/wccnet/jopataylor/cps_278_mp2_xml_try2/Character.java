package edu.wccnet.jopataylor.cps_278_mp2_xml_try2;

import org.springframework.beans.factory.annotation.Autowired;

public class Character {

	String name;
	int health;
	int strength;

	FightingPower fightingPower;

	public String useFightingPower() {
		return name + fightingPower.getFightingPowerDesc();
	}

	@Autowired
	public Character(String name, FightingPower fightingPower) {

		this.name = name;
		this.fightingPower = fightingPower;
	}

	public void setFightingPower(FightingPower fightingPower) {
		this.fightingPower = fightingPower;
	}

	public String getName() {
		return name;
	}

}
