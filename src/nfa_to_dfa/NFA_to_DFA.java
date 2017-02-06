/*
 * This program changes an AFN to an AFD
 */
package nfa_to_dfa;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author DO
 */
public class NFA_to_DFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public static Automata Convert(Automata NFA) {
        
        // initialising the first stat of the DFA 
        Automata DFA;
        DFA = new Automata(NFA.getQ0());
        
        // initialising a temporary set of new states formed by subsets of states of Q
        PileStat Temp = null;
        Temp.empiler(NFA.getQ0());
        
        //loop
        while(!Temp.estVide())
        {
            Stat t = Temp.depiler();
            for(Symbole s:NFA.getE())
            {
                if(NFA.getT().checkTrans(t, s))
                {
                    Iterator<Symbole> it = NFA.getT().getTransitions(t, s).keySet().iterator();
                    Hashtable<Symbole, CoupleStat> n;
                    n = NFA.getT().getTransitions(t, s);
                    while(it.hasNext())
                    { 
                        Symbole key = it.next(); 
                        CoupleStat d = n.get(key); 
                        if(!DFA.getQ().contains(d.getEtat2()))
                        {
                            DFA.getQ().add(new Stat(d.getEtat2()));
                            Temp.empiler(new Stat(d.getEtat2()));
                            DFA.getT().createTrans(key, d);
                        }
                    }
                }
            }
        }
        
        
        return DFA;
        
    }
    
}
