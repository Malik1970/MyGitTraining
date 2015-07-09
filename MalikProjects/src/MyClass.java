
public class MyClass {
	String name1 = "My name";  // non static or instance variable 
	static String name2 = "My name2"; // static or class variable
	
	final static String NAME = "John Yang"; // constant
	final static String HELLO ="Hello World!"; 
	final static String BEFORE = "Checking again after modifying in the method:";
			
	                           //'test', 'c'
	public static void main(String [] args) {
		
		System.out.println("Given arguments count="+args.length);
		printName("Given name is "+args[0]); // correct -- with in the same class 
		MyClass.printName("Second given name is "+args[1]); //correct -- specifying class
		
		MyClass myClass = new MyClass();
		//MyClass myClass1 = new MyClass();
		//MyClass myClass2 = new MyClass();

		myClass.printHelloWorld();
		myClass.printHelloWorld2();
		String name = "John Yang";
		myClass.printHelloWorld2(NAME);
		System.out.println(BEFORE+name); // modified name? John Yang?
		System.out.println("Before method modifying in the myClass.name1"+myClass.name1);
		myClass.printHelloWorld2(myClass);
		System.out.println("Checking again after modifying in the method:"+myClass.name1); // modified name? John Yang?

		//
	}
	
	public void printHelloWorld() {
		System.out.println(HELLO);
		printHelloWorld2("John Yang");
		printName("New name");
		MyClass.printName("New name2");
	}

	/**
	 * Prints given name with Hello, World.
	 *   Example: Hi name, Hello World!
	 * @param name
	 */
	public void printHelloWorld2(String name) {
		System.out.println("Hi " + name +", Hello World!");
		name="Modified name"; //no effect because of pass by value
	}
	
	public void printHelloWorld2(MyClass myClass) {
		System.out.println("Hi " + myClass.name1 +", Hello World!");
		myClass.name1="Modified name"; //it will affect because object value itself is a reference to the object. where members can be changed.
		myClass = new MyClass(); // no impact because of pass by value
	}

	public void printHelloWorld2() {
		System.out.println("Hi, Hello World!");
	}
	
	public static void printName(String name) {
		System.out.println("...."+name);
	}

	
	public static void printName(String firstName, String lastName) {
		System.out.println("First:"+firstName+" Last:"+lastName);
	}
	public static void printName(int number, String name, boolean status) {
		System.out.println("..."+number);
	}
}
