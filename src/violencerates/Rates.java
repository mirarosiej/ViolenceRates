/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package violencerates;

/**
 *
 * @author csstudent
 */
public class Rates {
    private int zip;
    private String results;
    
    public Rates(){
        
    }
    
    public int getZip() {
        return zip;
    }
    
    public boolean failed() {
        if (results.equals("Fail")) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "" + zip + " " + results;
    }
}
