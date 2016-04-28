/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package violencerates;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        System.out.println(data.toString());

        XYChart.Series< String, Number> Violence = new XYChart.Series();
        Datapoint[] point= data.getFact(); 
        for(Datapoint xyz : point){
            if(xyz.getDim().getWHOINCOMEREGION() != null){
                Violence.getData().add(new XYChart.Data(xyz.getDim().getWHOINCOMEREGION(), xyz.getValue()));     
        }
        }
        bar.getData().add(Violence);
    }    
    
}
