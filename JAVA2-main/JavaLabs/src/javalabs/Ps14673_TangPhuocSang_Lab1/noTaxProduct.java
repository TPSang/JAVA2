/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabs.Lab1;

/**
 *
 * @author Admin
 */
public class noTaxProduct extends Product {
    
    @Override
    public double getImportTax(){
        return 0;
    }
}
