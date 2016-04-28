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
public class Information {
    private int Year;
    private String Sex;
    private String GBDRegion;
    private int AgeGroup;
    private String WHOINCOMEREGION;
    private String GHO;
    private String PublishState;
    
   public Information(){
        
   }

   public String getPublishState(){
        return PublishState;        
   }    
    public String getGBDRegion(){
        return GBDRegion;        
   }
    public String getGho(){
        return GHO;        
   }
    public String getSex(){
        return Sex;        
   }
    public int getYear(){
        return Year;        
   }
    public int getAgeGroup(){
        return AgeGroup;        
   }
    public String getWHOINCOMEREGION(){
        return WHOINCOMEREGION;        
   }
    
    public String toString(){
        String s = "";
        if(WHOINCOMEREGION != null){
            s = this.getWHOINCOMEREGION();
        }else{
            s = "Income Region not found";
        }
        return s;
   }
}
