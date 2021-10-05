package edu.wccnet.jopataylor.cps_278_mp2_xml_try2;

import org.springframework.beans.factory.annotation.Autowired;

public class Battle {

	Character character1;

	Character character2;

	BattleGround battleGround;

	public void fight() {
		System.out.println(battleGround.getBattleGroundDesc() + character1.getName() + " is fighting "
				+ character2.getName() + ". " + character1.useFightingPower() + character2.useFightingPower());
	}

	@Autowired
	public void setBattleGround(BattleGround battleGround) {
		this.battleGround = battleGround;
	}

}
