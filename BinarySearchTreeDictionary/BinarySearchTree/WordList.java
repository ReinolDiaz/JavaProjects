package BinarySearchTree;

class WordList {
  
    WordMeaningNode head;
    WordMeaningNode sorted;
  
    public WordList() {
        head = null;
    }
  
    public static WordList insert(WordList list, WordMeaning wordMeaning) {
        //Create a new node
        WordMeaningNode newNode = new WordMeaningNode(wordMeaning);
        newNode.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = newNode;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            WordMeaningNode last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the newNode at last node
            last.next = newNode;
        }

        //Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public static void displayList(WordList list)
    {
        WordMeaningNode currNode = list.head;

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.println(currNode.wordMeaning.word + " -- " + currNode.wordMeaning.meaning);

            // Go to next node
            currNode = currNode.next;
        }
    }
  
    //function to sort the list lexicographically
    public void sortList(WordList list)
    {
      
        sorted = null;
        WordMeaningNode current = list.head;
      
        while (current != null)
        {
            WordMeaningNode next = current.next;
            sortedInsert(current);
            current = next;
        }
        // Update head_ref to point to sorted linked list
        list.head = sorted;
    }

    //helper method for sortList
    void sortedInsert(WordMeaningNode newNode)
    {
        if (sorted == null || sorted.wordMeaning.word.compareTo(newNode.wordMeaning.word) >= 0)
        {
            newNode.next = sorted;
            sorted = newNode;
        }
        else
        {
            WordMeaningNode current = sorted;

            while (current.next != null && current.next.wordMeaning.word.compareTo(newNode.wordMeaning.word) > 0)
            {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
}
