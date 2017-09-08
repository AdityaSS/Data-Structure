package Datastructure;

public class Employee implements Comparable<Employee> {

	String name;
	String surname;
	Integer number;

	public Employee(Integer num, String fname, String lname) {
		number = num;
		name = fname;
		surname = lname;
	}

	public int getnum() {
		return number;

	}

	@Override
	public int compareTo(Employee e) {
		int result;
		Integer num = e.getnum();
        result = number.compareTo(num);
        return result;
	}
	
	public String toString(){
		String result;
		result = name + " " + surname + " " + number;
		return result;
	}

}
