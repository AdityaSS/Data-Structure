package Datastructure;

public class Employee_main {

	public static void main(String[] args) {
		Employee[] emp = new Employee[5];
		emp[0] =new Employee(10001,"A","S");
		emp[1] =new Employee(10002,"B","S");
		emp[2] =new Employee(10003,"C","S");
		emp[3] =new Employee(10004,"D","S");
		emp[4] =new Employee(10005,"E","S");
		
		Comparable_Insertionsort.InsertionSort(emp);
		
		for(int i = 0;i<emp.length;i++){
			System.out.println(emp[i]);
		}
	}

}
