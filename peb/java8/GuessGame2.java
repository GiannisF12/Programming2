import java.util.Random;
import java.util.Scanner;

/**
GuessGame2 : A number guessing game.
@Michael
@version 0.1
*/

public class GuessGame2 
{
    public static String MESSAGE_WON = "You won!\n",
                    MESSAGE_LOST = "Lost\n",
                    MESSAGE_SCORE = "Your score is: ",
                    MESSAGE_QUESTION = "Give a number";

     private int DigitNumber,maxRandom,iteration,score,input;

    /**
    Constractor...
    @param...
    */
    public GuessGame2 (int DigitNumber,int maxRandom)
    {
        score=0;
        this.DigitNumber=DigitNumber;
        this.maxRandom=maxRandom;
    }
    /**
    Method to increase score
    */

    public void increaseScore()
    {
        score++;
    }

    /**
    Return the score
    @return...
    */

    public int getScore()
    {
        return score;
    }

    /**
    Return a random
    @return a random...
    */

    public int generateRandom()
    {
        Random r= new Random();
        int guess=r.nextInt(maxRandom);
        return guess;
    }

    public int read()
    {
        Scanner s=new Scanner (System.in);
        System.out.println(MESSAGE_QUESTION);
        int input=s.nextInt();
        return input;
    }

    /**
    @param...
    */

    public void write (String s)
    {
        System.out.println(s);
    }

    /**
    Method playLotto
    */

    public void playLotto()
    {
        for (int i=0; i<DigitNumber; i++)
        {
            int input =read();
            int guess=generateRandom();

            if(input==guess)
            {
                increaseScore();
            
            }
        }
        
        if(score==6)
        {
            write(MESSAGE_WON);
        }
        else
        {
            write(MESSAGE_LOST);
        }
    }

    /**
    Main method
    */
    
    public static void main (String[] args)
    {
        GuessGame2 x=new GuessGame2();
        x.playLotto();
    }
}