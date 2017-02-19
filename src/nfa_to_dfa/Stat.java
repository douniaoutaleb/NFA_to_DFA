/*
 * Stat.java
 */
package nfa_to_dfa;

import java.util.ArrayList;

/**
 *
 * @author DO
 */
public class Stat {
    private ArrayList<String> valeur;

    

    public Stat() {
        this.valeur = new ArrayList<String>();
    }
    
    public Stat(String valeur) {
        this.valeur = new ArrayList<String>();
        this.valeur.add(valeur);
    }

    @Override
    public String toString() {
        String a = "";
        for(int i = 0;i<this.valeur.size()-1;i++)
        {
            a+=this.valeur.get(i)+",";
        }
        a+=this.valeur.get(this.valeur.size()-1)+"";
        return a;
    }

    public ArrayList<String> getValeur() {
        return valeur;
    }

    public void setValeur(ArrayList<String> valeur) {
        this.valeur = valeur;
    }

    public boolean equals(Stat obj) {
        if(obj==null)
        {
            return false;
        }
        else
        {
            if(obj.valeur.size()== this.valeur.size())
            {
                boolean t = true; int i = 0;
                while(t && i<this.valeur.size() )
                {
                    if(!this.valeur.get(i).equals(obj.valeur.get(i)))
                    {
                        t = false;
                    }
                    else
                    {
                        i++;
                    }
                }
                return t;
            }
            else
            {
                return false;
            }
        }
        
    }
    
    public void ajout(String a)
    {
        this.valeur.add(a);
    }
    
}
