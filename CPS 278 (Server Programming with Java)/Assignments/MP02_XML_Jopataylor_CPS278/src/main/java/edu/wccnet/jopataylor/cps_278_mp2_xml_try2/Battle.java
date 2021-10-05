package edu.wccnet.jopataylor.cps_278_mp2_xml_try2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
public class Battle {

	@Autowired
	@Qualifier("char1")
	Character character1;
	@Autowired
	@Qualifier("char2")
	Character character2;

	@Autowired
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
