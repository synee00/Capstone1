import java.util.Scanner;

/*Jasmine S. Allen
 * July 20, 2018
 * Program: Prompts the user for a word. Translate the text to Pig Latin and 
 * 			displays it on the console. ASks the user if they want to translate  
 * 			another word.
 * Build Specs: 1. Convert each word to a lower case before translating.
 * 				2. If a word starts with a vowel, just add "way" onto the ending.
 * 				3. If a word starts with a consonant, move all of the consonants that 
 * 					appear before the first vowel to the end of the word, then add "ay"
 * 					to the end of the word.
 * 	**Treat y as a consonant.
 *  ***With extended challenges
 */
public class PigLatinTranslatorExtra {

	public static void main(String[] args) {
		
		//print 
		System.out.println("Welcome to the Pig Latin Translator!");
		
		Scanner scan = new Scanner(System.in);

		//translates the text to Pig Latin and displays it on the console
		//asks the user if they wish to continue
		translator(scan);
		
		//exit
		System.out.println("Thanks for using our service!");
		 
		
	}
	public static void translator(Scanner scan) {
		
		String input = null, output, temp, temp2, junk;
		String choice = "y";
		int index = 1;
		boolean valid = false;
		String[] words;

		while(choice.matches("[yY].*"))
		{
			//reset values for next iteration
			output = " ";
			input = null;
			valid = false;
			
			while(!valid)
			{
				//get user input
				System.out.print("Please enter a sentence to be translated: ");
				input = scan.nextLine();
				System.out.println();
				
				//matches("[a-zA-Z]*")
				//checks for empty string, symbols and numbers, if found the input is not valid
				if(input.matches("[a-zA-Z\\s\\']*") && !input.isEmpty()) {
						valid = true;
					}
			}
			
			//splits the line into word array elements
			words = input.split("\\s+");
			
			for (int i = 0; i < words.length; i++) {
			    
			    words[i] = words[i].replaceAll("[^\\w]", "");
			}
			
			for (String element : words) {
				
				//translate
				if(element.charAt(0) == 'a' || element.charAt(0) == 'e' || element.charAt(0) == 'i' 
						|| element.charAt(0) == 'o' || element.charAt(0) == 'u')
				{
					element += "way";
					System.out.print(element + " ");
				}
				else
				{
					//grabs the first occurrence of a vowel
					for(int i = 0; i < element.length(); i++)
					{
						if(element.charAt(i) == 'a' || element.charAt(i) == 'e' || element.charAt(i) == 'i' 
								|| element.charAt(i) == 'o' || element.charAt(i) == 'u')
						{
							index = i;
							break;
						}
						
					}
					//create substrings containing the starting consonants and remaining letters 
					temp = element.substring(0,index);
					temp2 = element.substring(index);
					
					//adds consonants and "ay" to the end of the word 
					temp2 += temp + "ay";
					
					//prints results
					System.out.print(temp2 + " ");
				}
				
				//prints each word on the same line
			    //System.out.print(element + " ");
			}
			
			
			//translate again?
			System.out.println();
			System.out.println();
			System.out.print("Translate again? (y/n)?  ");
			choice = scan.next();
			
			//adding a getline to be able to read the next iteration of the translator
			junk = scan.nextLine();
			System.out.println();
			System.out.println();
			
		}
	}
	

}
 