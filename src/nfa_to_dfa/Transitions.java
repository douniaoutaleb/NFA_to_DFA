/*
 * Transitions.java
 */
package nfa_to_dfa;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author DO
 */
public class Transitions {

    private Hashtable<Symbole, CoupleStat> Table ;
    
    public Transitions() {
        Table =  new Hashtable<Symbole, CoupleStat>();
    }

    public Transitions(Hashtable<Symbole, CoupleStat> t) {
        this.Table = t;
    }

    /**
     * the following method creates a transition based on the entered parameters
     * @param c
     * @param a 
     */
    public void createTrans(Symbole c, CoupleStat a)
    {
        if(Table.containsKey(c))
        {
            Table.put(new Symbole(c.getValeur()+" "), a);
        }
        else
        {
            Table.put(c, a);
        }
    }
    
    /**
     * the following method prints the Transitions sets
     */
    public void AfficheTrans (){
        System.out.println("T=");
        Iterator<Symbole> it = Table.keySet().iterator();
	while(it.hasNext())
	{ 
		Symbole key = it.next(); 
		CoupleStat c = Table.get(key); 
		System.out.println("({" + c.getEtat1()+ "}," + key + ",{" +c.getEtat2() +"})"); 
	} 
    }
	 
     public String toString (){
        String a = "T=";
        Iterator<Symbole> it = Table.keySet().iterator();
	while(it.hasNext())
	{ 
		Symbole key = it.next(); 
		CoupleStat c = Table.get(key); 
		a += "({" + c.getEtat1()+ "}," + key + ",{" +c.getEtat2() +"})\n"; 
	} 
        return a ; 
    }
    
    /**
     * Method that tells if a transition(a,c) is present in the automata
     * @param a
     * @param c
     * @return 
     */
    public boolean checkTrans1(Stat a, Symbole c)
    {
        Iterator<Symbole> it = Table.keySet().iterator();
        boolean t = false;
	while(it.hasNext())
	{ 
            Symbole key = it.next(); 
            CoupleStat d = Table.get(key); 
            if(key.equals(c) && d.getEtat1().equals(a) && t == false)
            {
                t = true;
            }
	}
        return t==true;
    }

    /**
     * the following method tells if a transition(a,c) or transitions of one or more
     * elements of "a" with "c" is present in the automata
     * @param a
     * @param c
     * @return 
     */
    public boolean checkTrans(Stat a, Symbole c)
    {
        Iterator<Symbole> it = Table.keySet().iterator();
        boolean t = false;
	while(it.hasNext())
	{ 
            Symbole key = it.next(); 
            CoupleStat d = Table.get(key); 
            for(String o:a.getValeur())
                for(String u:d.getEtat1().getValeur())
                {
                    if(key.equals(c) && o.equals(u))
                    {
                        t = true;
                    }
                }
	}
        return t==true;
    }
    
    
    
    
    /**
     * getStatTrans(a,c) returns a stat which contains a combination of 
     * the second stats of the tansitions that are formed by 'a' and 'c'
     * @param a
     * @param c
     * @return 
     */
    public Stat getStatTrans1( Stat a, Symbole c)
    {
        Stat t = new Stat();
        Iterator<Symbole> it = Table.keySet().iterator();
	while(it.hasNext())
	{ 
            Symbole key = it.next(); 
            CoupleStat d = Table.get(key); 
            for(String r:a.getValeur())
            {
                String[] parts = r.split(",");
                for(String o:parts)
                    for(String u:d.getEtat1().getValeur())
                    {
                        if(key.equals(c) && o.equals(u))
                        {
                            t.ajout(d.getEtat2().toString());
                        }
                    }
            }
            
	}
        return t;
    }
    
    
     /**
     * epsilonFermeture(a) is a method that returns a stat that contains 
     * 'a' plus the stats of the NFA accessible only by 
     * epsilon transitions from the stat 'a'
     * @param a
     * @return 
     */
    public Stat epsilonFermeture(Stat a)
    {
        Stat t = this.getStatTrans1(a, new Symbole("epsilon")); 
        boolean b = false;
        for(String o:t.getValeur())
        {
            if(o.equals(a.toString()))
            {
                b = true;
            }
        }
        if(!b)
        {
            for(String u:a.getValeur())
            {
                t.ajout(u);
            }
        }
        return t;
    }
    
    /**
     * epsilonFermetureEns(a) is a method that returns an array 
     * which contains the union of epsilonFermeture(each_stat_of_a)
     * @param a
     * @return 
     */
    public Stat epsilonFermetureEns(Stat a)
    {
        Stat t = new Stat();
        for(String o:a.getValeur())
        {
            t.ajout(this.epsilonFermeture(new Stat(o)).toString());
        } 
        return t;
    }
    
}
