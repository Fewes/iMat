package imat.program;

import java.util.List;
import se.chalmers.ait.dat215.project.Product;



/**
 * An interface for the controller to implement.
 * @author Plankton555
 * @version (2012-02-26)
 */
public interface IController
{
	/** Shows the start (home) page. */
	public void showStartPage();
	
	/** Shows the login page. */
	public void showLoginPage();
	
	/** Shows the registration page. */
	public void showRegisterPage();
	
	/** Shows the former carts page. */
	public void showFormerCartsPage();
	
	/** Shows the checkout page where you review your products and continue to payment. */
	public void showCheckoutPage();
	
	/** Shows the payment page where you provide your payment information. */
	public void showPaymentPage();

	/**
	 * Logs in with the specified username and password
	 * @param userName Username.
	 * @param password Password.
	 */
	public void login(String username, String password);

	/**
	 * Registers a new user with the specified information.
	 * Password and repeated password must be the same.
	 * @param firstName First name.
	 * @param surname Surname.
	 * @param userName Username.
	 * @param password Password.
	 * @param repeatedPassword Repeated password.
	 */
	public void registerUser(String firstName, String surname,
			String username, String password, String repeatedPassword);

	/**
	 * Shows the specified category in the product and category views.
	 * @param category Category.
	 */
	public void showCategory(Category category);
	
	/**
	 * Performs a search with the provided search string.
	 * @param searchString Search string.
	 */
	public void searchFor(String searchString);
	
	/**
	 * Opens a more detailed view of the specified product.
	 * @param product Product.
	 */
	public void showProduct(Product product);
	
	/**
	 * Opens a detailed view of the specified product on the checkout screen.
	 * @param product Product.
	 */
	public void showCheckoutProduct(Product product);
	
	/** Closes any open detailed product view. */
	public void closeCurrentProduct();
	
	/**
	 * Toggles the favorite status of the product. If already a favorite,
	 * removes from favorites. If not a favorite, adds to favorites.
	 * @param product
	 */
	public void toggleFavorite(Product product);
        
        public boolean isFavorite(Product p);
        
        public void addProduct(Product p, double amount);
	
	/**
	 * Updates the cart to contain the specified amount of the product.
	 * If amount is 0, then the product will be removed from the cart.
	 * @param product Product.
	 * @param amount Amount of the product.
	 */
	public void updateCart(Product product, double amount);
	
	/**
	 * Empties the shopping cart.
	 */
	public void emptyShoppingCart();
	
	/**
	 * Adds the specified shopping cart to the current one.
	 * @param cartName Name of the shopping cart.
	 */
	public void addShoppingCart(String cartName);
	
	/**
	 * Adds the shopping cart to the favourites under the new name.
	 * @param cartName Original name of the shopping cart.
	 * @param favName The new name of the shopping cart.
	 */
	public void addCartToFav(String cartName, String favName);
	
	/**
	 * Removes the specified chopping cart from the favourites.
	 * @param cartName Name of the shopping cart.
	 */
	public void removeCartFromFav(String cartName);
	
	/**
	 * Places the order.
	 * @param termsAccepted True if the terms of agreement is accepted, otherwise false.
	 */
	public void finishPayment(PaymentInfo paymentInfo);
	
	/**
	 * Shuts the program down.
	 */
	public void shutDown();
	
	/**
	 * Displays the selected shopping cart in the "former carts" view.
	 * @param cartName Name of the cart to be displayed.
	 */
	public void showShoppingCart(String cartName);
	
	/**
	 * @return A list of campaign products.
	 */
	public List<Product> getCampaignProducts();
} 