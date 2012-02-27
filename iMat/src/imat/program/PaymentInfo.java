package imat.program;


/**
 * A class containing payment information.
 * @author Plankton555
 * @version (2012-02-27)
 */
public class PaymentInfo {

	public enum CardType
	{
		VISA, MasterCard;
	}
	
	private CardType cardType;
	private String firstName;
	private String lastName;
	private String postAddress;
	private String postCode;
	private String phoneNumber;
	private String cardNumber;
	private String cardHoldersName;
	private int verificationCode;
	private int validYear;
	private int validMonth;
	
	/**
	 * Creates an empty PaymentInfo object. Use the setters to set the properties.
	 */
	public PaymentInfo()
	{
	}
	
	/**
	 * Creates a PaymentInfo object with the specified properties.
	 * @param firstName First name.
	 * @param lastName Last name.
	 * @param postAddress Post address.
	 * @param postCode Post code.
	 * @param city City.
	 * @param phoneNumber Phone number.
	 * @param cardType Card type.
	 * @param cardNumber Credit card number.
	 * @param cardHoldersName The card holders name.
	 * @param verificationCode Credit card verification code.
	 * @param validMonth Credit card valid until this month.
	 * @param validYear Credit card valid until this year.
	 */
	public PaymentInfo(String firstName, String lastName, String postAddress,
			String postCode, String city, String phoneNumber, CardType cardType,
			String cardNumber, String cardHoldersName, int verificationCode,
			int validMonth, int validYear)
	{
		this.cardHoldersName = cardHoldersName;
		this.cardNumber = cardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.postAddress = postAddress;
		this.postCode = postCode;
		this.validMonth = validMonth;
		this.validYear = validYear;
		this.verificationCode = verificationCode;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the postAddress
	 */
	public String getPostAddress() {
		return postAddress;
	}

	/**
	 * @param postAddress the postAddress to set
	 */
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cardHoldersName
	 */
	public String getCardHoldersName() {
		return cardHoldersName;
	}

	/**
	 * @param cardHoldersName the cardHoldersName to set
	 */
	public void setCardHoldersName(String cardHoldersName) {
		this.cardHoldersName = cardHoldersName;
	}

	/**
	 * @return the verificationCode
	 */
	public int getVerificationCode() {
		return verificationCode;
	}

	/**
	 * @param verificationCode the verificationCode to set
	 */
	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}

	/**
	 * @return the validYear
	 */
	public int getValidYear() {
		return validYear;
	}

	/**
	 * @param validYear the validYear to set
	 */
	public void setValidYear(int validYear) {
		this.validYear = validYear;
	}

	/**
	 * @return the validMonth
	 */
	public int getValidMonth() {
		return validMonth;
	}

	/**
	 * @param validMonth the validMonth to set
	 */
	public void setValidMonth(int validMonth) {
		this.validMonth = validMonth;
	}
	
	public CardType fromString(String string)
	{
		if (string.equalsIgnoreCase("VISA"))
		{
			return CardType.VISA;
		}
		else
		{
			return CardType.MasterCard;
		}
	}
}
