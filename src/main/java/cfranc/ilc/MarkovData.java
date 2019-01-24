package cfranc.ilc;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class MarkovData {
    String theWord;
    int theCount;

    public MarkovData(String w, int c)
    {
        theWord = w;
        theCount = c;
    }

    public void setTheCount(int c)
    {
        theCount = c;
    }

    public String getTheWord()
    {
        return theWord;
    }

    public int getTheCount()
    {
        return theCount;
    }
    
    //Renvoie true si les deux objets sont egaux
    public boolean equals(Object o){
        boolean objetSontEgaux = true;
        MarkovData mar1 = (MarkovData)(o);
        
        if(mar1.getTheCount() != this.getTheCount()){
            objetSontEgaux = false;
        }
        else if(!mar1.getTheWord().equals(this.getTheWord())){
            objetSontEgaux = false;
        }
        
        return objetSontEgaux;
    }

}