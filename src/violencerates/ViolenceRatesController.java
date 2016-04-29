/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package violencerates;

import com.google.gson.Gson;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 *
 * @author csstudent
 */
public class ViolenceRatesController implements Initializable {
    
    @FXML
    private Label label;
    
    private Dataset data;
    
    @FXML
    private BarChart<String, Integer> bar;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       System.out.println("Initializing");
       String s = "http://apps.who.int/gho/athena/data/GHO/RHR_IPV.json?profile=simple&filter=COUNTRY:-;WHOINCOMEREGION:*";
       URL myUrl = null;
        try {
            myUrl = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
     
        // read from the URL
        Scanner scan = null;
        try {
            scan = new Scanner(myUrl.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();

        Gson gson = new Gson();
        data = gson.fromJson(str, Dataset.class);
        //System.out.println(data.toString());

        XYChart.Series<String, Integer> Violence = new XYChart.Series();
        Datapoint[] point = data.getFact(); 
        System.out.println("Length: " + point.length);
        for(Datapoint xyz : point){
            //System.out.println("point");
            if(xyz.getDim().getWHOINCOMEREGION() != null){
                //System.out.println("Income region: " + xyz.getDim().getWHOINCOMEREGION());
                Integer val = Integer.parseInt(xyz.getValue().substring(0, 2).trim());
                System.out.println("Value: " + val);
                Violence.getData().add(new XYChart.Data(xyz.getDim().getWHOINCOMEREGION(), val));     
        }
        }
        bar.getData().add(Violence);
    }    
    
}
