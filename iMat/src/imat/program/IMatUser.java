package imat.program;


/**
 * User class.
 * @author Plankton555
 * @version (2012-02-27)
 */
public class IMatUser {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	private PaymentInfo paymentInfo;
	
	public IMatUser(String firstName, String lastName, String username, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		
		this.paymentInfo = new PaymentInfo();
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	public PaymentInfo getPaymentInfo() {
		return this.paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
