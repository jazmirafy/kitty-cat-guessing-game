import java.util.Scanner;
import java.lang.Character;

public class Kitty
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        //create a variable to hold the secret word
        String answer;
        
        //create a variable to hold the number of player lives
        int lives;

        //create a boolean array that is long enough to match the length of any size word on the Words.java list
        boolean[] revealed = new boolean [30];

        //create new game variable. this will allow the user to play again or not. it is set to 'y' to start the first iteration of the while loop
        char newGame = 'y';

        //this outer while loop just sets up all the necessary values for the game and gives the intro. it will also allow the user to play again.
       while(newGame == 'y' || newGame == 'Y'){

            //generate a pseudo random word to be the secret word
            answer = Words.getWord();

            //give the user 9 lives
            lives = 9;

            /*the number of values filled in this boolean array matches the number of letters the secret word has.
            all boolean values are set to false for now, but once the user guesses the letter correctly, the boolean value with the same index as the correctly guessed 
            letter in the secret word changes to true so we can keep track of the correctly guessed letters.*/
            for(int i = 0; i < answer.length(); i++)
            {
                revealed[i] = false;
            }

            //introduce the game
            //System.out.println("=^◕⩊◕^=");
            System.out.println("you are a kitty and you have 9 lives.");
            System.out.println( "<3 <3 <3 <3 <3 <3 <3 <3 <3");
            System.out.println("MEOW! guess all the letters in the secret word correctly or you will DIE! O.O");
            
            //this inner while loop has the main game components
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
                        //System.out.println("—ฅ/ᐠ. ̫ .ᐟ\ฅ—");
                        System.out.println("MEOW! the secret word has the letter " + letter + " in it at index " + i);
                        revealed[i] = true;
                        curLetterFound = true;
                    }
                }
                
                //take a life away if they guessed the letter incorrrectly
                if(curLetterFound == false)
                {
                    lives--;
                    //System.out.println("(ᓀ‸ᓂ)");
                    if(lives > 1)
                    {
                    System.out.println("MEOW! you lost one of your kitty lives! you now have " + lives + " lives.");
                    }
                    if(lives == 1)
                    {
                    System.out.println("MEOW! you lost one of your kitty lives! you now have " + lives + " life left.");
                    }
                    //display a heart for every life they have
                    for(int i = 0; i < lives; i++)
                    {
                        System.out.print("<3 ");
                    }
                    System.out.println();
                        
                }
                
                //if they run out of lives leave the inner while loop
                if(lives == 0)
                {
                    //System.out.println("(づ ᴗ _ᴗ)づ♡");
                    System.out.println("the secret word was " + answer + ".");
                    System.out.println("MEOW! you have lost all of your kitty lives. you are now DEAD. >_<");
                    break;
                }
                else
                {
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
                    for(int i = 0; i < answer.length(); i++)
                    {
                        
                        if(revealed[i] == false)
                        {
                            allLettersFound = false;
                        }
                    }
                    
                    //if they've guessed all the letters correctly, tell them they won! now leave the inner while loop
                    if(allLettersFound == true)
                    {
                        System.out.println();
                        //System.out.println("≽^•⩊•^≼ ₊˚⊹♡");
                        System.out.println("the secret word was " + answer + ".");
                        System.out.println("MEOW! you win kitty! :D");
                        break;
                    }
                
                }
            }
            //let the user select if they want to play again or not.
            System.out.println("do you want to play again? press 'y' to start a new game or press 'n' to leave.");
            newGame = keyboard.nextLine().charAt(0);
            if(newGame == 'y' || newGame == 'Y')
            {
                System.out.println("let's play again! MEEEOOOOOWWWWWW");
            }
       }
       //if they said no to the new game tell them bye
       System.out.println("see you next time. MEEEOOOWWWWWWW");
    }
}
