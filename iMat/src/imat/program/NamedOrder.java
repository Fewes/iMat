package imat.program;

import se.chalmers.ait.dat215.project.Order;


/**
 * Extends from the Order class. This is because we want names on the orders.
 * @author Plankton555
 * @version (2012-02-22)
 */
public class NamedOrder extends Order {

	private String name;
	
	/**
	 * Creates a new named order from an unnamed one.
	 * @param order Unnamed order.
	 * @param name Name of the order.
	 */
	public NamedOrder(Order order, String name)
	{
		this(name);
		this.setDate(order.getDate());
		this.setItems(order.getItems());
		this.setOrderNumber(order.getOrderNumber());
	}
	
	/**
	 * Creates a new empty named order.
	 * @param name Name of the order.
	 */
	public NamedOrder(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return The name of the order.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the name.
	 * @param name The name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
