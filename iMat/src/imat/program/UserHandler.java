package imat.program;

import imat.IMatView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the users.
 * @author Plankton555
 * @version (2012-02-29)
 */
public class UserHandler {

	private static UserHandler instance;
	
	private List<IMatUser> users;
	private IMatUser loggedInUser = null;
	
	private UserHandler()
	{
		users = loadFromFile();
	}
	
	public static UserHandler getInstance()
	{
		if (instance == null)
		{
			instance = new UserHandler();
		}
		return instance;
	}
	
	private List<IMatUser> loadFromFile() {

		// Check if user loading is working. After check: working.
		String folderPath = System.getProperty("user.home") + "\\.dat215\\imat\\";
		String fileName = "iMatUsers.txt";
		File file = new File(folderPath + fileName);
		String input = "";
		List<IMatUser> result = new ArrayList<IMatUser>();
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
			{
				input = input + scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			return result;
		}
		String[] usersText = input.split(";endl;");
                if( usersText.length > 0 && !usersText[0].equalsIgnoreCase("") )  //TODO: Fullösning men funkar tills vidare.
                {
                    for (int i=0; i<usersText.length; i++)
                    {
                            String[] u = usersText[i].split(";");
                            IMatUser user = new IMatUser(u[0], u[1], u[2], u[3]);
                            
                            PaymentInfo payInfo = new PaymentInfo();   
                            payInfo.setCardType(payInfo.fromString(u[4]));
                            payInfo.setFirstName(u[5]);
                            payInfo.setLastName(u[6]);
                            payInfo.setPostAddress(u[7]);
                            payInfo.setPostCode(u[8]);
                            payInfo.setPhoneNumber(u[9]);
                            payInfo.setCardNumber(u[10]);
                            payInfo.setCardHoldersName(u[11]);
                            //payInfo.setVerificationCode(Integer.parseInt(u[12])); // no saving of verification code
                            payInfo.setValidYear(Integer.parseInt(u[12]));
                            payInfo.setValidMonth(Integer.parseInt(u[13]));

                            user.setPaymentInfo(payInfo);
                            
                            result.add(user);
                    }
                }
		return result;
	}
	
	private void saveToFile()
	{
		// Check if user save is working. After check: working
		String folderPath = System.getProperty("user.home") + "\\.dat215\\imat\\";
		String fileName = "iMatUsers.txt";
		
		String dataString = "";
		for (IMatUser user : users)
		{
			PaymentInfo payInfo = user.getPaymentInfo();
			dataString = dataString
					+ user.getFirstName() + ';'
					+ user.getLastName() + ';'
					+ user.getUsername() + ';'
					+ user.getPassword() + ';'
					+ payInfo.getCardType().toString() + ';'
					+ payInfo.getFirstName() + ';'
					+ payInfo.getLastName() + ';'
					+ payInfo.getPostAddress() + ';'
					+ payInfo.getPostCode() + ';'
					+ payInfo.getPhoneNumber() + ';'
					+ payInfo.getCardNumber() + ';'
					+ payInfo.getCardHoldersName() + ';'
					+ payInfo.getValidYear() + ';'
					+ payInfo.getValidMonth() + ";endl;";
		}
		
		// Creates the folder if necessary
		File folder = new File(folderPath);
		if (!folder.exists())
		{
			folder.mkdirs();
		}
		
		File file = new File(folderPath + fileName);
		try {
			Writer out = new BufferedWriter(new FileWriter(file));
			out.write(dataString);
			out.close();
		} catch (IOException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login(String username, String password)
	{
		for (IMatUser user : users)
		{
			if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
			{
				loggedInUser = user;
                                System.out.println("User " + username + " logged in successfully!");
                                // TODO Userhandler should not set the button text unless absolutely necessary...
                                IMatView.getView().getLoginBtn().setText("Historik");
				return true; // login has succeeded
			}
		}
                System.out.println("Incorrect username or password.");
		return false; // no such user found
	}
	
	public boolean registerUser(String firstName, String lastName, String username,
			String password) {
		for (IMatUser user : users)
		{
			if (username.equals(user.getUsername()))
			{
                            System.out.println("User " + username + " is already registered");
                            return false; // The user is already registered
			}
		}
		IMatUser user = new IMatUser(firstName, lastName, username, password);
		users.add(user);
		//loggedInUser = user;
                System.out.println("User " + username + " created.");
                login(username, password);
		return true;
	}
	
	public void shutDown()
	{
		saveToFile();
	}

	/**
	 * @return the loggedInUser
	 */
	public IMatUser getLoggedInUser() {
		return loggedInUser;
	}
}