import java.util.Scanner;
import java.lang.Character;

public class Kitty
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String answer = Words.getWord();
        int lives = 9;
        boolean[] revealed = new boolean [answer.length()];
        for(int i = 0; i < revealed.length; i++)
        {
            revealed[i] = false;
        }
        System.out.println("you are a kitty and you have 9 lives. MEOW! guess all the letters in the secret word correctly or you will DIE!");
        while (true)
        {
            boolean curLetterFound = false;
            System.out.println("enter a lowercase letter: ");
            char letter = keyboard.nextLine().charAt(0);
            
            for(int i = 0; i < answer.length(); i++)
            {

                if(answer.charAt(i) == letter)
                {
                    System.out.println("MEOW! the secret word has the letter " + letter + " in it at index " + i);
                    revealed[i] = true;
                    curLetterFound = true;
                }
            }
            if(curLetterFound == false)
            {
                lives--;
                System.out.println("MEOW! you lost one of your kitty lives! you now have " + lives + " live(s).");
            }
            if(lives == 0)
            {
                System.out.println("the secret word was " + answer + ".");
                System.out.println("MEOW! you have lost all of your kitty lives. you are now DEAD.");
                break;
            }
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
            boolean allLettersFound = true;
            for(int i = 0; i < revealed.length; i++)
            {
                if(revealed[i] == false)
                {
                    allLettersFound = false;
                }
            }
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
