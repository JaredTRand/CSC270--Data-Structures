/*  JARED RAND
 *  9/9/18
 */ 

public class Student{
	private String studentID;
	private String name;
	private int quiz1;
	private int quiz2;
	private int midterm;
	private int finalexam;
	private double avg;
	private String grade;
	
	public Student ()
	{
		this("na","na", 0, 0, 0, 0, 0.0, "na");
	}
	
	public Student (String id, String n, int q1, int q2, int m, int f)
	{
		this(id, n, q1, q2, m, f, 0.0, "na");
		
	}
	public Student (String id, String n, int q1, int q2, int m, int f, double a, String letterGrade)
	{
		studentID=id;
		name=n;
		quiz1=q1;
		quiz2=q2;
		midterm=m;
		finalexam=f;
		avg=a;
		grade=letterGrade;
		
		calcAvg();
		calcGrade();
		
	}
	
	public void set(String id, String n, int q1, int q2, int m, int f, double a, String g)
	{
		studentID=id;
		name=n;
		quiz1=q1;
		quiz2=q2;
		midterm=m;
		finalexam=f;
		avg=a;
		grade=g;
		
	}
	
	public void calcAvg()
	{
		// TODO Calculate the average grade (avg) based on the student's scores (quiz1, quiz2, midterm and finalexam) 
		avg = ((quiz1*10)*.125) + ((quiz2*10)*.125) + (midterm*.25) + (finalexam*.50);
	}
	
	public void calcGrade()
	{
		// TODO Calculate the letter grade (A, B, C, D and F) based on the student's average grade (avg)
		if(avg >= 90){
			grade = "A";
		}else if(avg >= 80 && avg < 90){
			grade = "B";
		}else if(avg >= 70 && avg < 80){
			grade = "C";
		}else if(avg >= 60 && avg < 70){
			grade = "D";
		}else{
			grade = "F";
		}
		
		
	}
	
	public String getID()
	{
		return studentID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getQuiz1()
	{
		return quiz1;
	}
	
	public int getQuiz2()
	{
		return quiz2;
	}
	
	public int getMidterm()
	{
		return midterm;
	}
	
	public int getFinalexam()
	{
		return finalexam;
	}
	
	
	public double getAvg()
	{
		return avg;
	}
	
	public String getGrade()
	{
		return grade;
	}
	
}

