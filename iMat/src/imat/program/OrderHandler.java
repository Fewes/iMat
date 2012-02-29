package imat.program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;


/**
 * Handles the favorite orders.
 * @author Plankton555
 * @version (2012-02-24)
 */
public class OrderHandler {

	private static OrderHandler instance;
	private IMatDataHandler database;
	private List<Order> allOrders = new ArrayList<Order>();
	private List<NamedOrder> favOrders = new ArrayList<NamedOrder>();
	
	private OrderHandler()
	{
		database = IMatDataHandler.getInstance();
		allOrders = database.getOrders();
		favOrders = loadFromFile();
	}

	public static OrderHandler getInstance()
	{
		if (instance == null)
		{
			instance = new OrderHandler();
		}
		return instance;
	}
	
	private List<NamedOrder> loadFromFile() {

		// Check if order loading is working. After check: seems to work.
		String folderPath = System.getProperty("user.home") + "\\.dat215\\imat\\";
		String fileName = "iMatFavOrders.txt";
		File file = new File(folderPath + fileName);
		String input = "";
		List<NamedOrder> result = new ArrayList<NamedOrder>();
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
			{
				input = input + scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			return result;
		}
		String[] ordersText = input.split(";endl;");
                if( ordersText.length > 1 ) //TODO: Dirty fix. Do something better
                {
                    for (int i=0; i<ordersText.length; i++)
                    {
                            String[] o = ordersText[i].split(";");
                            if (o.length % 2 == 0)
                            {
                                    // Something is wrong in the file. Should be 3 + 2*n nr of items in the order.
                            }
                            String orderName = o[0];
                            Date orderDate = new Date(Long.parseLong(o[1]));
                            int orderNumber = Integer.parseInt(o[2]);
                            List<ShoppingItem> items = new ArrayList<ShoppingItem>();
                            for (int j=3; j<o.length; j+=2)
                            {
                                    int idNbr = Integer.parseInt(o[j]);
                                    double amount = Double.parseDouble(o[j+1]);
                                    items.add(new ShoppingItem(database.getProduct(idNbr), amount));
                            }
                            NamedOrder order = new NamedOrder(orderName);
                            order.setDate(orderDate);
                            order.setOrderNumber(orderNumber);
                            order.setItems(items);
                            result.add(order);
                    }
                }
		return result;
	}
	
	private void saveToFile()
	{
		// Check if order saving is working. After check: seems to work.
		String folderPath = System.getProperty("user.home") + "\\.dat215\\imat\\";
		String fileName = "iMatFavOrders.txt";
		
		StringBuffer dataString = new StringBuffer(100);
		for (NamedOrder order : favOrders)
		{
			dataString.append(order.getName() + ';'
					+ order.getDate().getTime() + ';'
					+ order.getOrderNumber() + ';');
			
			for (ShoppingItem item : order.getItems())
			{
				dataString.append("" + item.getProduct().getProductId() + ';'
						+ item.getAmount() + ';');
			}
		
			dataString.append("endl;");
		}
		
		/*
		 * String dataString = "";
		for (NamedOrder order : favOrders)
		{
			dataString = dataString
					+ order.getName() + ';'
					+ order.getDate().getTime() + ';'
					+ order.getOrderNumber() + ';';
			
			for (ShoppingItem item : order.getItems())
			{
				dataString = dataString
						+ item.getProduct().getProductId() + ';'
						+ item.getAmount() + ';';
			}
		
			dataString = dataString + "endl;";
		}
		 */
		
		// Creates the folder if necessary
		File folder = new File(folderPath);
		if (!folder.exists())
		{
			folder.mkdirs();
		}
		
		File file = new File(folderPath + fileName);
		try {
			Writer out = new BufferedWriter(new FileWriter(file));
			out.write(dataString.toString());
			out.close();
		} catch (IOException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void shutDown()
	{
		saveToFile();
	}
	
	public void updateOrderHandler()
	{
		allOrders = IMatDataHandler.getInstance().getOrders();
	}
	
	public void addFavorite(String cartName, String favName)
	{
		// Goes through the made orders, checking for the specified one. Then adds to favs.
		for (int i=0; i<allOrders.size(); i++)
		{
			if (cartName.equalsIgnoreCase(allOrders.get(i).getDate().toString()))
			{
				favOrders.add(new NamedOrder(allOrders.get(i), favName));
			}
		}
	}
	
	public void removeFavorite(String cartName)
	{
		for (int i=0; i<favOrders.size(); i++)
		{
			if (cartName.equalsIgnoreCase(favOrders.get(i).getName()))
			{
				favOrders.remove(i);
				break;
			}
		}
	}
	
	public List<NamedOrder> getFavOrders()
	{
		return favOrders;
	}

	public void addOrder(String cartName) {
		
		Order order = null;
		boolean inFavs = false;
		// Search through favorites
		for (int i=0; i<favOrders.size(); i++)
		{
			if (cartName.equalsIgnoreCase(favOrders.get(i).getName()))
			{
				order = favOrders.get(i);
				inFavs = true;
				break;
			}
		}
		
		// If not in favorites, search through all orders
		if (!inFavs)
		{
			for (int i=0; i<allOrders.size(); i++)
			{
				if (cartName.equalsIgnoreCase(allOrders.get(i).getDate().toString()))
				{
					order = allOrders.get(i);
					break;
				}
			}
		}
		List<ShoppingItem> items = order.getItems();
		ShoppingCart cart = IMatDataHandler.getInstance().getShoppingCart();
		List<ShoppingItem> cartItems = cart.getItems();
		
		for (ShoppingItem item : items)
		{
			for (int i=0; i<cartItems.size(); i++)
			{
				if (item.getProduct().equals(cartItems.get(i).getProduct())) // Depends on the Product.equals() working as it should
				{
					double amount = cartItems.get(i).getAmount()+item.getAmount();
					cart.removeProduct(item.getProduct());
					cart.addProduct(item.getProduct(), amount);
				}
			}
		}
		// for every item, check if that item product is in the cart
		// if so, get amount, add to this item, remove product from shoppingcart, then add updated product
	}
        
        public void addProduct(Product p, double amount) {
            ShoppingCart cart = IMatDataHandler.getInstance().getShoppingCart();
            //Null pointer exception. Dunno what's wrong but it's not my code. /Fwillebrand
            cart.addProduct(p, amount);
        }

	public void update(Product product, double amount) {
            ShoppingCart cart = IMatDataHandler.getInstance().getShoppingCart();

            cart.removeProduct(product);
            cart.addProduct(product, amount);
	}
}