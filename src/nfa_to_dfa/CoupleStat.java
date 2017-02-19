/*
 * CouleStat.java
 */
package nfa_to_dfa;

/**
 *
 * @author DO
 */
public class CoupleStat {
    private Stat etat1;
    private Stat etat2;

    public CoupleStat(Stat etat1, Stat etat2) {
        this.etat1 = etat1;
        this.etat2 = etat2;
    }

    public Stat getEtat1() {
        return etat1;
    }

    public void setEtat1(Stat etat1) {
        this.etat1 = etat1;
    }

    public Stat getEtat2() {
        return etat2;
    }

    public void setEtat2(Stat etat2) {
        this.etat2 = etat2;
    }
    
    
    
}
