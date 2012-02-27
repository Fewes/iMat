package imat.program;



/**
 * Class containing utility methods
 * @author Found on internet, modified by Plankton555
 *
 */
public class IMatUtil {

	public static int[] arrayMerge(int[]... arrays)
	{
	    // Determine required size of new array

	    int count = 0;
	    for (int[] array : arrays)
	    {
	        count += array.length;
	    }

	    // create new array of required class

	    int[] mergedArray = new int[count];

	    // Merge each array into new array

	    int start = 0;
	    for (int[] array : arrays)
	    {
	        System.arraycopy(array, 0, mergedArray, start, array.length);
	        start += array.length;
	    }
	    return mergedArray;
	} 
}
