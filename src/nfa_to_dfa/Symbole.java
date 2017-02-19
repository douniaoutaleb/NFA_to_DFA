/*
 * Symbole.java
 */
package nfa_to_dfa;


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

    @Override
    public String toString() {
        return valeur ;
    }

    
    
}
