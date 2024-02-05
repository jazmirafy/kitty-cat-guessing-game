import java.util.Scanner;
import java.lang.Character;

public class Kitty
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        //select a random word from the Word.java file to be the secret word
        String answer = Words.getWord();
        
        //give the player 9 lives
        int lives = 9;
        
        /*create a boolean array that is the length of the secret word. all values are set to false for now, 
        but once the user guesses the letter correctly, the boolean value with the same index as the correctly guessed 
        letter in the secret word changes to true so we can keep track of the correctly guessed letters.*/
        boolean[] revealed = new boolean [answer.length()];
        for(int i = 0; i < revealed.length; i++)
        {
            revealed[i] = false;
        }
        
        //introduce the game
        System.out.println("you are a kitty and you have 9 lives. MEOW! guess all the letters in the secret word correctly or you will DIE!");
        while (true)
        {
            
            //prompt user to enter a letter
            boolean curLetterFound = false;
            System.out.println("enter a lowercase letter: ");
            char letter = keyboard.nextLine().charAt(0);

            //check if the letter is in the secret word
            for(int i = 0; i < answer.length(); i++)
            {

                if(answer.charAt(i) == letter)
                {
                    System.out.println("MEOW! the secret word has the letter " + letter + " in it at index " + i);
                    revealed[i] = true;
                    curLetterFound = true;
                }
            }
            
            //take a life away if they guessed the letter incorrrectly
            if(curLetterFound == false)
            {
                lives--;
                System.out.println("MEOW! you lost one of your kitty lives! you now have " + lives + " live(s).");
            }
            
            //if they run out of lives end the game/leave the while loop
            if(lives == 0)
            {
                System.out.println("the secret word was " + answer + ".");
                System.out.println("MEOW! you have lost all of your kitty lives. you are now DEAD.");
                break;
            }

            //show the letters they have guessed correctly so far and print a _ for the missing letters
            for(int i = 0; i< answer.length(); i++)
            {
                if(revealed[i] == true)
                {
                    System.out.print(answer.charAt(i) + " ");
                }
                else
                {
                    System.out.print("_ ");
                }
            }
            
            //check if they've guessed all the letter correctly yet
            boolean allLettersFound = true;
            for(int i = 0; i < revealed.length; i++)
            {
                
                if(revealed[i] == false)
                {
                    allLettersFound = false;
                }
            }
            
            //if they've guessed all the letters, tell them they won!
            if(allLettersFound == true)
            {
                System.out.println();
                System.out.println("the secret word was " + answer + ".");
                System.out.println("MEOW! you win kitty! <33");
                break;
            }
            System.out.println();
        }
    }
}
