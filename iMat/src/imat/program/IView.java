package imat.program;

import java.util.List;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCartListener;

/**
 * Interface for the iMat view class.
 * @author Plankton555
 * @version (2012-02-27)
 */
public interface IView {

	/**
	 * @return The shopping cart listener.
	 */
	public ShoppingCartListener getShoppingCartListener();
	
	/**
	 * Sets the list of favorite cart names.
	 * @param cartNames Names of the favorite carts.
	 */
	public void setFavoriteCartList(List<String> cartNames);
	
	/**
	 * Displays the specified cart.
	 * @param order The selected cart/order.
	 */
	public void displaySelectedCart(NamedOrder order);

	/**
	 * Closes any open product ("popup") window.
	 */
	public void closeProductWindow();

	/**
	 * Opens the product ("popup") window of the specified product.
	 * @param product The product.
	 */
	public void openProductWindow(Product product);

	/**
	 * Shows the "Thanks for the order"-page and displays the specified order.
	 * @param order The order.
	 */
	public void showFinishedPaymentPage(Order order);

	/**
	 * Called if the user tries to pay without accepting the terms of agreement.
	 */
	public void termsNotAccepted();

	/**
	 * Informs the user that there is no such user in the database.
	 * Called if the user tries to login with a username that's nonexistent.
	 */
	public void noSuchUser();

	/**
	 * Opens the product checkout window of the specified product.
	 * @param product The product.
	 */
	public void openCheckoutProductWindow(Product product);

	/**
	 * Asks the user to confirm clearing the shopping cart.
	 * If return is true, then the shopping cart will be cleared.
	 * If return is false, nothing will happen.
	 * @return true if shopping cart should be cleared, false does nothing.
	 */
	public boolean confirmClearShoppingCart();

	/**
	 * Shows the specified products on the main page.
	 * @param products The list of products to be shown.
	 */
	public void showProducts(List<Product> products);

	/**
	 * Switches to the check-out page (sv: Kassan).
	 */
	public void showCheckoutPage();

	/**
	 * Switches to the earlier-orders page (sv: Historik/Tidigare kundvagnar).
	 */
	public void showEarlierOrdersPage();

	/**
	 * Switches to the login page.
	 */
	public void showLoginPage();

	/**
	 * Switches to the payment page.
	 * @param paymentInfo The saved payment information about the logged in user.
	 */
	public void showPaymentPage(PaymentInfo paymentInfo);

	/**
	 * Switches to the register page.
	 */
	public void showRegisterPage();

	/**
	 * Switches to the welcome page.
	 */
	public void showWelcomePage();

	/**
	 * Informs the user that the password and repeated passwords don't match.
	 * Shown on the registration page.
	 */
	public void passwordsNotMatching();

	/**
	 * Switches to the main page where you can see and select products.
	 */
	public void showMainShoppingPage();

	/**
	 * Shows which user is logged in. This method is called when a user logs in.
	 * @param loggedInUser The user object.
	 */
	public void setLoggedInUser(IMatUser loggedInUser);
}
