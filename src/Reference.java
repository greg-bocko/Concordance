	public class Reference{
		
	String title; 
	int line_num; 
	Reference next_ref;
		
	public Reference(String title, int line_num){
		this.title = title;
		this.line_num = line_num;
		this.next_ref = null;
		}
	
	public String toString(){
		return title + "." + line_num;
	}
	
	public static Reference insert_ref(Word word, Reference ref){
		Reference header = word.first_ref;
		
		if(header == null){
			word.first_ref = ref;		
			return header;
		}
		//int i = 0;

		
		else{
			Reference checkingReference = word.first_ref;
			while(checkingReference.next_ref != null){
				System.out.println(checkingReference.toString());
				checkingReference = checkingReference.next_ref;
			}
		
			System.out.println("Yes I will now insert this");
			checkingReference.next_ref = ref;
			return header;
		}
	}
}