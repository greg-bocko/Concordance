public class HashTable {
	
	Word[] table; 
	final static int TABLESIZE = 536443;//2147483647;
	public int SHAKESPEAR_COUNT = 0;
	
	public HashTable(){
		
		table = new Word[TABLESIZE];
	}
	
	public static int hash(Word key){
		
		int hashVal = 0;
		
		for(int i = 0; i < key.string.length(); i++){
			hashVal = 37 * hashVal + key.string.charAt(i);
		}
		
		hashVal %= TABLESIZE;
		if(hashVal < 0){
			
			hashVal+=TABLESIZE;
		}
		
		return hashVal;
	}
	public static int rehash(int hash, int i){
		return hash + (i * i);
	}
	
	public static int probe(int hashVal){
		
		return 0;
		
	}
	
	public void insert(Word key, Reference ref){
		int hashVal = hash(key);
		int i = 0;
		boolean done = false;
		
		while (table[hashVal] != null) {
		      if (table[hashVal].equals(key)){
		        table[hashVal].first_ref = Reference.insert_ref(table[hashVal], ref);
		      }
		      hashVal = rehash(hashVal, ++i);
		      hashVal %= TABLESIZE;
		    }
			System.out.println("Does it get to " +  key.string + " at " + ref.toString());
			
			table[hashVal] = key;
			table[hashVal].first_ref = Reference.insert_ref(table[hashVal], ref);
			SHAKESPEAR_COUNT++;
			
		/*while(table[hashVal] != null && !table[hashVal].string.equals(key.string)){
			i++;
			hashVal = rehash(hashVal, i);
			hashVal %= TABLESIZE;
		}
		table[hashVal] = key;
		table[hashVal].insert_ref(ref);
		//System.out.println("Just inserted " + table[hashVal].string + " at " + ref.toString());*/
			
	}
	
	public Word lookup(String lookee){
		
		Word key = new Word(lookee);
		int hashVal = hash(key);
		int i = 0;
		
		while (table[hashVal] != null) {
		      if (table[hashVal].equals(key))
		        return table[hashVal];
		      hashVal = rehash(hashVal, ++i);
		      hashVal %= TABLESIZE;
		    }
		    return null;		
	}
	
	public void buildTable(String fname){
		Reader reader = new Reader(fname, this);
		reader.hashUp();
	}


}
