import java.util.*;

class Vehicle{
	String make;
	String model;
	int year;
	
	public String getmake() {
		return make;
	}
	public String getmodel() {
		return model;
	}
	public int getyear() {
		return year;
	}
	public void setmake(String make) {
		this.make=make;
	}
	public void setmodel(String model) {
		this.model=model;
	}
	public void setyear(int year) {
		this.year=year;
	}
	Vehicle(String make,String model,int year){
		this.make=make;
		this.model=model;
		this.year=year;
	}
	Vehicle(String make,String model){
		this.make=make;
		this.model=model;
	
	}
	void display() {
		System.out.println("Model:" + model+ "Make"+ make+ "Year:" +year);
	}
}

class Car extends Vehicle{
	int numberOfDoors;
	Car(String make,String model,int year,int numberOfDoors){
		super(make,model,year);
		this.numberOfDoors=numberOfDoors;
	}
	Car(String make,String model){
		super(make,model);
	}
	void display() {
		System.out.println("Model:"+ getmodel()+ "Make:" +getmake() +"Year:" + getyear()+ "Door" + numberOfDoors);
	}
}

public class VehicleQue {
	public static void main(String []args) {
		Vehicle vl=new Vehicle("ford","Figo",2000);
		vl.display();
		
		Car cr=new Car("ford","Figo",2000,4);
		cr.display();
		
		Car cr1=new Car("ford","Figo");
		cr1.display();
	}

}
