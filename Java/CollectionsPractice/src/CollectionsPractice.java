import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionsPractice {

	public static void main(String[] args) {
		
		Person p = new Person("Pankti",25);
		
		Collection<Person> hs = new HashSet<Person>();
		hs.add(new Person("Shikha",21));
		hs.add(p);
		
		System.out.println("----------HashSet---------");
		System.out.println(hs);
		
		hs.add(new Person("Shikha",21));
		
		System.out.println("----------HashSet after adding !hash and equals---------");
		System.out.println(hs);
		
		hs.add(p);
		
		System.out.println("----------HashSet after adding hash and equals---------");
		System.out.println(hs);
		
		//hs.add(new Person("Bhoomi",21));
		
		//System.out.println("----------HashSet after adding hash same and not !equals---------");
		//System.out.println(hs);
		
		System.out.println("\nConclusion for HashSet : It just checks hash, \n "
				+ "1. hash same : duplicate so do nothing \n"
				+ " 2. hash different : not duplicate so add\n");
		
		HashMap<Person,Integer> hm = new HashMap<Person,Integer>();
		hm.put(new Person("Shikha",21), 1);
		hm.put(p, 2);
		
		System.out.println("----------HashMap---------");
		System.out.println(hm);
		
		hm.put(p, 3);
		
		System.out.println("----------HashMap after putting key having same hash and is equal, different value---------");
		System.out.println(hm);
		
		hm.put(new Person("Shikha",21), 4);
		
		System.out.println("----------HashMap after putting key having different hash and is equal, different value---------");
		System.out.println(hm);

		hm.put(new Person("Shikha",21), 4);
		
		System.out.println("----------HashMap after putting key having different hash and is equal, same value---------");
		System.out.println(hm);
		
		hm.put(p, 3);
		
		System.out.println("----------HashMap after putting key having same hash and is equal, same value---------");
		System.out.println(hm);
		
		//hm.put(new Person("Bhoomi",21), 4);
		
		//System.out.println("----------HashMap after putting key having same hash and is not equal, same value---------");
		//System.out.println(hm);
		
		System.out.println("\nConclusion for HashMap : It just checks hash of key, \n "
				+ "1. hash same :  if equals, override value else duplicate so do nothing\n"
				+ " 2. hash different : not duplicate so add\n");
		
	}



}
