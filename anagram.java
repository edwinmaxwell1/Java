package Anagram2;
import java.io.*;
import java.util.*;

public class anagram {

		static List<String> anagrams = new ArrayList<String>();
		
		static List<String> oxdictionary = new ArrayList<String>();
		

		public static void main(String[] args) throws FileNotFoundException { 
		
		       String[] userInput = getUserWords();
		       System.out.println( Arrays.toString(userInput));
		       
		       for(int i = 0; i< userInput.length; i++) {
		    	      findAnagrams(userInput[i], "");
		       }
		       System.out.println(anagrams);
		       
		  Scanner search = new Scanner(new FileInputStream("C:\\Users\\owner\\eclipse-workspace"));
		  ArrayList<String> oxford = new ArrayList<String>();
		  while(search.hasNextLine()) {
			  
			  oxford.add(search.nextLine());
			  
		  }
		  
		  search.close();
		  String[] array = anagrams.toArray(new String[0]);
		  String[] dict = oxford.toArray(new String[0]);
		  isRealWords(array, dict);
		  System.out.println("All anagrams: ");
		  System.out.println(oxdictionary);
		  

		}
		
		public static String[] getUserWords() {
			/*
			 * The getUserWords() tells the user to input words that will give the anagrams later
			 * Prompts the user to type words they want and then takes those words to compile into an array for later.
			 */
			Scanner scanner = new Scanner(System.in);
	        System.out.println("Words to be searched for anagram:");
	        String[] tokens = scanner.nextLine().split("\\s");
	        scanner.close();
	        return tokens;
	        
		}
		 
		static void findAnagrams(String str, String result)	{
			/*
			 * looks through all the anagrams to see the white spaces but still be able to see what words
			 * it needs to compare to
			 */
			if (str.length() == 0) {
				
				anagrams.add(result);
				return;
			}
			
			for (int i = 0; i < str.length(); i++) {
				
				char ch = str.charAt(i);
				String restOfStr = str.substring(0, i) + str.substring(i+1);
				findAnagrams(restOfStr, result + ch);
			}
		}

		static void isRealWords(String[] userInput, String[] oxfordD) {
			/*
			 * Goes and takes all the combinations that have been generated and compares them to the txt file
			 * to see if they are real words in the oxford dictionary and if it does then it adds them to the list for the user.
			 */
			for(int i = 0; i < userInput.length; i++) {
				for(int j = 0; j < oxfordD.length; j++) {
					if(userInput[i].equalsIgnoreCase(oxfordD[j])) {
						
						oxdictionary.add(userInput[i]);
					}
				}

			}
		  
		}
}

