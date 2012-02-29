package imat.program;

import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 * Handles the categories in the iMat app. This is a singleton,
 * use the getInstance() method to get the instance of this class.
 * @author Plankton555
 * @version (2012-02-26)
 */
public class CategoryHandler {

	
	private static CategoryHandler instance;
	
	private CategoryHandler()
	{
	}

	public static CategoryHandler getInstance()
	{
		if (instance == null)
		{
			instance = new CategoryHandler();
		}
		return instance;
	}
	
	public static Category stringToCategory(String categoryName)
	{
		if (categoryName.equalsIgnoreCase("Favoriter"))
		{
			return Category.FAVORITES;
		}
		else if (categoryName.equalsIgnoreCase("Bröd"))
		{
			return Category.BREAD;
		}
		else if (categoryName.equalsIgnoreCase("Fika"))
		{
			return Category.FIKA;
		}
		else if (categoryName.equalsIgnoreCase("Snacks"))
		{
			return Category.SNACKS;
		}
		else if (categoryName.equalsIgnoreCase("Bär"))
		{
			return Category.BERRIES;
		}
		else if (categoryName.equalsIgnoreCase("Citrusfrukter"))
		{
			return Category.CITRUS;
		}
		else if (categoryName.equalsIgnoreCase("Kål"))
		{
			return Category.CABBAGE;
		}
		else if (categoryName.equalsIgnoreCase("Meloner"))
		{
			return Category.MELONS;
		}
		else if (categoryName.equalsIgnoreCase("Nötter och frön"))
		{
			return Category.NUTS_N_SEEDS;
		}
		else if (categoryName.equalsIgnoreCase("Rotfrukter"))
		{
			return Category.ROOT_VEG;
		}
		else if (categoryName.equalsIgnoreCase("Stenfrukter"))
		{
			return Category.STONE_FRUIT;
		}
		else if (categoryName.equalsIgnoreCase("Ärtor och baljväxter"))
		{
			return Category.PEAS_N_PODS;
		}
		else if (categoryName.equalsIgnoreCase("Örter"))
		{
			return Category.HERBS;
		}
		else if (categoryName.equalsIgnoreCase("Övriga frukter"))
		{
			return Category.OTHER_FRUITS;
		}
		else if (categoryName.equalsIgnoreCase("Övriga grönsaker"))
		{
			return Category.OTHER_VEGS;
		}
		else if (categoryName.equalsIgnoreCase("Fruktdrycker"))
		{
			return Category.LEMONADES;
		}
		else if (categoryName.equalsIgnoreCase("Läskeblask"))
		{
			return Category.SODAS;
		}
		else if (categoryName.equalsIgnoreCase("Fisk"))
		{
			return Category.FISH;
		}
		else if (categoryName.equalsIgnoreCase("Kyckling"))
		{
			return Category.CHICKEN;
		}
		else if (categoryName.equalsIgnoreCase("Nötkött"))
		{
			return Category.BEEF;
		}
		else if (categoryName.equalsIgnoreCase("Mejerivaror"))
		{
			return Category.DAIRY_PRODUCTS;
		}
		else if (categoryName.equalsIgnoreCase("Bakning"))
		{
			return Category.BAKING;
		}
		else if (categoryName.equalsIgnoreCase("Drycker"))
		{
			return Category.DRINKS;
		}
		else if (categoryName.equalsIgnoreCase("Pasta"))
		{
			return Category.PASTA;
		}
		else if (categoryName.equalsIgnoreCase("Ris"))
		{
			return Category.RICE;
		}
		else if (categoryName.equalsIgnoreCase("Övriga torrvaror"))
		{
			return Category.OTHER_DRY;
		}
		else if (categoryName.equalsIgnoreCase("Fika och snacks"))
		{
			return Category.FIKA_N_SNACKS;
		}
		else if (categoryName.equalsIgnoreCase("Frukt och grönt"))
		{
			return Category.FRUIT_N_VEG;
		}
		else if (categoryName.equalsIgnoreCase("Kalla drycker"))
		{
			return Category.COLD_DRINKS;
		}
		else if (categoryName.equalsIgnoreCase("Kött och fisk"))
		{
			return Category.MEAT_N_FISH;
		}
		else if (categoryName.equalsIgnoreCase("Torrvaror"))
		{
			return Category.DRY_PRODUCTS;
		}
		else
		{
			return Category.FAVORITES;
		}
	}
	
	public String categoryToString(Category category)
	{
		String name = "";
		switch (category) {
		case FAVORITES:
			name = "Favoriter";
			break;
		
		case BREAD:
			name = "Br�d";
			break;
			
		case FIKA:
			name = "Fika";
			break;
			
		case SNACKS:
			name = "Snacks";
			break;
			
		case BERRIES:
			name = "B�r";
			break;
			
		case CITRUS:
			name = "Citrusfrukter";
			break;
			
		case CABBAGE:
			name = "K�l";
			break;
			
		case MELONS:
			name = "Meloner";
			break;
			
		case NUTS_N_SEEDS:
			name = "N�tter och fr�n";
			break;
			
		case ROOT_VEG:
			name = "Rotfrukter";
			break;
			
		case STONE_FRUIT:
			name = "Stenfrukter";
			break;
			
		case PEAS_N_PODS:
			name = "�rtor och baljv�xter";
			break;
			
		case HERBS:
			name = "�rter";
			break;
			
		case OTHER_FRUITS:
			name = "�vriga frukter";
			break;
			
		case OTHER_VEGS:
			name = "�vriga gr�nsaker";
			break;
			
		case LEMONADES:
			name = "Fruktdrycker";
			break;
			
		case SODAS:
			name = "L�skeblask";
			break;
			
		case FISH:
			name = "Fisk";
			break;
			
		case CHICKEN:
			name = "Kyckling";
			break;
			
		case BEEF:
			name = "N�tk�tt";
			break;
			
		case DAIRY_PRODUCTS:
			name = "Mejerivaror";
			break;
			
		case BAKING:
			name = "Bakning";
			break;
			
		case DRINKS:
			name = "Drycker";
			break;
			
		case PASTA:
			name = "Pasta";
			break;
			
		case RICE:
			name = "Ris";
			break;
			
		case OTHER_DRY:
			name = "�vriga torrvaror";
			break;
			
		case FIKA_N_SNACKS:
			name = "Fika och snacks";
			break;
			
		case FRUIT_N_VEG:
			name = "Frukt och gr�nt";
			break;
			
		case COLD_DRINKS:
			name = "Kalla drycker";
			break;
			
		case MEAT_N_FISH:
			name = "K�tt och fisk";
			break;
			
		case DRY_PRODUCTS:
			name = "Torrvaror";
			break;

		default:
			break;
		}
		return name;
	}
	
	public List<Product> getProducts(Category category)
	{
		List<Product> outputList = new ArrayList<Product>();
		IMatDataHandler database = IMatDataHandler.getInstance();
		
		if (category == Category.FAVORITES)
		{
			return database.favorites();
		}
		int[] numbers = productNumbers(category);
		for (int i=0; i<numbers.length; i++)
		{
			outputList.add(database.getProduct(numbers[i]));
		}
		return outputList;
	}
	
	private int[] productNumbers(Category category)
	{
		int[] output = new int[0];
		switch (category) {
		case BREAD:
			output = new int[] {8,9,10,11,12,13,14};
			break;
			
		case FIKA:
			output = new int[] {137,138,139};
			break;
			
		case SNACKS:
			output = new int[] {134,135,136,140};
			break;
			
		case BERRIES:
			output = new int[] {15,16,17,18,19,20,21,130};
			break;
			
		case CITRUS:
			output = new int[] {22,23,24,25,26};
			break;
			
		case CABBAGE:
			output = new int[] {63,64,65,66,67,68,69,70};
			break;
			
		case MELONS:
			output = new int[] {86,87,88,89,90};
			break;
			
		case NUTS_N_SEEDS:
			output = new int[] {97,98,99,101,102,103,104,105};
			break;
			
		case ROOT_VEG:
			output = new int[] {116,117,118,121,122,123,124,125,126,127};
			break;
			
		case STONE_FRUIT:
			output = new int[] {58,129,131,132,133};
			break;
			
		case PEAS_N_PODS:
			output = new int[] {1,2,3,4,5,6,7};
			break;
			
		case HERBS:
			output = new int[] {141,142,143,144,145,146,147,148};
			break;
			
		case OTHER_FRUITS:
			output = new int[] {41,42,43,44,45,46,47,56,59,60,61,100};
			break;
			
		case OTHER_VEGS:
			output = new int[] {55,57,62,128};
			break;
			
		case LEMONADES:
			output = new int[] {32,37};
			break;
			
		case SODAS:
			output = new int[] {33,34,35,36,38,39,40};
			break;
			
		case FISH:
			output = new int[] {48,49,50,51,52,53,54};
			break;
			
		case CHICKEN:
			output = new int[] {73,74,75};
			break;
			
		case BEEF:
			output = new int[] {71,72,76};
			break;
			
		case DAIRY_PRODUCTS:
			output = new int[] {77,78,79,80,81,82,83,84,85};
			break;
			
		case BAKING:
			output = new int[] {91,92,93,94,95,96};
			break;
			
		case DRINKS:
			output = new int[] {27,28,29,30,31};
			break;
			
		case PASTA:
			output = new int[] {106,107,108,109,110,111,112};
			break;
			
		case RICE:
			output = new int[] {113,114,115,120};
			break;
			
		case OTHER_DRY:
			output = new int[] {119};
			break;
			
		case FIKA_N_SNACKS:
			output = IMatUtil.arrayMerge(
					productNumbers(Category.FIKA),
					productNumbers(Category.SNACKS));
			break;
			
		case FRUIT_N_VEG:
			output = IMatUtil.arrayMerge(
					productNumbers(Category.BERRIES),
					productNumbers(Category.CITRUS),
					productNumbers(Category.CABBAGE),
					productNumbers(Category.MELONS),
					productNumbers(Category.NUTS_N_SEEDS),
					productNumbers(Category.ROOT_VEG),
					productNumbers(Category.STONE_FRUIT),
					productNumbers(Category.PEAS_N_PODS),
					productNumbers(Category.HERBS),
					productNumbers(Category.OTHER_FRUITS),
					productNumbers(Category.OTHER_VEGS));
			break;
			
		case COLD_DRINKS:
			output = IMatUtil.arrayMerge(
					productNumbers(Category.LEMONADES),
					productNumbers(Category.SODAS));
			break;
			
		case MEAT_N_FISH:
			output = IMatUtil.arrayMerge(
					productNumbers(Category.FISH),
					productNumbers(Category.CHICKEN),
					productNumbers(Category.BEEF));
			break;
			
		case DRY_PRODUCTS:
			output = IMatUtil.arrayMerge(
					productNumbers(Category.BAKING),
					productNumbers(Category.DRINKS),
					productNumbers(Category.PASTA),
					productNumbers(Category.RICE),
					productNumbers(Category.OTHER_DRY));
			break;

		default:
			break;
		}
                
                // TODO Sortera i bokstavsordning
		return output;
	}
}
