package com.spicesrus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.spicesrus.model.User;
import com.spicesrus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spicesrus.model.Recipes;
import com.spicesrus.model.Spices;
import com.spicesrus.service.EmailHandler;
import com.spicesrus.model.UDetails;

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

	@Autowired
	private CartRepository cRepo;

	@Autowired
	private UserRepository userRepository;

	//@Autowired 
	//private HttpSession httpSession;
	
	public static List<Spices> spices = new ArrayList<>();

	public static List<UDetails> users = new ArrayList<>();

	public static List<Recipes> recipes = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(SpicesrusApplication.class, args);
    }
    
    public void run(ApplicationArguments args) throws Exception{

    	//httpSession.setAttribute("cart", new Cart()); //for testing purposes. add this permamanently later for all session objects

		createUser("michaeljordan", "password", "mcj@google.com", "Michael", "Jordan");
		createUser("example", "password", "example@google.com", "First", "Last");

		createUser("basic", "password", "basic@gmail.com", "Basic", "User");
		createUser("novice", "password", "novice@gmail.com", "Novice", "User", List.of("NOVICE"));
		createUser("expert", "password", "expert@gmail.com", "Expert", "User", List.of("EXPERT"));
		createUser("admin", "password", "admin@gmail.com", "Admin", "User", List.of("ADMIN", "EXPERT"));

		createSpice("Spice Blends", "ALLSPICE", "Allspice is not actually blend of other spices but a berry of an evergreen tree. It's flavor is similar to a blend of nutmeg and cinnamon", 0.85, "https://www.spicemountain.co.uk/wp-content/uploads/2019/10/allspice_1046861527.jpg");
		createSpice("Peppers", "BLACK PEPPER", "Black Pepper adds flavor to almost every food of every nation in the world. It is used in rubs, spice blends and peppercorn blends.", 0.99, "https://stamboulbazaar.com/wp-content/uploads/nc/catalog/Product/Baharatlar/turkish-black-pepper-spice-ground.jpg");
		createSpice("Salts", "GARLIC SALT", "Ideal to have on hand for that garlic flavour.Just add to sauces and dips, on pizzas and in salad dressings..", 1.20, "https://cdn.shopify.com/s/files/1/1745/8453/products/photo1_d6ee5edf-6270-452a-b368-b2351ae4b27a_1024x1024.jpg?v=1639330805");
		createSpice("Peppers", "LONG PEPPER", "This pepper is mostly used in slow cooked dishes & pickels.It smells sweetley fragrant, but has a biting aftertaste.", 3.00, "https://stamboulbazaar.com/wp-content/uploads/nc/catalog/Product/Baharatlar/turkish-black-pepper-spice-ground.jpg");

    	Recipes r1 = new Recipes();
    	r1.setCategory("Pastries");
    	r1.setDescription("");
    	r1.setName("Cinnamon Buns");
    	r1.setPicture("https://www.cookingclassy.com/wp-content/uploads/2020/09/mini-cinnamon-rolls-21.jpg");

    	spicesRepo.findAll().forEach(spice -> spices.add(spice));
    	recipesRepo.save(r1);

    }


    private void createUser(String username, String password, String email, String firstName, String lastName) {
    	createUser(username, password, email, firstName, lastName, List.of("BASIC"));
	}

	private void createUser(String username, String password, String email, String firstName, String lastName, List<String> authorities) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(encoder.encode(password));
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAuthorities(authorities);
		userRepository.save(user);
	}

	private void createSpice(String category, String name, String description, double price, String picture) {
		Spices spice = new Spices();
		spice.setName(name);
		spice.setCategory(category);
		spice.setPrice(price);
		spice.setDescription(description);
		spice.setPicture(picture);
		spicesRepo.save(spice);
	}

}