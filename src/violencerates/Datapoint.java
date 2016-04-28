/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package violencerates;


public class Datapoint {
    private Information dim; 
    private String Value;

    /**
     * Constructor for objects of class Datapoint
     */
    public Datapoint(){
        
    }
    public Information getDim(){
        return dim;
        
    }    
    public String getValue(){
        return Value;
        
    }
    public String toString(){
        String s = dim.toString();
        String i = s + ": " + Value + "% violence among ever partnered women";
        return i;
    }
}
