/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfa_to_dfa;

import java.util.Objects;

/**
 *
 * @author DO
 */
public class Symbole {
    private String valeur;

    public Symbole(String valeur) {
        this.valeur = valeur;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public boolean equals(Symbole obj) {
        return this.valeur.equals(obj.valeur);
    }

    
    
}
