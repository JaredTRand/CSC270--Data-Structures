/*  JARED RAND
 *  9/9/18
 */ 

public class Complex {
	
	private int real;
	private int imaginary;
	
	Complex(){
		real = 0;
		imaginary = 0;
	
	}
	
	Complex(int x, int y){
		real = x;
		imaginary = y;
	
	}
	
	public Complex add (Complex x, Complex y) {
		real = x.real + y.real;
		imaginary = x.imaginary + y.imaginary;
		return this;
	}

	public Complex subtract (Complex x, Complex y) {
		real = x.real - y.real;
		imaginary = x.imaginary - y.imaginary;
		return this;
	}
	
	public void display () { 
		System.out.println("("+real+","+imaginary+")");
		
	}

	public static void main(String[] args) {
		Complex c1=new Complex(3, -5);
		Complex c2=new Complex(8, 7);
		
		System.out.println("The numbers are: ");
		c1.display();
		c2.display();
		
		Complex sum = new Complex();
		sum.add(c1, c2);
		Complex diff = new Complex();
		diff.subtract(c1, c2);
		System.out.println("The sum is: ");
		sum.display();
		System.out.println("The difference is: ");
		diff.display();
		
		
	}

}
