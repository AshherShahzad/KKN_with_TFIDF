package KKN_TFIDF;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ashher Shahzad
 */
public class filing {
    
    List<List<String>> documents;
    ArrayList<String> edu1, edu2, edu3, edu4, edu5;
    List<String> lEdu1, lEdu2, lEdu3, lEdu4, lEdu5;
    double tfidf, tf, idf, sumTfidf=0.0, sumTf=0.0;
    String ansTfidf, ansTf, ansIdf;
    FileReader rEdu1, rEdu2, rEdu3, rEdu4, rEdu5;
    String stEdu1, stEdu2, stEdu3, stEdu4, stEdu5;
    String []arrStEdu1, arrStEdu2, arrStEdu3, arrStEdu4, arrStEdu5;
    DefaultTableModel model;

    Scanner s1;
    ArrayList<String> doc;
    String input;
    Iterator<String> iterator;
    
    public void filing() throws Exception{
        rEdu1 = new FileReader("Files/Education/Blog Post of the Day.html"); 
        edu1 = new ArrayList<String>();
        lEdu1 = new ArrayList<String>();
        lEdu1 = (ArrayList<String>) NoHtml.extractText(rEdu1);
        stEdu1 = lEdu1.toString();
        arrStEdu1 = stEdu1.split(" ");
        Collections.addAll(edu1, arrStEdu1);
        
        rEdu2 = new FileReader("Files/Education/Chalkbeat_ Education News for America.html"); 
        edu2 = new ArrayList<String>();
        lEdu2 = new ArrayList<String>();
        lEdu2 = (ArrayList<String>) NoHtml.extractText(rEdu2);
        stEdu2 = lEdu2.toString();
        arrStEdu2 = stEdu2.split(" ");
        Collections.addAll(edu2, arrStEdu2);
        
        rEdu3 = new FileReader("Files/Education/Home _ Edutopia.html"); 
        edu3 = new ArrayList<String>();
        lEdu3 = new ArrayList<String>();
        lEdu3 = (ArrayList<String>) NoHtml.extractText(rEdu3);
        stEdu3 = lEdu3.toString();
        arrStEdu3 = stEdu3.split(" ");
        Collections.addAll(edu3, arrStEdu3);
        
        rEdu4 = new FileReader("Files/Education/Literacy educator, Literacy Professor, Literacy and Reading Blog, Reading Instruction _ Shanahan on Literacy.html"); 
        edu4 = new ArrayList<String>();
        lEdu4 = new ArrayList<String>();
        lEdu4 = (ArrayList<String>) NoHtml.extractText(rEdu4);
        stEdu4 = lEdu4.toString();
        arrStEdu4 = stEdu4.split(" ");
        Collections.addAll(edu4, arrStEdu4);
        
        rEdu5 = new FileReader("Files/Education/Mindshift _ KQED News _ KQED Public Media for Northern CA.html"); 
        edu5 = new ArrayList<String>();
        lEdu5 = new ArrayList<String>();
        lEdu5 = (ArrayList<String>) NoHtml.extractText(rEdu5);
        stEdu5 = lEdu5.toString();
        arrStEdu5 = stEdu5.split(" ");
        Collections.addAll(edu5, arrStEdu5);
        
        documents = Arrays.asList(edu1, edu2, edu3, edu4, edu5);
    }
    public  double sumTfidf(String input){
        Tfidf calculator = new Tfidf();
        tfidf = calculator.tfIdf(edu1, documents, input);
        sumTfidf += tfidf;
        return sumTfidf;
    }
    private double sumTf(String input){
        Tfidf calculator = new Tfidf();
        tf=calculator.tf(edu1, input);
        sumTf += tf;
        return sumTf;
    }

public void query(){
        String query = txtQuery.getText();
        s1 = new Scanner(query);
        doc = new ArrayList<String>();
        while (s1.hasNext())
            doc.add(s1.next());
        s1.close();
        try{
            filing();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < doc.size(); i++) {
            input = doc.get(i);
            Tfidf calculator = new Tfidf();
            tfidf = calculator.tfIdf(edu1, documents, input);
            tf=calculator.tf(edu1, input);
            idf=calculator.idf(documents, input);
            sumTfidf += tfidf;
            sumTf += tf;
            
        }
            ansTfidf = String.valueOf(sumTfidf);
            ansTf = String.valueOf(sumTf);
            ansIdf = String.valueOf(idf);
            model = (DefaultTableModel) tblKknTfidf.getModel();
            model.addRow(new Object[]{query,"1",ansTf,ansTfidf});

}
}
