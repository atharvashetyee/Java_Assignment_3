import java.util.*;

class Employees{
	String name;
	int empId;
	String dept;
	
	
	Employees(String name,int empId,String dept){
		if(name==null) {
			throw new IllegalArgumentException("Name cant be null");
		}
		if(empId<0) {
			throw new IllegalArgumentException("Id cant be zero");
		}
		this.name=name;
		this.empId=empId;
		this.dept=dept;
	}
	Employees(String name,int empId){
		this.name=name;
		this.empId=empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	void display() {
		System.out.println("Name:"+ name +"ID" + empId + "DEPT" +  dept);
	}
}
class Manager extends Employees{
	int numberOfTeams;
	Manager(String name,int empId,String dept,int numberOfTeams){
		super(name,empId,dept);
		this.numberOfTeams=numberOfTeams;
	}
	Manager(String name,int empId){
		super(name,empId);
	}
	void display() {
		System.out.println("Name"+ getName() +"ID"+ getEmpId() + "Department"+ getDept()+ "Teams"+ numberOfTeams);
	}
}
public class Employee6 {
	public static void main(String args[]) {
		Manager mr=new Manager("abc",12);
		Manager mr1=new Manager("def",22,"cs",2);
		mr.display();
		mr1.display();
		
		Employees ey=new Employees("dfg",24,"it");
		ey.display();
		}
}
