/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Dell
 */
public class Player {

    
    private String Name ;
    private int Score=0 ;
    Card playercards[]=new Card[11];
    private boolean winblackjack=false;
    private boolean alreadylost=false;
     int index=0;
    
    
    
    public Player(String Name ){
      
        this.Name=Name;
    }
    
    
    public void addcards(Card card){
        
      if (index<11){
          
          playercards[index]= card;
          index++;
          Score+=card.getValue();
          if (Score==21)
          {
              winblackjack=true;
          }else if (Score>21)
          {
              alreadylost=true;
              
          }
      }
      
      
    }

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getIndex() {
        return index;
    }

    public Card[] getplayercards(){
        return this. playercards;
    }
    
    
    
}
