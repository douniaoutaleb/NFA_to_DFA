/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfa_to_dfa;

/**
 *
 * @author DO
 */
public class CoupleStat {
    private String etat1;
    private String etat2;

    public CoupleStat(String etat1, String etat2) {
        this.etat1 = etat1;
        this.etat2 = etat2;
    }

    public String getEtat1() {
        return etat1;
    }

    public void setEtat1(String etat1) {
        this.etat1 = etat1;
    }

    public String getEtat2() {
        return etat2;
    }

    public void setEtat2(String etat2) {
        this.etat2 = etat2;
    }
    
    
    
}
