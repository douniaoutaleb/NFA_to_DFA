/*
 * Automata.java
 */
package nfa_to_dfa;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author DO
 */
public class Automata {
    private ArrayList<Stat> Q = new ArrayList<Stat>();
    private ArrayList<Symbole> E = new ArrayList<Symbole>();
    private Transitions T = new Transitions();
    private Stat q0;
    private ArrayList<Stat> F = new ArrayList<Stat>();

    public void AfficheAuto(){
        System.out.println("Automata: qo="+q0.toString());
        System.out.print("Q=");
        for(Stat a:Q){System.out.print("{"+a.toString()+"} ");} 
        System.out.println();
        System.out.print("E= | ");
        for(Symbole a:E){System.out.print(a.toString()+" | ");} 
        System.out.println();
        System.out.print("F=");
        for(Stat a:F){System.out.println("{"+a.toString()+"} ");} 
        this.T.AfficheTrans();
    }
    
    public String toString(){
        String t = "Automata: qo="+q0.toString();
        t += "\n Q=";
        for(Stat a:Q){ t+= "{"+a.toString()+"} ";} 
        t += "\n E= | ";
        for(Symbole a:E){t += a.toString()+" | ";} 
        t += "\n F=";
        for(Stat a:F){t += "{"+a.toString()+"} ";} 
        t += this.T.toString();
        return t;
    }

    public Automata(Stat q0) {
        this.q0 = q0;
    }

    public ArrayList<Stat> getQ() {
        return Q;
    }

    public void setQ(ArrayList<Stat> Q) {
        this.Q = Q;
        this.Q.add(q0);
    }

    public ArrayList<Symbole> getE() {
        return E;
    }

    public void setE(ArrayList<Symbole> E) {
        this.E = E;
    }

    public Transitions getT() {
        return T;
    }

    public void setT(Transitions T) {
        this.T = T;
    }


    public Stat getQ0() {
        return q0;
    }

    public void setQ0(Stat q0) {
        this.q0 = q0;
    }
    
    public boolean Qcontient(Stat q)
    {
        boolean t = false;int i = 0;
        while(!t && i<Q.size())
        {
            if(Q.get(i).equals(q))
            {
                t = true;
            }
            else
            {
                i++;
            }
        }
        return t;
    }

    public ArrayList<Stat> getF() {
        return F;
    }

    public void setF(ArrayList<Stat> F) {
        this.F = F;
    }

    
    /**
     * This Method converts an NFA containing epsilon transitions
     * into a DFA
     */
    public Automata Convertepsilon() {
            
        // initialising the first stat of the DFA 
        Automata DFA;
        DFA = new Automata(this.q0);
        DFA.Q.add(this.q0);
        
        // initialising a temporary set of new states formed by subsets of states of Q
        PileStat Temp = new PileStat();
        Temp.empiler(this.q0);
        
        //loop
        while(!Temp.estVide())
        {
            Stat t = Temp.depiler();
            for(Symbole s:this.E)
            {
                if(t!= null && this.T.checkTrans(t, s))
                {
                    /**
                     * getting the transitions formed by t and s
                     */
                    // i need to get epsilon fermeture of those trans
                    Stat e = this.T.epsilonFermetureEns(this.T.getStatTrans1(t, s));
                    
                    /**
                     * checking if our DFA contains already the stat
                     * produced by t and s
                     */
                    if(!DFA.Qcontient(e))
                    {
                        /**
                         * in case it doesn't contain the stat 
                         * we add that stat to the DFA stat table
                         * and to the temporary table
                         * (we use getEtat2 because getEtat1 reffers to t) 
                         */
                        DFA.Q.add(e);
                        Temp.empiler(e);
                        /**
                         * and we create transition formed by t and Etat2
                         * in the DFA
                         */
                    }
                    if(!DFA.T.checkTrans1(t, s))
                    {
                        DFA.T.createTrans(s, new CoupleStat(t,e));
                        if(!DFA.E.contains(s) && !s.equals(new Symbole("epsilon")))
                        {
                            DFA.E.add(s);
                        }
                    }
                    
                }
            }
        }
        
        // filling the table of final stats of the DFA
        for(Stat o:DFA.Q)
        {
            int i = 0;
            while(i<this.F.size())
            {
                if(o.getValeur().contains(this.F.get(i).toString()))
                {
                    DFA.F.add(o);
                    i++;
                }
                else
                {
                    i++;
                }
            }
        }
        
        return DFA;
        
    }
 
}
