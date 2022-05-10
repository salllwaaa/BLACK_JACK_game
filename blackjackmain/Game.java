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
import java.util.Random;


public class Game {
    
     Player []players=new Player[4];
     Card[] carddeck=new Card[52];
     int maxscore=0;
     int idx=0;
     
     
     void  generatedeckcards()
     {
        int cont=0;
        int value ,rank,suit; 
         for (int i=0 ; i<4 ; i++)
         {
             suit=i;
             for(int j=0 ; j<13 ;j++)
             {
                  rank=j;
                 if(rank>9)
                     value =10;
                 else
                     value =rank+1;
                 
                 carddeck[cont]=new Card(suit , rank ,value );
                 
                 cont++;
             }
         }
     }
     
     public Card Random(){
         
         
        int randomchoice;
         while(true){
             
         Random rand= new Random();
          randomchoice=rand.nextInt(52);
         
         
         if (carddeck[randomchoice]!=null)
         break;
         
             
         } 
         Card newcard;
         newcard=carddeck[randomchoice];
         carddeck[randomchoice]=null;
         
         return newcard;
     }
     
    public void setplayerinformation(String name ){
        
     
    players[idx]=new Player(name);
     
        
        
           //Player playerinfo =new Player(name[i]);
          
          players[idx]=new Player(name);
         
           for (int j=0 ; j<2 ; j++)
           players[idx].addcards(Random());
           
           idx++;
          }
        
        
            
    
    
    public int maxscore()
    {
        int x=0;
        for (int i=0 ; i<4 ;i++)
        {
            if (players[i].getScore()<=21)
            {
            if (players[i].getScore()>maxscore)
            {
                maxscore=players[i].getScore();
                x=maxscore;
            }
        
           }
        }
        return x;
    }

    public int getMaxscore() {
        return maxscore;
    }
    
    
}
