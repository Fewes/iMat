package imat.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;

/**
 * Controller class.
 * @author Plankton555
 * @version (2012-02-29)
 */

public class Controller implements IController {

	IView view;
	IMatDataHandler database;
	CategoryHandler categoryHandler;
	OrderHandler orderHandler;
	UserHandler userHandler;
        private static Controller c;
                
	public Controller(IView view)
	{
            c = this;
            this.view = view;
            database = IMatDataHandler.getInstance();
            categoryHandler = CategoryHandler.getInstance();
            orderHandler = OrderHandler.getInstance();
            userHandler = UserHandler.getInstance();

            showStartPage();

            database.getShoppingCart().addShoppingCartListener(view.getShoppingCartListener());
	}
	
        public static Controller getController() {
            return c;
        }
        
	@Override
	public void showStartPage() {
		view.showWelcomePage();
	}

	@Override
	public void showLoginPage() {
		view.showLoginPage();
	}

	@Override
	public void showRegisterPage() {
		view.showRegisterPage();
	}

	@Override
	public void showFormerCartsPage() {
		view.showEarlierOrdersPage();
	}

	@Override
	public void showCheckoutPage() {
		view.showCheckoutPage();
	}

	@Override
	public void showPaymentPage() {
		// If the user is logged in, show his saved payment information.
		if (userHandler.getLoggedInUser() != null)
		{
			view.showPaymentPage(userHandler.getLoggedInUser().getPaymentInfo());
		}
		else // Otherwise, show an empty PaymentInfo.
		{
			view.showPaymentPage(new PaymentInfo());
		}
	}

	@Override
	public void login(String username, String password) {
		if (userHandler.login(username, password))
		{
			// user is now logged in
			view.setLoggedInUser(userHandler.getLoggedInUser());
			view.showMainShoppingPage();
		}
		else
		{
			view.noSuchUser();
		}
	}

	@Override
	public void registerUser(String firstName, String surname, String username,
			String password, String repeatedPassword) {
		
		if (userHandler.registerUser(firstName, surname, username, password))
		{
			// user is now registered and logged in
			view.setLoggedInUser(userHandler.getLoggedInUser());
			view.showMainShoppingPage();
		}
		else
		{
			view.passwordsNotMatching();
		}
		
	}

	@Override
	public void showCategory(Category category) {
		view.showMainShoppingPage();
		List<Product> products = categoryHandler.getProducts(category);
		
		view.showProducts(products);
	}

	@Override
	public void searchFor(String searchString) {
		List<Product> products = database.findProducts(searchString);
		
		view.showProducts(products);
	}

	@Override
	public void showProduct(Product product) {
		view.openProductWindow(product);
	}

	@Override
	public void showCheckoutProduct(Product product) {
		view.openCheckoutProductWindow(product);
	}

	@Override
	public void closeCurrentProduct() {
		view.closeProductWindow();
	}

	@Override
	public void updateCart(Product product, double amount) {
		orderHandler.update(product, amount);
	}

	@Override
	public void emptyShoppingCart() {
		if (view.confirmClearShoppingCart())
		{
			database.getShoppingCart().clear();
		}
		else
		{
			// do nothing
		}
	}

	@Override
	public void addShoppingCart(String cartName) {
		orderHandler.addOrder(cartName);
	}

	@Override
	public void addCartToFav(String cartName, String favName) {
		orderHandler.addFavorite(cartName, favName);
		updateFavCartDisplay();
	}
	
	private void updateFavCartDisplay()
	{
		List<NamedOrder> orders = orderHandler.getFavOrders();
		List<String> cartNames = new ArrayList<String>(orders.size());
		for (NamedOrder order : orders)
		{
			cartNames.add(order.getName());
		}
		view.setFavoriteCartList(cartNames);
	}

	@Override
	public void removeCartFromFav(String cartName) {
		orderHandler.removeFavorite(cartName);
		updateFavCartDisplay();
	}

	@Override
	public void finishPayment(PaymentInfo paymentInfo, boolean termsAccepted) {
		
		if (termsAccepted)
		{
			validatePayment(paymentInfo);
			
			Order order = database.placeOrder();
			view.showFinishedPaymentPage(order);
		}
		else
		{
			view.termsNotAccepted();
		}
	}

	private void validatePayment(PaymentInfo paymentInfo) {
		// Validate the payment here?
		
		if (userHandler.getLoggedInUser() != null) // if any user is logged in, save payment info
		{
			IMatUser user = userHandler.getLoggedInUser();
			user.setPaymentInfo(paymentInfo);
		}
	}

	@Override
	public void shutDown() {
		// Perform shutdown operations, save data and so on

		orderHandler.shutDown();
		userHandler.shutDown();
		database.shutDown();
	}

	@Override
	public void toggleFavorite(Product product) {
		if (database.isFavorite(product))
		{
			database.removeFavorite(product);
		}
		else
		{
			database.addFavorite(product);
		}
	}
        
        public boolean isFavorite(Product product) {
            if (database.isFavorite(product))
                return true;
            else
                return false;
        }

	@Override
	public void showShoppingCart(String cartName) {
		// zzz Show shopping cart
		
	}

	@Override
	public List<Product> getCampaignProducts() {
		int nbrOfProducts = 4;
		List<Product> outputList = new ArrayList<Product>();
		Set<Integer> numbers = new TreeSet<Integer>();
		while (numbers.size() <= nbrOfProducts)
		{
			numbers.add(new Integer((int)(Math.random()*148 + 1)));
		}
		
		for (Integer nbr : numbers)
		{
			outputList.add(database.getProduct(nbr));
		}
		return outputList;
	}

    public void addProduct(Product p, double amount) {
        orderHandler.addProduct(p, amount);
    }

}