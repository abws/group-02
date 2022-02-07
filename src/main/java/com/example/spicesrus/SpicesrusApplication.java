package com.example.spicesrus;

import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpicesrusApplication implements ApplicationRunner {

	@Autowired
	private SpicesRepository spicesRepo;
	
    public static void main(String[] args) {
        SpringApplication.run(SpicesrusApplication.class, args);
    }
    
    public void run(ApplicationArguments args) throws Exception{
    	
    	Spices s1 = new Spices();
    	s1.setName("ALLSPICE");
    	s1.setPrice(0.8);
    	s1.setDescription("Allspice is not actually blend of other spices but a berry of an evergreen tree. It's flavor is similar to a blend of nutmeg, cloves and cinnamon");
    	s1.setPicture("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/AllspiceBowl.JPG/220px-AllspiceBowl.JPG");
    	s1 = spicesRepo.save(s1);
    	
    	Spices s2 = new Spices();
    	s2.setName("BLACK PEPPER");
    	s2.setPrice(0.99);
    	s2.setDescription("Black Pepper adds flavor to almost every food of every nation in the world. It is used in rubs, spice blends, salad dressings, and peppercorn blends.");
    	s2.setPicture("https://tse2.mm.bing.net/th?id=OIP.kAnWSBo2ETYfDSENYY1s8QHaE7&pid=Api");
    	s2 = spicesRepo.save(s2);
    	
    }
}