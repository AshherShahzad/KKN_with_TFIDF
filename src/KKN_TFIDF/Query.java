/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KKN_TFIDF;

import java.util.Vector;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ashher Shahzad
 */
public class Query {
    filing f1 = new filing();
    double tfidf, tf, idf, sumTfidf=0.0, sumTf=0.0;
    String ansTfidf, ansTf, ansIdf;
    KKN_TFIDF form=new KKN_TFIDF(); 
    public  void query(String input){
         try{
            f1.filing();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try {
            String[] splitArray = input.split("\\s+");
            for (int i = 0; i < splitArray.length; i++) {
                double temp1 = sumTfidf(splitArray[i]);
                double temp2=  sumTf(splitArray[i]);
                ansTfidf = String.valueOf(temp1);
                ansTf = String.valueOf(temp2);
                
            }
        } catch (PatternSyntaxException ex) {
            ex.printStackTrace();
        }
        form.model = (DefaultTableModel) form.getTblTfidf().getModel();
        Object[] rowData =new Object[]{'1', ' ',ansTf,ansTfidf};
        
        form.model.addRow(rowData);
    }
    public  double sumTfidf(String input){
        Tfidf calculator = new Tfidf();
        tfidf = calculator.tfIdf(f1.edu1, f1.documents, input);
        sumTfidf += tfidf;
        return sumTfidf;
    }
    private double sumTf(String input){
        Tfidf calculator = new Tfidf();
        tf=calculator.tf(f1.edu1, input);
        sumTf += tf;
        return sumTf;
    }
    
}