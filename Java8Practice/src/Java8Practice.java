
public class Java8Practice {

	final static String welcome = "Welcome";
	String here = "here";
	
	public static void main(String[] args) {
		
		Java8Practice test = new Java8Practice();
		
		MathOperation addition = (a,b) -> a+b ;
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

	}
	
	int operate(int a, int b, MathOperation op) {
		return op.operation(a, b);
	}
	
	void greet() {
		GreetingService greeting2 = hello -> System.out.println(hello + " " + welcome + " " + here + " Shikha");
		greeting2.greetMessage("Hello");
	}

}
