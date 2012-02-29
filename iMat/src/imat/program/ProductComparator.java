/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.program;

import java.util.Comparator;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Plankton555
 */
public class ProductComparator implements Comparator<Product> {

    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
