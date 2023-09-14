import java.util.Random;
import java.util.Scanner;

/**
@Eleni
@version askisi2
*/

public class GuessGame 
{
    public static String MESSAGE_WON = "You won!\n",
                    MESSAGE_LOST = "Lost\n",
                    MESSAGE_SCORE = "Your score is: ",
                    MESSAGE_QUESTION = "Give a number between 1 and 49 ";

    private int maxIterations,maxRandom,iteration,score,input;

    /**
    Constractor...
    @param...
    */
    public GuessGame (int maxIterations,int maxRandom)
    {
        score=0;
        this.maxIterations=maxIterations;
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
        for (int i=0; i<maxIterations; i++)
        {
            int input =read();
            int guess=generateRandom();

            if(input==guess)
            {
                increaseScore();
                write(MESSAGE_WON);
            
            }
            else 
            {
                write(MESSAGE_LOST);
            }
        }
        write(MESSAGE_SCORE + score + "/" + maxIterations + "."); 
    }

    /**
    Main method
    */
    
    public static void main (String[] args)
    {
        GuessGame x=new GuessGame(6,49);
        x.playLotto();
    }
}