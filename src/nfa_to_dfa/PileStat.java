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
import java.util.Vector;

public class PileStat {
	
	private Vector<Stat> pile = new Vector<Stat>();
	
	public void empiler(Stat n)
	{
		pile.addElement(n);
	}
	
	public Stat depiler()
	{
            Stat a = pile.get(pile.size()-1);
            pile.remove(pile.get(pile.size()-1));
            return a;
	}
	
	public boolean estVide()
	{
		if(pile.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
