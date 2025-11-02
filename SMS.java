class Person{
	public String Name ;
	public int Age ;
	public String  Blood_group ;
	public String DOB;
	Person(String Name , int Age , String Blood_group,String DOB){
		this.Name = Name ;
		this.Age = Age ;
		this.Blood_group = Blood_group;
		this.DOB = DOB;}
}
class Student extends Person{
	public static int student_count ;
	public static int Mtech_student_count ;
	public static int Btech_student_count ;
	public static int [] Branchwise_count;
	public static String [] Branchwise_index  ;
	public int Roll_no ;
	public String Reg_no;
	public String Is_regular; 
	public int admission_year;
	public static int get_index(String str ){
		for(int i = 0 ;i < 10 ;i++){
			if(Branchwise_index[i].equals(str))return i;}
		System.out.println("Branch does exist in a collage");
		return -1 ;
		}
	
	static {
		student_count = 0 ;
		String [] str ={"BTECH(CSE)","BTECH(IT)","BTECH(EXTC)","BTECH(ELE)","BTECH(MECH)","MTECH(CSE)","MTECH(IT)","MTECH(EXTC)","MTECH(ELE)","MTECH(MECH)"};
		Branchwise_index = str;

		Branchwise_count = new int[10];
		} 
	Student(String Name , int Age , String Blood_group ,String DOB , String Branch , String Is_regular , int admission_Year ){
		super(Name, Age , Blood_group,DOB );
		student_count++;
		Btech_student_count++;
		this.admission_year = admission_Year ;
		Roll_no = ++Branchwise_count[get_index(Branch)];
		
		this.Is_regular = Is_regular ;
		int count = Branchwise_count[get_index(Branch)];
		if(Is_regular.equals("Regular")){
			String str = count+"";
			Reg_no = admission_Year+""+Branch.charAt(0)+Branch.substring(6,Branch.length()-1)+"0".repeat(3-str.length())+str;
			}
		else{
			String str = Btech_student_count+"";
			Reg_no = admission_Year+""+Branch.charAt(0)+Branch.substring(6,Branch.length()-1)+"0".repeat(3-str.length())+str;
			
		}}
	Student(String Name , int Age , String Blood_group ,String DOB, String Branch  , int admission_Year ){
		super(Name, Age , Blood_group,DOB );
		student_count++;
		Mtech_student_count++;
		Roll_no = ++Branchwise_count[get_index(Branch)];
		this.admission_year = admission_Year ;
		
		Is_regular = "Is_regular" ;
		int count = Branchwise_count[get_index(Branch)];
		
		String str = count+"";
		Reg_no = admission_Year+""+Branch.charAt(0)+Branch.substring(6,Branch.length()-1)+"0".repeat(3-str.length())+str;	
		}
		
			
	
	public static void main(String [] args){
	}

}
class BTech extends Student {
	String Branch ;
	BTech(String Name , int Age , String Blood_group,String DOB,String Branch, String regular ,int admission_Year){
		super(Name, Age , Blood_group,DOB,("BTECH("+Branch+")"),regular , admission_Year);
		this.Branch = Branch;
	}
	public String toString() {
        return "BTech Student Details:\n" +
               "Name: " + this.Name + "\n" +
               "Age: " + this.Age + "\n" +
               "Blood Group: " + this.Blood_group + "\n" +
               "Branch: " + this.Branch + "\n" +
               "Regular: " + this.Is_regular + "\n" +
               "Admission Year: " + this.admission_year + "\n" +
               "Roll No: " + this.Roll_no + "\n" +
               "Registration No: " + this.Reg_no;
    }
}
class MTech extends Student{
        String Branch ;
	MTech(String Name , int Age , String Blood_group,String DOB,String Branch,int admission_Year){
		super(Name, Age , Blood_group,DOB,("MTECH("+Branch+")"), admission_Year);
		this.Branch = Branch;
	}
	public String toString() {
        return "MTech Student Details(can also add the mtech students):\n" +
               "Name: " +   this.Name + "\n" +
               "Age: " + this.Age + "\n" +
               "Blood Group: " + this.Blood_group + "\n" +
               "Branch: " + this.Branch + "\n" +
               "Admission Year: " + this.admission_year + "\n" +
               "Roll No: " + this.Roll_no + "\n" +
               "Registration No: " + this.Reg_no;
    }
}
public class SMS{
	
    public static void main(String[] args) {
       	Student [] student = new Student[args.length];
    	int i = 0 ;
    	for(String str : args ){
    		String [] string = str.split(",");
    		String s = string[0].toUpperCase();
    		if(s.equals("BTECH")){
    			student[i]=new BTech(string[1],Integer.parseInt(string[2]),string[3],string[4],string[5],string[6],Integer.parseInt(string[7]));
    			}
    		else{
    			student[i]=new MTech(string[1],Integer.parseInt(string[2]),string[3],string[4],string[5],Integer.parseInt(string[6]));
    		} 
    	i++;
    }
    for (Student s : student) {
            System.out.println(s);
            System.out.println("-------------------------");
}


	}
	}
