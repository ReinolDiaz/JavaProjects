package BinarySearchTree;

public class WordList {
	
	String s;

	public WordList()
	{
		s = " ";
	}
       
    	public void insert(WordMeaningNode node, WordMeaning value){
		
		if (value.getWord().compareTo(node.value.getWord()) < 0){ 
			
			if (node.left != null) { 
				insert(node.left, value); 
			} 
			
				else{ 
					s += node.value.getWord() + "  "; 
					System.out.println(" Inserted [" + value.getWord() + "] to left of [" + node.value.getWord()  + "]");
					node.left = new WordMeaningNode(value); 
				}
		} 
		
		else if (value.getWord().compareTo(node.value.getWord())  > 0){
			
			if (node.right != null) 
			{
				insert(node.right, value);
			} 
				else{
					s += node.value.getWord() + "  "; 
					System.out.println(" Inserted [" + value.getWord() + "] to right of [" + node.value.getWord() + "]");
					node.right = new WordMeaningNode(value);
				}
		}
	}

    //copy of inorder to print with definition 
    //kept in order in case no definition was needed
    public void inOrderWithMeaning(WordMeaningNode node) // Ascending order
    {
        if (node != null) 
        {
            
            inOrderWithMeaning(node.left);
            System.out.print("\n " + node.value.getWord() + " - " + node.value.getMeaning() + "\n " ); 
            inOrderWithMeaning(node.right);
        }
     }

	public void inOrder(WordMeaningNode node) // Ascending order
	{
		if (node != null)
		{
			inOrder(node.left);
			System.out.print("\n " + node.value.getWord() + "\n " );
			inOrder(node.right);
		}
	}
     
    public boolean contains(WordMeaningNode node, String key)
	{
		if (node == null)
        {
			return false;
		}

		boolean contains = false;

		while (node != null)
            {
                if (key.compareTo(node.value.getWord()) < 0 )
                {
                    node = node.left;
                }
                    else if (key.compareTo(node.value.getWord()) > 0)
                    {
                        node = node.right;
                    }
                    else 
                    {
                        contains = true;
                        break;
                    }
            }
            return contains;
        }    
     
	public WordMeaningNode delete(WordMeaningNode root, String key)
	{

        if (root == null)
        return root;
        
    if (key.compareTo(root.value.getWord()) < 0)
        root.left = delete(root.left, key);
    else if (key.compareTo(root.value.getWord()) > 0)
        root.right = delete(root.right, key);

    else {
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;

        root = getMinimumKey(root.right);

        root.right = delete(root.right, root.value.getWord());
        }
    return root;
    }
        
	public WordMeaningNode getNext (WordMeaningNode root) {

		if (root == null) 
        {
			return null;
		}
        
        WordMeaningNode temp = root.right;

		while(temp != null)
        {
            temp = temp.left;
		}
		return temp;
	}

	//	You may need this helper function to find minimum value node in the subtree rooted at `curr`
	public WordMeaningNode getMinimumKey(WordMeaningNode curr)
	{
		while (curr.left != null) 
		{
			curr = curr.left;
		}
		return curr;
	}

	public String toString()
	{
		return s;
	}
}
