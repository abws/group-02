package com.example.spicesrus;

import com.example.spicesrus.entities.Item;
import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.ItemRepository;
import com.example.spicesrus.repo.SpicesRepository;
import com.example.spicesrus.security.UDetails;
import com.example.spicesrus.security.UDetailsRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpicesrusApplication implements ApplicationRunner {

	@Autowired
	private SpicesRepository spicesRepo;

	@Autowired
	private UDetailsRepo detailsRepo;

	@Autowired
	private PasswordEncoder encoder;
	
	public static List<Spices> spices = new ArrayList<>();


    public static void main(String[] args) {
        SpringApplication.run(SpicesrusApplication.class, args);
    }
    
    public void run(ApplicationArguments args) throws Exception{
    	UDetails ud = new UDetails();
    	ud.setUsername("example");
    	ud.setPassword(encoder.encode("password"));
    	ud.setEmail("example@example.com");
		ud.setFirstName("First Name");
		ud.setLastName("Last Name");
		detailsRepo.save(ud);

    	Spices s1 = new Spices();
    	s1.setName("ALLSPICE");
    	s1.setCategory("Spice Blends");
    	s1.setPrice(0.8);
    	s1.setDescription("Allspice is not actually blend of other spices but a berry of an evergreen tree. It's flavor is similar to a blend of nutmeg, cloves and cinnamon");
    	s1.setPicture("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/AllspiceBowl.JPG/220px-AllspiceBowl.JPG");
    	s1 = spicesRepo.save(s1);
    	
    	Spices s2 = new Spices();
    	s2.setName("BLACK PEPPER");
    	s2.setCategory("Peppers");
    	s2.setPrice(0.99);
    	s2.setDescription("Black Pepper adds flavor to almost every food of every nation in the world. It is used in rubs, spice blends, salad dressings, and peppercorn blends.");
    	s2.setPicture("https://tse2.mm.bing.net/th?id=OIP.kAnWSBo2ETYfDSENYY1s8QHaE7&pid=Api");
    	s2 = spicesRepo.save(s2);
    	
    	Spices s3 = new Spices();
    	s3.setName("GARLIC SALT");
    	s3.setCategory("Salts");
    	s3.setPrice(1.2);
    	s3.setDescription("Ideal to have on hand for that garlic flavour.Just add to sauces and dips, on pizzas and in salad dressings.");
    	s3.setPicture("https://thekitchencommunity.org/wp-content/uploads/2021/04/Garlic-Powder.jpg");
    	s3 = spicesRepo.save(s3);
    	
    	Spices s4 = new Spices();
    	s4.setName("LONG PEPPER");
    	s4.setCategory("Peppers");
    	s4.setPrice(3);
    	s4.setDescription("This pepper is mostly used in slow cooked dishes & pickels.It smells sweetley fragrant, but has a biting aftertaste.");
    	s4.setPicture("https://cdn.shopify.com/s/files/1/1745/8453/products/photo1_d6ee5edf-6270-452a-b368-b2351ae4b27a_1024x1024.jpg?v=1639330805");
    	s4 = spicesRepo.save(s4);
    	
    	spices.add(s1);
    	spices.add(s2);
    	spices.add(s3);
    	spices.add(s4);

    }
}