//Ivan Brown
//1/15/21
//CSE 143
//TA: Lizi Case
//Letter Inventory

//This is the LetterInventory class for the LetterInventoryClient. This class 
//stores alphabetic characters into an array that can be changed by the client.
public class LetterInventory {
    //Array size equaling number of letters in alphabet
    private static final int ARRAY_SIZE = 26;
    //new array to store the element data
    private int[] elementData = new int[ARRAY_SIZE];
    //current number of data in array
    private int size = 0;
    
    
    //Constructor which creates an inventory to store the count of 
    //letters from a given string. The letters are all set to lower case.
    public LetterInventory(String data){
        data = data.toLowerCase();
        for(int j = 0; j < data.length(); j++){
            char theChar = data.charAt(j);
            if(Character.isLetter(theChar)){
                this.elementData[getIndex(theChar)]++;
                size++;
            }
        }
    }

    private int getIndex(char c){
        return c - 'a';
    }

    //this method returns the count of an alphabetic character in the array index
    //throws exception is the conditions for the character being a letter are not met
    //this method takes in a parameter of a character 
    public int get(char letter){
        char charLower = Character.toLowerCase(letter);
        if(charLower < 'a' || charLower > 'z'){
            throw new IllegalArgumentException();
        }
        return elementData[getIndex(charLower)];
    }

    //method sets the value in the array and updates the size of the array accordingly
    //this method takes in a character and int parameter
    //this method thros an exception when the precondition is not met
    public void set(char letter, int value){
        char charLower = Character.toLowerCase(letter);
        if(charLower < 0){
            throw new IllegalArgumentException();
        }
        if(charLower < 'a' || charLower > 'z'){
            throw new IllegalArgumentException();
        }
        int delta = value - elementData[getIndex(charLower)];
        elementData[getIndex(charLower)] = value;
        size += delta;
    }

    //method returns the total size of the array added up
    public int size(){
        return this.size;
    }

    //method returns true if index is 0
    public boolean isEmpty(){
        return this.size == 0;
    } 

    //to string method returns the amount of each character in the array
    //strings are immutable, use a string builder for a large test file
    public String toString(){
        String result = "[";
        for(int i = 0; i < ARRAY_SIZE; i++){
            for (int j = 0; j < this.elementData[i]; j++){
                result += (char)('a' + i);
            }
        } 
        return result + "]";
    }

    //creates new letter inventory and returns a letter inventory
    //this method adds two letter inventories together and returns they resultant 
    //sum in a letter inventory
    public LetterInventory add(LetterInventory other){
        LetterInventory result = new LetterInventory("");
        for(int i = 0; i < ARRAY_SIZE;i++){
            char letter = (char)('a' + i);
            int value = this.get(letter) + other.get(letter);
            result.set(letter, value);
        }
        return result;
    }

    //creates new letter inventory and returns a letter inventory
    //this method subtracts two letter inventories toegether and returns their resultant
    //difference in a letter inventory
     public LetterInventory subtract(LetterInventory other){
        LetterInventory result = new LetterInventory("");
        for(int i = 0; i < ARRAY_SIZE; i++){
            char letter = (char)('a' + i);
            int value = this.get(letter) - other.get(letter);
            if(value < 0){
                return null;
            }
            result.set(letter, value);
        }
        return result;
    }
}
