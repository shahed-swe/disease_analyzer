/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disease_analyzer;

/**
 *
 * @author User
 */
public class Hospitalproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Screen obj = new Screen(); //making an object of screen class
        Self_Describe obj2 = new Self_Describe(); //making an object of login class
        obj.setVisible(true); //screen class form visible
        try{
            
            for(int i = 0;i <= 100;i++){
                Thread.sleep(25);
                obj.jlab.setText(Integer.toString(i)+"%");
                obj.jbar.setValue(i);
                if(i == 100){
                    obj.setVisible(false); //screen class form not visible
                    obj2.setVisible(true); //hospital_login class form visible
                }
            }
        }catch(InterruptedException ex){
            System.out.println("Nothing Happend");
        }
    }
    
}
