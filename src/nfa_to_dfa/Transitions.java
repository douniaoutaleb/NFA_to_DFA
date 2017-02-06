/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    private Hashtable<Symbole, CoupleStat> Table = new Hashtable<Symbole, CoupleStat>();

    public boolean checkTrans( Stat a, Symbole c)
    {
        Iterator<Symbole> it = Table.keySet().iterator();
        boolean t = false;
	while(it.hasNext())
	{ 
            Symbole key = it.next(); 
            CoupleStat d = Table.get(key); 
            if(key.equals(c) && d.getEtat1().equals(a.getValeur()) && t == false)
            {
                t = true;
            }
	}
        return t==true;
    }
    
    public void createTrans(Symbole c, CoupleStat a)
    {
        Table.put(c, a);
    }
    
    public Hashtable<Symbole, CoupleStat> getTransitions( Stat a, Symbole c)
    {
        Hashtable<Symbole, CoupleStat> t = new Hashtable<Symbole, CoupleStat>();
        Iterator<Symbole> it = Table.keySet().iterator();
	while(it.hasNext())
	{ 
            Symbole key = it.next(); 
            CoupleStat d = Table.get(key); 
            if(key.equals(c) && d.getEtat1().equals(a.getValeur()))
            {
                t.put(key, d);
            }
	}
        return t;
    }
    
    public ArrayList<Stat> getStatTrans( Stat a, Symbole c)
    {
        ArrayList<Stat> t = new ArrayList<Stat>();
        Iterator<Symbole> it = Table.keySet().iterator();
	while(it.hasNext())
	{ 
            Symbole key = it.next(); 
            CoupleStat d = Table.get(key); 
            if(key.equals(c) && d.getEtat1().equals(a.getValeur()))
            {
                t.add(new Stat(d.getEtat2()));
            }
	}
        return t;
    }
    
    public ArrayList<Stat> getEnsTrans( ArrayList<Stat> a, Symbole c)
    {
        ArrayList<Stat> t = new ArrayList<Stat>();
        for(Stat o:a)
        {
            Iterator<Symbole> it = Table.keySet().iterator();
            while(it.hasNext())
            { 
                Symbole key = it.next(); 
                CoupleStat d = Table.get(key); 
                if(key.equals(c) && d.getEtat1().equals(o.getValeur()) && !t.contains(new Stat(d.getEtat2())))
                {
                    t.add(new Stat(d.getEtat2()));
                }
            }
        }
        return t;
    }
    
    
    
}
