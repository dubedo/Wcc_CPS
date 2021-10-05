package edu.wccnet.jopataylor.cps_278_mp2_xml_try2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public Battle battle() {
		Battle theBattle = new Battle();
		theBattle.character1 = character1();
		theBattle.character2 = character2();
		theBattle.character1.setFightingPower(handsStyle());
		theBattle.character2.setFightingPower(swordStyle());
		return theBattle;
	}

	@Bean
	public LocationTemerant location() {
		return new LocationTemerant();
	}

	@Bean
	public StyleHands handsStyle() {
		return new StyleHands();
	}

	@Bean
	public StyleSword swordStyle() {
		return new StyleSword();
	}

	@Bean
	public Character character1() {
		return new Character("Arthur");
	}

	@Bean
	public Character character2() {
		return new Character("Solaire");
	}

}
