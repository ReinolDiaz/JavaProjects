
import java.io.*;
import java.util.Scanner;

public class Dictionary
{
   public static void main(String[] args) throws Exception{
      
       Scanner sc = new Scanner(System.in);
      
       InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
      
       WordList wordList = new WordList();
      
       int input;
      
       do {
            System.out.println("Enter what you want to do :");
            System.out.println("1) Add a word and its meaning.");
            System.out.println("2) Display the dictionary");
            System.out.println("3) Exit");
            input = sc.nextInt();
          
            if (input == 1) {
              
                String meaning = "";
                System.out.println("Enter the word : ");
                String word = reader.readLine();
              
                System.out.println("Enter its meaning : ");
                meaning = reader.readLine();
              
                WordMeaning wordMeaning = new WordMeaning(word, meaning);
                wordList.insert(wordList, wordMeaning);
              
            } else if (input == 2) {
              
                wordList.sortList(wordList);
                wordList.displayList(wordList);
              
            } else if (input == 3) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Wrong choice. Please choose again.");
            }
       } while (true);
   }
}
