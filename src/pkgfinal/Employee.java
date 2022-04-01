package pkgfinal;

public class Employee {
    private int numb;
    private String firstName;
    private String lastName;
    private String dept;
    private int hrsWorked;
    private char type;

    public Employee() {
    }

    public Employee(int numb, String firstName, String lastName, String dept, int hrsWorked, char type) {
        this.numb = numb;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
        this.hrsWorked = hrsWorked;
        this.type = type;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getHrsWorked() {
        return hrsWorked;
    }

    public void setHrsWorked(int hrsWorked) {
        this.hrsWorked = hrsWorked;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee{" + "numb=" + numb + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept + ", hrsWorked=" + hrsWorked + ", type=" + type + '}';
    }
    
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}
