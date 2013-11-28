import java.io.*;

public class Reader {
	
	final int SONNET_LENGTH = 14;
	HashTable table;
	String fname;
	public static int SHAKESPEAR_COUNT;
	
	public Reader(String fname, HashTable table){
		this.fname = fname;
		this.table = table;
		/*String line = "";
		Reference currentRef;
		int i = 0;
		Word[] words = new Word[500000];
		String[] wordsAsStrings = new String[500000];
		int line_num = 1;
		String sonnet_number = "I";
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(fname));
			while((line = br.readLine()) != null){
				if(line_num == 1){
					sonnet_number = line;
					System.out.println("Sonnet Number: " + sonnet_number);
					//System.out.println(line_num);
					line_num++;
					//System.out.println(line_num);
				}
				
				else{
					wordsAsStrings = line.split(" ");
					currentRef = new Reference(sonnet_number, line_num);
					System.out.println("Sonnet " + sonnet_number);
					i = 0;
					while(!(wordsAsStrings[i] == null)){
							words[i] = new Word(wordsAsStrings[i]);
							System.out.print(words[i].string);
							table.insert(words[i], currentRef);
							i++;
							if(++line_num > SONNET_LENGTH) line_num = 1;
					}
					
				}
			}
		}
		catch(IOException e){System.out.println("woah there buddy that's an IO exception");}*/
		
	}
	
	public void hashUp(){
		String line = "";
		Reference currentRef;
		Word[] words = new Word[500];
		//String[] wordsAsStrings = new String[50];
		int line_num = 0;
		int i;
		String sonnet_number = "I";
		
		for(int k = 0; k < words.length; k++){
			words[k] = null;
			//wordsAsStrings[k] = null;
		}
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(fname));
			while((line = br.readLine()) != null){
				line = line.trim();
				if(line_num == 0){
					//line = line.trim();
					sonnet_number = line;
					System.out.println("Sonnet Number: " + sonnet_number);
					line_num++;
				}
				
				else{
					String[] wordsAsStrings = line.split(" ");
					currentRef = new Reference(sonnet_number, line_num);
					System.out.println("Sonnet " + sonnet_number + "." + line_num);
					//i = 0;
					//System.out.println(wordsAsStrings[i] + " ");
					
					for(i = 0; i < wordsAsStrings.length; i++){
							System.out.println("does this ever happen?????");
							//System.out.println("Hello?");
							System.out.println(wordsAsStrings[i]);
							words[i] = new Word(wordsAsStrings[i]);
							System.out.print(words[i].string + " ");
							table.insert(words[i], currentRef);
					}
					
					line_num++;
					if(line_num > SONNET_LENGTH) line_num = 0;
					System.out.println();
					
				}
			}
			
		}
		catch(IOException e){System.out.println("woah there buddy that's an IO exception");}
		
	}

}
