package BinarySearchTree;

import java.util.Scanner;

public class Dictionary
{ 
     public static void main(String args[]) 
    {
Scanner sc = new Scanner(System.in);

//creates binary tree
WordList Tree = new WordList();
WordList deletedTree = new WordList();

System.out.println("Enter the first entry word");
String Word = sc.nextLine();
System.out.println("Enter first entry definition");
String Definiton = sc.nextLine();

//Node is created
WordMeaningNode Root = new WordMeaningNode(new WordMeaning(Word, Definiton ));
WordMeaningNode deletedRoot = new WordMeaningNode(new WordMeaning(" ", "" ));
int input;

do
		{
			System.out.println("Enter what you want to do :");
            System.out.println("1) Add a word and its meaning.");
            System.out.println("2) Delete a Word.");
            System.out.println("3) Display the dictionary and deleted words.");
            System.out.println("4) Exit.");
            System.out.print("Selection: ");

			
			input = sc.nextInt();

			//Add
            if (input == 1) {
                Scanner sca = new Scanner(System.in);
                
                
                System.out.println("Enter the first entry word");
                Word = sca.nextLine();
                System.out.println("Enter first entry definition");
                Definiton = sca.nextLine();

                Tree.insert(Root, new WordMeaning(Word, Definiton));
                
            } 
			//Delete
            else if (input == 2) {
                Scanner scan = new Scanner(System.in);

                System.out.println("");
                System.out.println("Enter word you would like to delete:");
                String deletedWord = scan.nextLine();
    
				Tree.delete(Root, deletedWord);
				deletedTree.insert(deletedRoot, new WordMeaning(deletedWord, ""));
            }
			//Display
            else if (input == 3) {

                System.out.println("List of user words:");
                Tree.inOrderWithMeaning(Root);
                System.out.println("");
                System.out.println("List of deleted words:");
                deletedTree.inOrder(deletedRoot);
                System.out.println("");
                
            } 
			//Exit
            else if (input == 4) {
                System.out.println("Exiting...");
                System.exit(0);
            
            } 
            //Failsafe
            else {
                System.out.println("Wrong choice. Please choose again.");
                System.out.print("Selection: ");
            }


		}while(true);











}
}