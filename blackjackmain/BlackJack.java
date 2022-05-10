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
import java.util.Scanner;
public class BlackJack {

    
    
    //public static 
    
    static Game game =new Game();
    public static void main(String[] args) {
       
        GUI gui = new GUI();
        
        game.generatedeckcards();
        
        
        Scanner playername=new Scanner(System.in);
        String []name =new String[4];
        for (int i=0 ; i<4 ; i++){
         System.out.println("player "+(i+1)+"name");
        name[i] =playername.nextLine();
        
        }
        for(int i=0 ; i<4 ; i++){
        game.setplayerinformation(name[i]);
            
        }
        int x=game.maxscore();
        gui.runGUI( game.carddeck, 
                game.players[0].getplayercards(),  
                game.players[1].getplayercards(), 
                game.players[2].getplayercards(), 
                game.players[3].getplayercards() );
        
        
        for ( int i =0 ; i<3 ; i++)
        {
         int cnt=i+1;
         System.out.println("the score of the"+" "+cnt+" "+"player is: "+game.players[i].getScore());   
            while (game.players[i].getScore()<21)
            {
               
                    
                System.out.println("1 for hit or 2for stand" );
               // System.out.println("1 for hit 2 for stand" );
                Scanner ans= new Scanner(System.in);
                int answer=ans.nextInt();
                 if (answer==1)
                 {
                     
                    game.players[i].addcards(game.Random());
                    int c=i+1;
                    System.out.println("the score of the"+" "+c+" "+"player is: "+game.players[i].getScore());
                    gui.updatePlayerHand(game.players[i].playercards[game.players[i].getIndex()-1],i );
                 }
                 else 
                 {
                     System.out.println("Next player Turn");
                      break;
                 }
                
                 
            }
        }
        
        
         
        
        
        while (game.players[3].getScore()<=game.maxscore  && game.players[3].getScore()<21){
            
            
            //System.out.println("the score of the dealer is :"+game.players[3].getScore());
            game.players[3].addcards(game.Random());
            
            gui.updateDealerHand(game.players[3].playercards[game.players[3].index-1], game.carddeck);
            
            
            
            
        }
        
        x=game.maxscore();
        
        int cnt=0;
        boolean  z = false;
        int winner_index=0;
        for (int i=0 ; i<4;i++){
            
            if (game.players[i].getScore() ==game.maxscore & x<=21 )
            {
                cnt++;
                winner_index =i+1;
                z=true;
            }
        }
        if (cnt>1){
            System.out.println("Push");
        }
        else if(z==false) {
           System.out.println("Dealer " +"WIN");
        }
        else{
            System.out.println(winner_index +"WIN");
        }
        
    
         
}
    
    
    
}