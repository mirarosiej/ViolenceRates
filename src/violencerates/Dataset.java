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
public class Dataset {
    private Legend[] dimension;
    private Datapoint[] fact;
    
    public Dataset(){
        
    }
    
    public Datapoint[] getFact(){
       return fact;
   }
    
    public Datapoint[] getWHOINCOMEREGION(){
        return fact;
    }
    
    public String toString(){
        String s = "";
        for(Datapoint d : fact){
            s += d.toString() + "\n";
        }
        
        return s; 
    }
}
