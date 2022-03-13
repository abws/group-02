package com.example.spicesrus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.context.Context;

import com.example.spicesrus.entities.Basket;
import com.example.spicesrus.entities.Recipes;
import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.BasketRepository;
import com.example.spicesrus.repo.RecipesRepository;
import com.example.spicesrus.repo.SpicesRepository;
import com.example.spicesrus.security.EmailHandler;
import com.example.spicesrus.security.UDetails;
import com.example.spicesrus.security.UDetailsRepo;

@SpringBootApplication
@Configuration
public class SpicesrusApplication implements ApplicationRunner {

	@Autowired
	private SpicesRepository spicesRepo;

	@Autowired
	private UDetailsRepo detailsRepo;
	
	@Autowired
	private BasketRepository basketrepo;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private RecipesRepository recipesRepo;
	
	@Autowired
	private EmailHandler handler;


	public static List<Spices> spices = new ArrayList<>();

	public static List<UDetails> users = new ArrayList<>();

	public static List<Recipes> recipes = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(SpicesrusApplication.class, args);
    }
    
    public void run(ApplicationArguments args) throws Exception{

    	Basket basket = new Basket();
    	basket = basketrepo.save(basket);

		UDetails ud = new UDetails();
		ud.setUsername("michaeljordan");
		ud.setPassword(encoder.encode("password"));
		ud.setEmail("mcj@google.com");
		ud.setFirstName("Michael");
		ud.setLastName("Jordan");

		UDetails ud2 = new UDetails();
		ud2.setUsername("example");
		ud2.setPassword(encoder.encode("password"));
		ud2.setEmail("example@google.com");
		ud2.setFirstName("First");
		ud2.setLastName("Last");
		detailsRepo.save(ud);
		detailsRepo.save(ud2);

		UDetails dto = new UDetails();
		dto.setPassword(encoder.encode("password"));
		dto.setLastName("User");
		dto.setUsername("basic");
		dto.setFirstName("Basic");
		dto.setEmail("basic@gmail.com");
		dto.setAuthorities(List.of("BASIC"));
		detailsRepo.save(dto);
		dto.setUsername("novice");
		dto.setFirstName("Novice");
		dto.setEmail("novice@gmail.com");
		dto.setAuthorities(List.of("NOVICE"));
		detailsRepo.save(dto);
		dto.setUsername("expert");
		dto.setFirstName("Expert");
		dto.setEmail("expert@gmail.com");
		dto.setAuthorities(List.of("EXPERT"));
		detailsRepo.save(dto);
		dto.setUsername("admin");
		dto.setFirstName("admin");
		dto.setAuthorities(List.of("EXPERT", "ADMIN"));
		dto.setEmail("admin@gmail.com");
		detailsRepo.save(dto);

    	Spices s1 = new Spices();
    	s1.setName("ALLSPICE");
    	s1.setCategory("Spice Blends");
    	s1.setPrice(0.85);
    	s1.setDescription("Allspice is not actually blend of other spices but a berry of an evergreen tree. It's flavor is similar to a blend of nutmeg and cinnamon");
    	s1.setPicture("https://www.spicemountain.co.uk/wp-content/uploads/2019/10/allspice_1046861527.jpg");
    	s1 = spicesRepo.save(s1);
    	
    	Spices s2 = new Spices();
    	s2.setName("BLACK PEPPER");
    	s2.setCategory("Peppers");
    	s2.setPrice(0.99);
    	s2.setDescription("Black Pepper adds flavor to almost every food of every nation in the world. It is used in rubs, spice blends and peppercorn blends.");
    	s2.setPicture("https://stamboulbazaar.com/wp-content/uploads/nc/catalog/Product/Baharatlar/turkish-black-pepper-spice-ground.jpg");
    	s2 = spicesRepo.save(s2);
    	
    	Spices s3 = new Spices();
    	s3.setName("GARLIC SALT");
    	s3.setCategory("Salts");
    	s3.setPrice(1.20);
    	s3.setDescription("Ideal to have on hand for that garlic flavour.Just add to sauces and dips, on pizzas and in salad dressings.");
    	s3.setPicture("https://thekitchencommunity.org/wp-content/uploads/2021/04/Garlic-Powder.jpg");
    	s3 = spicesRepo.save(s3);
    	
    	Spices s4 = new Spices();
    	s4.setName("LONG PEPPER");
    	s4.setCategory("Peppers");
    	s4.setPrice(3.00);
    	s4.setDescription("This pepper is mostly used in slow cooked dishes & pickels.It smells sweetley fragrant, but has a biting aftertaste.");
    	s4.setPicture("https://cdn.shopify.com/s/files/1/1745/8453/products/photo1_d6ee5edf-6270-452a-b368-b2351ae4b27a_1024x1024.jpg?v=1639330805");
    	s4 = spicesRepo.save(s4);
    	
    	Recipes r1 = new Recipes();
    	r1.setCategory("Breakfast");
    	r1.setDescription("Eggs for breakfast is a genuinely global phenomenon and there is a dazzling array of recipes from around the world using them. This one is from North Africa (versions of it are popular throughout the");
    	r1.setName("Shakshuka");
    	r1.setPicture("https://www.spicemountain.co.uk/wp-content/uploads/2019/08/shakshuka.jpg");
    	r1 = recipesRepo.save(r1);
    	
    	Recipes r2 = new Recipes();
    	r2.setCategory("Cakes and Pies");
    	r2.setDescription("An Autumn Sunday, a walk in the woods (or the park) and a lovely crumble waiting to be enjoyed when you get home, smothered in creamy custard to take the chill out of your bones.");
    	r2.setName("Apple & Blackberry Crumble/Custard");
    	r2.setPicture("https://www.spicemountain.co.uk/wp-content/uploads/2019/10/apple-and-blackberry-crumble-recipes.jpg");
    	r2 = recipesRepo.save(r2);
    	
    	Recipes r3 = new Recipes();
    	r3.setCategory("Lunch");
    	r3.setDescription("A long-term favourite for picking up from the deli counter, there are as many recipes for hummus as there are chickpeas in a sack, but we make no apology for stating that this recipe is the best!");
    	r3.setName("Hummus");
    	r3.setPicture("https://www.spicemountain.co.uk/wp-content/uploads/2019/10/hummus-1.jpg");
    	r3 = recipesRepo.save(r3);
    	
    	Recipes r4 = new Recipes();
    	r4.setCategory("Dinner");
    	r4.setDescription("Any fan of Japanese food will be aware that a Katsu Curry is a heavenly experience! What sets it apart are a couple of things – First, the chicken is breadcrumbed and fried, second the");
    	r4.setName("Chicken Katsu Curry");
    	r4.setPicture("https://www.notenoughcinnamon.com/wp-content/uploads/2020/11/Healthy-Chicken-Katsu-Curry-2.jpg");
    	r4 = recipesRepo.save(r4);
    	
    	
    	
    	spices.add(s1);
    	spices.add(s2);
    	spices.add(s3);
    	spices.add(s4);
    	users.add(ud2);
    	recipes.add(r1);
    	recipes.add(r2);
    	recipes.add(r3);
    	recipes.add(r4);

    }
}