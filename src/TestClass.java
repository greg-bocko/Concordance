import java.util.*;
public class TestClass {
	public static void main(String[] args){
		HashTable table = new HashTable();
		table.buildTable("sonnets.txt");
		//System.out.println(new Word("Hel'lo").string);
		System.out.println("That's it, the whole thing is indexed");
		String query = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("There are " + table.SHAKESPEAR_COUNT + " words in the poems");
		
		System.out.println("Would you like to look up a word? Enter 'Quitting' to Quit: ");
		
		while(!query.equals("Quitting")){
			if(query.equals("quitting")) break;
			query = scan.next();
			if(table.lookup(query) != null){
				System.out.println(query + " appears at: ");
				//System.out.println(table.lookup(query).first_ref.toString() + table.lookup(query).first_ref.next_ref.toString());
				table.lookup(query).printReferences();
			}
			else{ System.out.println("Not in there.");}
		}
		/*Reference reference1 =new Reference("I", 2);
		Reference reference2 =new Reference("II", 43);
		Reference reference3 =new Reference("YH", 6);
		Word testword = new Word("squeeeek", reference1);
		testword.insert_ref(reference2);
		testword.insert_ref(reference3);
		testword.printReferences();
		System.out.println(testword.first_ref.next_ref.toString());*/
		
	}

}
