package com.example.pirateservice;

import com.example.pirateservice.models.Pirate;
import com.example.pirateservice.models.Raid;
import com.example.pirateservice.models.Ship;
import com.example.pirateservice.repositories.PirateRepository;
import com.example.pirateservice.repositories.RaidRepository;
import com.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPirate(){
		Ship hispaniola = new Ship("Hispaniola");
		shipRepository.save(hispaniola);
		Pirate john = new Pirate("John", "Silver", 30, hispaniola);
		pirateRepository.save(john);

		Ship flyingDutchman = new Ship("The Flying Dutchman");
		shipRepository.save(flyingDutchman);
		Pirate jack = new Pirate("Jack", "Sparrow", 31, flyingDutchman);
		pirateRepository.save(jack);
		Pirate will = new Pirate("Will", "Turner", 28, flyingDutchman);
		pirateRepository.save(will);
		Pirate elizabeth = new Pirate("Elizabeth", "Swann", 27, flyingDutchman);
		pirateRepository.save(elizabeth);

	}

	@Test
	public void addPiratesAndRaids(){
		Ship flyingDutchman = new Ship("The Flying Dutchman");
		shipRepository.save(flyingDutchman);

		Pirate jack = new Pirate("Jack", "Sparrow", 31, flyingDutchman);
		pirateRepository.save(jack);

		Pirate will = new Pirate("Will", "Turner", 28, flyingDutchman);
		pirateRepository.save(will);

		Pirate elizabeth = new Pirate("Elizabeth", "Swann", 27, flyingDutchman);
		pirateRepository.save(elizabeth);

		Raid raid = new Raid("Tortuga", 300);
		raidRepository.save(raid);

		raid.addPirate(jack);
		raid.addPirate(will);
		raid.addPirate(elizabeth);
		raidRepository.save(raid);
	}

}
