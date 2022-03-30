package com.spicesrus;

import java.util.ArrayList;
import java.util.List;

import com.spicesrus.model.User;
import com.spicesrus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spicesrus.model.Recipes;
import com.spicesrus.model.Spices;
import com.spicesrus.service.EmailHandler;
import com.spicesrus.model.UDetails;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.sql.DataSource;

@SpringBootApplication
@Configuration
public class    SpicesrusApplication implements ApplicationRunner {

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

    public void run(ApplicationArguments args) throws Exception {
        initData();
    }

    private void initData() {

        createUser("michaeljordan", "password", "mcj@google.com", "Michael", "Jordan");
        createUser("example", "password", "example@google.com", "First", "Last");

        createUser("basic", "password", "basic@gmail.com", "Basic", "User");
        createUser("novice", "password", "novice@gmail.com", "Novice", "User", List.of("NOVICE"));
        createUser("expert", "password", "expert@gmail.com", "Expert", "User", List.of("EXPERT"));
        createUser("admin", "password", "admin@gmail.com", "Admin", "User", List.of("ADMIN", "EXPERT"));

        createSpice("Spice Blends", "ALLSPICE", "Allspice is not actually blend of other spices but a berry of an evergreen tree. It's flavor is similar to a blend of nutmeg and cinnamon", 0.85, "https://www.spicemountain.co.uk/wp-content/uploads/2019/10/allspice_1046861527.jpg");
        createSpice("Peppers", "BLACK PEPPER", "Black Pepper adds flavor to almost every food of every nation in the world. It is used in rubs, spice blends and peppercorn blends.", 0.99, "https://stamboulbazaar.com/wp-content/uploads/nc/catalog/Product/Baharatlar/turkish-black-pepper-spice-ground.jpg");
        createSpice("Salts", "GARLIC SALT", "Ideal to have on hand for that garlic flavour.Just add to sauces and dips, on pizzas and in salad dressings..", 1.20, "https://thekitchencommunity.org/wp-content/uploads/2021/04/Garlic-Powder-1200x900.jpg");
        createSpice("Peppers", "LONG PEPPER", "This pepper is mostly used in slow cooked dishes & pickels.It smells sweetley fragrant, but has a biting aftertaste.", 3.00, "https://www.seeds-gallery.shop/7492-large_default/indian-long-pepper-spice-whole-piper-longum.jpg");
        
        Recipes r1 = new Recipes();
        r1.setRestricted(true); // can only be accessed by novice+
        r1.setCategory("Breakfast");
        r1.setDescription("Eggs for breakfast is a genuinely global phenomenon and there is a dazzling array of recipes from around the world using them. This one is from North Africa (versions of it are popular throughout the Middle East)");
        r1.setName("Shakshuka");
        r1.setPicture("https://www.spicemountain.co.uk/wp-content/uploads/2019/08/shakshuka.jpg");
        r1.setFullDescription("Eggs for breakfast is a genuinely global phenomenon and there is a dazzling array of recipes from around the world using them. This one is from North Africa (versions of it are popular throughout the Middle East), "
        		+ "and the other main ingredient apart from egg is tomato. Various veggies can be added depending on which country�s recipe you are following, but we like it best just adding plenty of sweet peppers, whichever colour you choose."
        		+ " It is spiced with cumin seeds, caraway seeds, cayenne and paprika (our Harissa spice blend does the job perfectly), and is lovely served with a hunk of bread, or a warm pitta bread. Along with the similar Mexican Huevos Rancheros, "
        		+ "this is one of our favourite Sunday brunch treats."); 
        r1.setIngredients(List.of("2tbs Olive Oil", "1 Onion, finely sliced", "1 Red Pepper, diced","1 Yellow Pepper, diced", "3 cloves Garlic, finely chopped",
                "2tsp Sweet Paprika", "1/2 Cumin Seeds", "1/2 Caraway Seeds", "1/2 Cayenne Pepper", "2 tins Plum Tomatoes", "1tsp Sugar", "4 Eggs", "2tsp Lemon Juice"));
        r1.setMethod(List.of("Heat olive oil and cook onion", "Cook peppers", "Keep sauteeing until soft", "Add the garlic and spices and cook for another couple of minutes", "Using the back of a large spoon, make 4 dips in the sauce, then crack an egg into each one.",
        		"Put a lid on the pan, then cook over a low heat for 6-8 mins, until the eggs are done to your liking."));

        r1 = recipesRepo.save(r1);
        
        Recipes r2 = new Recipes();
        r2.setRestricted(true); // can only be accessed by novice+
        r2.setCategory("Dinner");
        r2.setDescription("Sheet pan pizza is a style of pizza where you make the dough in a sheet pan, instead of stretching it into a circle like our traditional Italian pizza dough. You can also skip using a pizza peel and stone."); 
        r2.setName("Sheet Pan Pizza");
        r2.setPicture("https://www.acouplecooks.com/wp-content/uploads/2021/06/Arugula-Pizza-003.jpg");
        r2.setIngredients(List.of("1.5 cup pizza sauce (purchased or our favorite Easy Pizza Sauce)","1 cup (3 ounces) shredded smoked gouda cheese","0.5 cup shredded Parmesan cheese","6 ounces fresh mozzarella cheese","Optional topping: 4 cups (3 ounces) baby arugula", "1 tablespoon olive oil",  "1/4 teaspoon kosher salt"));
        r2.setMethod(List.of("Make the dough (5 minutes): In a large bowl, stir together the all-purpose flour, yeast, kosher salt, oregano and garlic powder.","Add the warm water and olive oil and stir until flour is incorporated.","Continue kneading for 8 minutes until the dough feels pillowy and has a smooth, stretchy exterior. "));	
        r2.setTimeRequired(45);
        
        r2 = recipesRepo.save(r2);

        Recipes r3 = new Recipes();
        r3.setCategory("Pastries");
        r3.setDescription("An Autumn Sunday, a walk in the woods (or the park) and a lovely crumble waiting to be enjoyed when you get home, smothered in creamy custard to take the chill out of your bones.");
        r3.setName("Apple and Blackberry Crumble Custard");
        r3.setPicture("https://media.istockphoto.com/photos/ice-cream-apple-crisp-picture-id185229208?k=20&m=185229208&s=612x612&w=0&h=xuxEGADJhuIGW-9Kkn9io6RxLvcPR-1el68wR01EvOA=");
        r3.setFullDescription("An Autumn Sunday, a walk in the woods (or the park) and a lovely crumble waiting to be enjoyed when you get home, "
        		+ "smothered in creamy custard to take the chill out of your bones. Apple and blackberry are bang in season at this time of year, "
        		+ "and though of course there is merit in rhubarb for the crumble, the apple and blackberry pairing just sums up English sweets "
        		+ "for us. This recipe uses our cinnamon sugar blend in the crumble, and our vanilla sugar for the custard, just for extra luxury.");
        r3.setIngredients(List.of("120g Plain Flour", "60g cinnamon sugar", "60g unsalted butter", "300g diced apples","30g unsalted butter",
        		"30g demerara sugar", "115g blackberries","1tsp ground mixed spice", "200ml double cream", "700ml whole milk", "4 large egg yolks",
        		"3tbs cornflour","200g vanilla sugar"));
        r3.setMethod(List.of("Preheat oven to 190c", "Prepare the fruit", "Melt the butter and sugar in saucepan on medium heat", "Cook for 3 minutes until a light caramel",
        		"Stir in apples and cook for 3 minutes", "Add the blackberries and mixed spices", "Cook for 3 minutes then set aside while you make the crumble",
        		"Mix flour and sugar in large bowl", "Add the butter and rub in to make a breadcrumb texture", "Spread on baking sheet and cook for 15 minutes",
        		"Spoon the fruit compote into a baking tray", "Top with the crumble mix and finish for 15 mins in the oven.", 
        		"Add cream and milk into a large pan and slowly bring it to just below boiling point", "Whisk together the egg yolks, vanilla sugar and cornflour",
        		"Add the warmed milk and cream, whisking constantly", "Return everything to the pan, heat gently, stirring all the time, until the custard thickens."));

        r3 = recipesRepo.save(r3);

        Recipes r4 = new Recipes();
        r4.setCategory("Lunch");
        r4.setDescription("A long-term favourite for picking up from the deli counter, there are as many recipes for hummus as there are chickpeas in a sack, but we make no apology for stating that this recipe is the best!");
        r4.setName("Hummus");
        r4.setPicture("https://img.freepik.com/darmowe-zdjecie/pyszny-hummus_144627-19472.jpg?t=st=1647339211~exp=1647339811~hmac=7acf2f4c66577fc8170c8d045d58c18130f442687f5dcbd5d8284b22fe5b40e2&w=740");
        r4.setFullDescription("A long-term favourite for picking up from the deli counter, there are as many recipes for hummus as there are chickpeas in a sack, but we make no apology for stating that this recipe is the best! "
        		+ "The reason for the variety in recipes is that hummus is a staple in most of the countries surrounding the eastern Mediterranean and into the Middle East, all of which have their own little foibles when it comes to seasoning the hummus. "
        		+ "Our take is based on the Israeli version, which is always served with a blob of harissa-style hot sauce in the middle, this procedure is highly recommended. Tinned chickpeas are far and away the easiest (and fortunately the best) to use for the recipe.");
        r4.setIngredients(List.of("2 Tins Chickpeas", "1tbs olive oil", "1tbs tahini paste", "1tsp garlic powder or granules" ,"1tbs lemon juice", "salt and pepper","1tsp ground cumin", "1tsp cayenne pepper"));
    			
        r4.setMethod(List.of("Drain the chickpeas and blend with other dry ingredients and the tahini", "Pour in the oliver oil and lemon jucice while blending", "Whizz together, pour in the olive oil then the lemon juice.", 
        		"You may need to add a splash of water (or more lemon juice).", "You will need to blend the hummus for five minutes", "Check the hummus for seasoning, and it is ready to serve"));
        
        ArrayList<Spices> r4spices = new ArrayList<Spices>();
        r4spices.add(spicesRepo.findByName("BLACK PEPPER"));
        r4.setSpicesInvolved(r4spices);

        r4 = recipesRepo.save(r4);

        Recipes r5 = new Recipes();
        r5.setCategory("Dinner");
        r5.setDescription("Any fan of Japanese food will be aware that a Katsu Curry is a heavenly experience! What sets it apart are a couple of things – First, the chicken is breadcrumbed and fried, second the");
        r5.setName("Chicken Katsu Curry");
        r5.setPicture("https://us.123rf.com/450wm/amnajtandee/amnajtandee1704/amnajtandee170400026/75769947-curry-ryż-z-smażącą-wieprzowiną-japońskie-jedzenie-tonkatsu-curry-rice-na-białym-tle-.jpg?ver=6");
        r5.setFullDescription("Any fan of Japanese food will be aware that a Katsu Curry is a heavenly experience! What sets it apart are a couple of things; First, the chicken is breadcrumbed and fried, second the sauce is made separately "
        		+ "and then used to smother the crispy chicken in a blanket of smooth, silky luxury. The sauce is not hot by any means, more warm and aromatic with distinctive fruity notes. It has a marked sweetness, especially once the honey is added. "
        		+ "The texture of the sauce makes for a wonderful contrast with the crunch of the chicken. This recipe is perfect as a midweek supper, and due to the mild, fruity flavour of the sauce kids will love it. To sum up, a combination of fried chicken and yummy curry sauce? Yes please!");
        r5.setIngredients(List.of("2 chicken breasts", "1 egg beaten", "100g panko breadcrumbs", "50g flour, seasoned with salt and pepper" , "2 tsp Katsu curry blend", "1 tsp soy sauce", "2 tsp honey", "1 bay leaf", "1tbs plain flour", "250ml water or chicken stock"));
        r5.setMethod(List.of("Heat 1tbs sunflour oil and add the flour", "Cooke for a minute then add the Katsu curry blend", "Stir this spiced mixture in and cook for a further minute.", "Slowly pour in the water or chicken stock, stirring all the time to avoid any lumps.",
        		"Add the honey, soy sauce and a bay leaf.", "Bring the sauce to the boil, then reduce the heat and let it simmer", "You can add more water or stock for a more desirable consistency. You want to achieve a nice, thick, velvety smooth sauce.",
        		"Run a knife through the middle of the thick part of the breast and open it up", "Dredge the chicken first in the flour, then in the egg and lastly in the panko crumbs.", "Heat sunflower oil in a deep frying pan.",
        		"Lay the breaded chicken into the oil and fry until the chicken is golden and crispy.", "Remove from the pan and drain on kitchen paper.", 
        		"To serve, slice the chicken diagonally then smother it with your katsu sauce, alongside plain steamed rice and a crispy salad."));
        
        Recipes r6 = new Recipes();
        r6.setCategory("Dinner");
        r6.setDescription("A hearty noodle dish for those cold nights.");
        r6.setName("Chicken Ramen");
        r6.setPicture("https://www.modernhoney.com/wp-content/uploads/2018/07/Homemade-Chicken-Ramen-1.jpg");
        r6.setFullDescription("Ramen is a noodle soup dish. Shoyu ramen soup is a clear, brown broth flavored with soy sauce (shoyu). The soup is made of chicken broth. "
        		+ "Ramen are eaten with chopsticks, a Chinese-style spoon is often provided as well to help with small toppings and for drinking the soup.");
        r6.setIngredients(List.of("1.2l good-quality chicken stock", "coriander, stalks and leaves separated", "1 red chilli", "2 tbsp light soy sauce", "100g grey oyster mushrooms, sliced",
        		"100g baby pak choi", "2 cooked chicken breasts, sliced", "100g egg noodles", "50g sliced bamboo shoots"));
       
        r6.setMethod(List.of("Heat 1tbs sunflour oil and add the flour", "Cooke for a minute then add the Katsu curry blend", "Set a large saucepan over a medium heat and pour in the stock.",
        		"Finely chop the coriander stalks and add to the stock with most of a sliced chilli.", "Bring to the boil and add 200ml water.", 
        		"Once boiled, reduce the heat and simmer for 5-10 mins to infuse the coriander and chilli.", "Add the soy sauce and a grinding of black pepper, then the mushrooms, pak choi, chicken and noodles.",
        		"Simmer for 2 mins until the noodles soften, before adding the bamboo shoots.", " Serve in deep bowls topped with coriander leaves and the remaining chilli slices."));
        
        r5 = recipesRepo.save(r5);
        r6 = recipesRepo.save(r6);
        
        r5.addComplimentaryRecipes(r6);
        r6.addComplimentaryRecipes(r5);
        
        r5 = recipesRepo.save(r5);
        r6 = recipesRepo.save(r6);
        
        recipes.add(r1);
        recipes.add(r2);
        recipes.add(r3);
        recipes.add(r4);
        recipes.add(r5);
        recipes.add(r6);

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