import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Practice {

	final static String welcome = "Welcome";
	String here = "here";
	
	public static void main(String[] args) {
		
		Java8Practice test = new Java8Practice();
		
		MathOperation addition = (a,b) -> a+b ; //Lambda Expression
		MathOperation subtraction = (int a, int b) -> a-b ;
		MathOperation multiplication = (int a, int b) -> {return a*b;} ;
		FloatMathOperation division = (a,b) -> a/b ;
		
		System.out.println("Addition : " + test.operate(10,5,addition));
		System.out.println("Subtraction : " + test.operate(10,5,subtraction));
		System.out.println("Multiplication : " + test.operate(10,5,multiplication));
		System.out.println("Division : " + division.operation(10,5));
		
		GreetingService greeting1 = hello -> System.out.println(hello + " " + welcome + " Shikha");
		greeting1.greetMessage("Welcome");
		greeting1.greetMessage("Hello");
		
		test.greet();
		
		List<String> names = new ArrayList<String>();
		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");
			
	    names.forEach(System.out::println); //Method reference (Lambda Expression)
	    
	    BufferedReader reader = new BufferedReader(
	    		new InputStreamReader(
	    				Java8Practice.class.getResourceAsStream("person")));
	    
	    List<Person> persons = new ArrayList<Person>();
	    
	    Stream<String> stream = reader.lines();
	    stream.map(line ->
	    {
	    	String[] s = line.split(" ");
	    	Person p = new Person(
	    			s[0].trim(),
	    			s[1].trim(),
	    			Integer.parseInt(s[2]));
	    	persons.add(p);
	    	return p;
	    })
	    .forEach(System.out::println);
	    
	    Map<Integer, List<Person>> ageAggregate = persons.stream().collect(Collectors.groupingBy(p -> p.getAge()));
	    System.out.println("\nAggregated by age : " + ageAggregate);
	    
	    Map<Integer,Map<String,List<Person>>> bimap = new HashMap<Integer,Map<String,List<Person>>>();
	    
	    try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    persons.forEach(
	    		person ->
	    		bimap.computeIfAbsent(person.getAge(), HashMap::new)
	    		.merge(person.getGender(), new ArrayList<Person>(Arrays.asList(person)),
	    				(l1,l2) -> {
	    					l1.addAll(l2);
	    					return l1;
	    				}));
	    
	    bimap.forEach((key,value) -> System.out.println(key + "->" + value));

	}
	
	int operate(int a, int b, MathOperation op) {
		return op.operation(a, b);
	}
	
	void greet() {
		GreetingService greeting2 = hello -> System.out.println(hello + " " + welcome + " " + here + " Shikha");
		greeting2.greetMessage("Hello");
	}

}
