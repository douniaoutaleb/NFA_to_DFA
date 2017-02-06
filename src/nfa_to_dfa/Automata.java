/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfa_to_dfa;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author DO
 */
public class Automata {
    private ArrayList<Stat> Q = new ArrayList<Stat>();
    private ArrayList<Symbole> E = new ArrayList<Symbole>();
    private ArrayList<Symbole> S = new ArrayList<Symbole>();
    private Transitions T;
    private Stat q0;
    private ArrayList<Stat> F = new ArrayList<Stat>();

    public Automata(Stat q0) {
        this.q0 = q0;
    }

    public ArrayList<Stat> getQ() {
        return Q;
    }

    public void setQ(ArrayList<Stat> Q) {
        this.Q = Q;
    }

    public ArrayList<Symbole> getE() {
        return E;
    }

    public void setE(ArrayList<Symbole> E) {
        this.E = E;
    }

    public ArrayList<Symbole> getS() {
        return S;
    }

    public void setS(ArrayList<Symbole> S) {
        this.S = S;
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

    public ArrayList<Stat> getF() {
        return F;
    }

    public void setF(ArrayList<Stat> F) {
        this.F = F;
    }
    
    public ArrayList<Stat> epsilonFermeture(Stat a)
    {
        ArrayList<Stat> t = this.T.getStatTrans(a, new Symbole("epsilon")); 
        t.add(a);
        return t;
    }
    
    public ArrayList<Stat> epsilonFermetureEns(ArrayList<Stat> a)
    {
        ArrayList<Stat> t = new ArrayList<Stat>();
        for(Stat o:a)
        {
            t.addAll(this.epsilonFermeture(o));
        } 
        return t;
    }
}
