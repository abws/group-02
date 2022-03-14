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
    	r1.setDescription("Eggs for breakfast is a genuinely global phenomenon and there is a dazzling array of recipes from around the world using them. This one is from North Africa (versions of it are popular throughout the Middle East)");
    	r1.setName("Shakshuka");
    	r1.setPicture("https://www.spicemountain.co.uk/wp-content/uploads/2019/08/shakshuka.jpg");
    	r1.setFullDescription(""); //Eggs for breakfast is a genuinely global phenomenon and there is a dazzling array of recipes from around the world using them. This one is from North Africa (versions of it are popular throughout the Middle East), and the other main ingredient apart from egg is tomato. Various veggies can be added depending on which country’s recipe you are following, but we like it best just adding plenty of sweet peppers, whichever colour you choose. It is spiced with cumin seeds, caraway seeds, cayenne and paprika (our Harissa spice blend does the job perfectly), and is lovely served with a hunk of bread, or a warm pitta bread. Along with the similar Mexican Huevos Rancheros, this is one of our favourite Sunday brunch treats.
    	r1.setIngredients("2tbs Olive Oil\n"
    			+ "1 Onion, finely sliced\n"
    			+ "1 Red Pepper, diced\n"
    			+ "1 Yellow Pepper, diced\n"
    			+ "3 cloves Garlic, finely chopped\n"
    			+ "2tsp Sweet Paprika\n"
    			+ "1/2 Cumin Seeds\n"
    			+ "1/2 Caraway Seeds\n"
    			+ "1/2 Cayenne Pepper\n"
    			+ "2 tins Plum Tomatoes\n"
    			+ "1tsp Sugar\n"
    			+ "4 Eggs\n"
    			+ "2tsp Lemon Juice");
    	r1.setMethod("");/*Method
1
In a large, lidded frying pan, heat the olive oil and add the onion, cooking until just starting to turn golden. Add the peppers and keep sauteeing until soft, then add the garlic and spices and cook for another couple of minutes.
2
Pour in the tomatoes and roughly mash everything together before adding the sugar. Bring to a simmer and let the shakshuka cook for half an hour.
3
Now make a few wells in the sauce, and break in the eggs. Season lightly, then turn the heat down as low as possible, cover and cook until the eggs are just set (about 10 minutes). Garnish with chopped fresh coriander, and serve.*/
    	r1 = recipesRepo.save(r1);
    	
    	Recipes r2 = new Recipes();
    	r2.setCategory("Pastries");
    	r2.setDescription("An Autumn Sunday, a walk in the woods (or the park) and a lovely crumble waiting to be enjoyed when you get home, smothered in creamy custard to take the chill out of your bones.");
    	r2.setName("Apple and Blackberry Custard");
    	r2.setPicture("https://www.spicemountain.co.uk/wp-content/uploads/2019/10/apple-and-blackberry-crumble-recipes.jpg");
    	r2.setFullDescription("");//An Autumn Sunday, a walk in the woods (or the park) and a lovely crumble waiting to be enjoyed when you get home, smothered in creamy custard to take the chill out of your bones. Apple and blackberry are bang in season at this time of year, and though of course there is merit in rhubarb for the crumble, the apple and blackberry pairing just sums up English sweets for us. This recipe uses our cinnamon sugar blend in the crumble, and our vanilla sugar for the custard, just for extra luxury.
    	r2.setIngredients("");/*"120g plain flour\n"
    			+ "60g cinnamon sugar\n"
    			+ "60g unsalted butter, cut into pieces\n"
    			+ "300g apples, peeled cored and diced\n"
    			+ "30g unsalted butter\n"
    			+ "30g demerara sugar\n"
    			+ "115g blackberries\n"
    			+ "1tsp ground mixed spice\n"
    			+ "200ml double cream\n"
    			+ "700ml whole milk\n"
    			+ "4 large egg yolks\n"
    			+ "3tbs cornflour\n"
    			+ "200g vanilla sugar*/
    	
    	r2.setMethod("");/*1
First, prepare the fruit. Put the butter and sugar in a saucepan and melt together over a medium heat, then cook gently for 3 mins until the mixture turns to a light caramel.
2
Stir in the apples and cook for another 3 minutes before adding the blackberries and the mixed spice and cooking for 3 minutes more. Set aside while you prepare the crumble.
3
Tip the flour and sugar into a large bowl, add the butter and rub in to make a light breadcrumb texture. Spread this onto a baking sheet and place in an oven preheated to 190c for 15 mins, until lightly coloured.
4
Spoon the fruit compote into a baking tray, then top with the crumble mix and finish for 15 mins in the oven.
5
For the custard, put the cream and milk into a large pan and slowly bring it to just below boiling point (take care, eruptions are messy!) In a large bowl whisk together the egg yolks, vanilla sugar and cornflour.
6
Now add the warmed milk and cream, whisking constantly, before returning everything to the pan and heating gently, stirring all the time, until the custard thickens.
*/
    	r2 = recipesRepo.save(r2);
    	
    	Recipes r3 = new Recipes();
    	r3.setCategory("Lunch");
    	r3.setDescription("A long-term favourite for picking up from the deli counter, there are as many recipes for hummus as there are chickpeas in a sack, but we make no apology for stating that this recipe is the best!");
    	r3.setName("Hummus");
    	r3.setPicture("https://www.spicemountain.co.uk/wp-content/uploads/2019/10/hummus-1.jpg");
    	r2.setFullDescription("");//A long-term favourite for picking up from the deli counter, there are as many recipes for hummus as there are chickpeas in a sack, but we make no apology for stating that this recipe is the best! The reason for the variety in recipes is that hummus is a staple in most of the countries surrounding the eastern Mediterranean and into the Middle East, all of which have their own little foibles when it comes to seasoning the hummus. Our take is based on the Israeli version, which is always served with a blob of harissa-style hot sauce in the middle – this procedure is highly recommended. Tinned chickpeas are far and away the easiest (and fortunately the best) to use for the recipe.
    	r2.setIngredients("");/*2 tins chickpeas\n"
    			+ "1tbs olive oil\n"
    			+ "1tbs tahini paste, available from our Borough Market shop\n"
    			+ "1tsp garlic powder or granules\n"
    			+ "1tbs lemon juice\n"
    			+ "salt and pepper\n"
    			+ "1tsp ground cumin\n"
    			+ "½ tsp cayenne pepper*/
    	r2.setMethod("");/*1
Drain the chickpeas and place in a blender together with the other dry ingredients and the tahini.
2
Whizz together, and while it is whizzing, pour in the olive oil then the lemon juice. The consistency of tinned chickpeas varies quite a lot, some come out drier than others, so you may need to add a splash of water (or more lemon juice).
3
You will need to blend the hummus for five minutes or so. Check the hummus for seasoning, and it is ready to serve. It will keep in the fridge for a couple of days, so hummus is great to make in advance for a lunchbox or tomorrow's sundowner snack.*/
    	r3 = recipesRepo.save(r3);
    	
    	Recipes r4 = new Recipes();
    	r4.setCategory("Dinner");
    	r4.setDescription("Any fan of Japanese food will be aware that a Katsu Curry is a heavenly experience! What sets it apart are a couple of things – First, the chicken is breadcrumbed and fried, second the");
    	r4.setName("Chicken Katsu Curry");
    	r4.setPicture("https://images.kitchenstories.io/wagtailOriginalImages/R2498-final-photo-_0.jpg");
    	r2.setFullDescription("");//Any fan of Japanese food will be aware that a Katsu Curry is a heavenly experience! What sets it apart are a couple of things – First, the chicken is breadcrumbed and fried, second the sauce is made separately and then used to smother the crispy chicken in a blanket of smooth, silky luxury. The sauce is not hot by any means, more warm and aromatic with distinctive fruity notes. It has a marked sweetness, especially once the honey is added. The texture of the sauce makes for a wonderful contrast with the crunch of the chicken. This recipe is perfect as a midweek supper, and due to the mild, fruity flavour of the sauce kids will love it. To sum up – a combination of fried chicken and yummy curry sauce? Yes please!
    	r2.setIngredients("");/*2 chicken breasts\n"
    			+ "1 egg, beaten\n"
    			+ "100g panko breadcrumbs\n"
    			+ "50g flour, seasoned with salt and pepper\n"
    			+ "2 tsp Katsu curry blend\n"
    			+ "1 tsp soy sauce\n"
    			+ "2 tsp honey\n"
    			+ "1 bay leaf\n"
    			+ "1tbs plain flour\n"
    			+ "250ml water or chicken stock*/
    	r2.setMethod("");/*1
First make the sauce. Heat 1tbs sunflower oil in a saucepan and add the flour. Cook the mixture for under a minute before adding the Katsu curry blend. Stir this spiced mixture in and cook for a further minute.
2
Slowly pour in the water or chicken stock, stirring all the time to avoid any lumps. Add the honey, soy sauce and a bay leaf.
3
Bring the sauce to the boil, then reduce the heat and let it simmer away for 15 minutes or so until the sauce has thickened to a bechamel-like consistency – thick, but still pourable. At this stage you can add more water or stock for a more desirable consistency. You want to achieve a nice, thick, velvety smooth sauce. Remember to keep an eye on the pan and give it the odd stir to prevent sticking or burning.
4
Now for the chicken. To prepare, run a knife through the middle of the thick part of the breast and open it up – this will ensure the chicken cooks evenly. Dredge the chicken first in the flour, then in the egg and lastly in the panko crumbs.
5
Heat an inch or two of sunflower oil in a heavy, deep frying pan. To check the temperature of the oil, throw in a morsel of bread – when it sizzles and rises to the surface immediately, the oil is hot enough. Lay the breaded chicken into the oil and fry for 5 minutes or so on either side, until the chicken is golden and crispy. Of course with chicken ensure that it is thoroughly cooked through. Remove from the pan and drain on kitchen paper.
6
To serve, slice the chicken diagonally then smother it with your katsu sauce, alongside plain steamed rice and a crispy salad.*/
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