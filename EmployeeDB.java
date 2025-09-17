import java.util.*;

class Employee{
	private String empName;
	private int empId;
	private String department;
	Employee(String empName,int empId,String department){
		this.empName=empName;
		this.empId=empId;
		this.department=department;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", department=" + department + "]";
	}
	void display() {
		System.out.println("Employee"+ empName+ "Id"+ empId+ "Department"+ department);
	}
	
		
}
class Data{
	private ArrayList<Employee> emp;
	Data(){
		emp=new ArrayList<>();
	}
	
	//add 
	public void addEmp(Employee ep) {
		emp.add(ep);
		System.out.println("Added Emp");
		}
	//update
	public void Update(int Id,String newDept) {
		Iterator<Employee> iterator=emp.iterator();
		boolean found=false;
		while(iterator.hasNext()) {
			Employee ep=iterator.next();
			if(ep.getEmpId()==Id) {
				ep.setDepartment(newDept);
				found=true;
			}
			
		}
		if(!found) {
			System.out.println("No such Id");
		}
	}
	
	//remove
	public void Remove(int id) {
		Iterator<Employee> iterator=emp.iterator();
		boolean found=false;
		while(iterator.hasNext()) {
			Employee ep=iterator.next();
			if(ep.getEmpId()==id) {
				iterator.remove();
				System.out.println("Removed");
			}
		}
		if(!found) {
			System.out.println("No such Id");
		}
	}
	
	//display
	public void Displayall() {
		for(Employee ep:emp) {
			ep.display();
			}
		}
	}


public class EmployeeDB {
	public static void main(String args[]) {
		Data dt=new Data();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("Welcome");
			System.out.println("1.Add");
			System.out.println("2.Update");
			System.out.println("3.Remove");
			System.out.println("4.List all");
			System.out.println("5.exit");
			System.out.println("Enter Choice");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
		switch(choice) {
			case 1:
				System.out.println("Enter name");
				String empName=sc.nextLine();
				System.out.println("Enter ID");
				int empId=sc.nextInt();
				sc.nextLine();
				System.out.println("Dept");
				String department=sc.nextLine();
				Employee ep=new Employee(empName,empId,department);
				dt.addEmp(ep);
				break;
			case 2:
				System.out.println("Enter ID");
				int UpdateId=sc.nextInt();
				sc.nextLine();
				System.out.println("New Dept");
				String newDept=sc.nextLine();
				dt.Update(UpdateId, newDept);
				
				break;
			case 3:
				System.out.println("Enter ID");
				int removeId=sc.nextInt();
				sc.nextLine();
				dt.Remove(removeId);
				break;
			case 4:
				dt.Displayall();
				break;
			case 5:
				System.out.println("Exit");
				sc.close();
			default:
				System.out.println("Invalid choice");
			}
		
		
		}
		
	}

}
