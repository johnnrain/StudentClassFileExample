
public class Student {
	private int stuNumber;
	private String stuFName;
	private String stuLName;
	private double stuGPA;
	
	public void setStuNumber(int num) {
		stuNumber = num;
	}
	
	public void setStuFName(String name) {
		stuFName = name;
	}
	
	public void setStuLName(String name) {
		stuLName = name;
	}
	
	public void setStuGPA(double gpa) {
		stuGPA = gpa;
	}	
	
	public int getStuNumber() {
		return stuNumber;
	}
	
	public String getStuFName() {
		return stuFName;
	}
	
	public String getStuLName() {
		return stuLName;
	}
	
	public double getStuGPA() {
		return stuGPA;
	}
	
	public String getFileData() {
		return "Student Information: " + getStuNumber() + " | " + getStuLName() + ", " + getStuFName() + " | " + getStuGPA();
	}
}
