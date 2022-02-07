package com.example.spicesrus;

import com.example.entities.Spices;
import com.example.repo.SpicesRepository;
import com.example.spicesrus.security.UDetails;
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
    }
}