public class Word{
	
	String string;
	Reference first_ref; 
		
	public Word(String input){
			
		string = input.replaceAll("\\W", "").toLowerCase(); //replaces punctuation with empty strings, makes everything lowercase
		//insert_ref(title, line_num);
		first_ref = null;
	}
		/*public static void insert_ref(Reference ref, Word word){
			
			if(first_ref == null){
				first_ref = ref;
				return;
			}

			Reference checkingReference = first_ref;
			//System.out.println("First Reference");
			while(checkingReference.next_ref != null){
				//System.out.println("But this never gets called, does it?");
				checkingReference = checkingReference.next_ref;
			}
			System.out.println("Yes I will now insert this");
			checkingReference.next_ref = ref;
		}*/
	
	public boolean equals(Word word2){
		return word2.string.equals(string);
		
	}
	public void printReferences(){
		Reference workingRef = first_ref; 
		while(workingRef != null){
			System.out.println(workingRef.toString());
			workingRef = workingRef.next_ref;
		}
	}
}
