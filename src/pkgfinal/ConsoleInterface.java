//117430215
package pkgfinal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInterface {
    private static Scanner READ = new Scanner(System.in);

    public ConsoleInterface() {
    } 
    
    //for handling curreny format
    public String getMoneyFormat(double number){
        return String.format("$%,.2f", number);
    }
    
    //generic function to get valid positive integer from the user
    public int getValidIntFromUser(String printMessage) {
        int validNumb = -1;
        boolean invalidNumbChoice = true;

        do {
            try {
                System.out.println(printMessage);
                validNumb = READ.nextInt();
                if (validNumb <= 0) {
                    throw new PositiveIntegerException("Invalid Input, number can't be less or equal to zero(0)\n");
                }
                invalidNumbChoice = false;
            } catch (InputMismatchException ex) {
                System.out.println("Input Mismatch\n");
                READ.next();
            }catch (PositiveIntegerException ex) {
                System.out.println(ex.getMessage());
            }catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (invalidNumbChoice);

        return validNumb;
    }
    
    public ArrayList<EmployeePaySlip> createAllEmpsPaySlip(){
        ArrayList<EmployeePaySlip> allEmpsPaySlip = new ArrayList();
        
        System.out.println("**** Welcome to Pay Slip Generation App for ABC College ****\n");
        int numOfEmployees = getValidIntFromUser("Enter the number of Employees for whom you wish to generate Pay Slips:");
        
        for(int i = 0; i < numOfEmployees; i++){
            Employee emp = createEmployee(); //create employee obj
            allEmpsPaySlip.add( createPaySlipObj(emp) ); //create pay slip obj
        }
        
        System.out.println("\n* That's it! We have all the data needed!\n"
                + "Let's generate Pay Slips for your employees! *\n");
        
        return allEmpsPaySlip;
    }
    
    public Employee createEmployee(){
        Employee emp = null;  
        
        System.out.println("\n** Enter Details for new Employee **\n");
        int empNumb = getValidIntFromUser("Enter Employee's Number:");
        System.out.println("Enter Employee's First Name:");
        String fName = READ.next();
        System.out.println("Enter Employee's Last Name:");
        String lName = READ.next();
        System.out.println("Enter Employee's Department:");
        String dept = READ.next();
        int hrsWorked = getValidIntFromUser("Enter total number of hours worked by the employee this month:");
        
        //get valid employee type until user enters correct value
        char type = 'Z';
        boolean invalidTypeChoice = true;
        do{
            System.out.println("Enter Employee's Type:\n"
                    + "Enter ‘F’ or ‘f’ for Faculty OR\n"
                    + "Enter ‘N’ or ‘n’ for Non Faculty Employees:");
            type = Character.toUpperCase(READ.next().charAt(0));
            
            if( type == 'F' || type == 'N'){
                invalidTypeChoice = false;
            }else{
                System.out.println("Invalid Employee Type\n");
            }
        }while(invalidTypeChoice);
        
        emp = new Employee(empNumb, fName, lName, dept, hrsWorked, type);
 
        return emp;
    }   
    
    public EmployeePaySlip createPaySlipObj(Employee emp){
        EmployeePaySlip paySlip = null;
        char empType = emp.getType();
        
        if( empType == 'F'){
            paySlip = createFacultyPaySlipObj(emp); //create FacultyPaySlip obj
        }else if( empType == 'N'){
            paySlip = createNonFacultyPaySlipObj(emp); //create NonFacultyPaySlip obj
        }
        return paySlip;
    }
    
    public FacultyPaySlip createFacultyPaySlipObj(Employee emp){
        System.out.println("\n** For a Faculty Employee, we need to know their Degree **\n");
        FacultyPaySlip fPaySlip = null;
        double rateOfPay, teachingAllowance;
        
        //get valid Faculty Degree Value until user enters correct value
        char degree = 'Z';
        boolean invalidDegreeChoice = true;
        do{
            System.out.println("Enter Faculty's Degree:\n"
                    + "Enter ‘M’ or ‘m’ for Master’s Degree OR\n"
                    + "Enter ‘B’ or ‘b’ for Bachelor’s Degree:");
            degree = Character.toUpperCase(READ.next().charAt(0));
            
            if( degree == 'M' || degree == 'B'){
                invalidDegreeChoice = false;
            }else{
                System.out.println("Invalid Faculty Degree Value\n");
            }
        }while(invalidDegreeChoice);
        
        //assigning rateOfPay, teachingAllowance as per Degree
        switch (degree) {
            case 'M':
                rateOfPay = 175;
                teachingAllowance = 1500;                
                break;
                
            case 'B':
                rateOfPay = 100;
                teachingAllowance = 600;
                break;
                
            default:
                rateOfPay = 0;
                teachingAllowance = 0;
                break;
        }
        
        System.out.println("\n** For chosen degree: " + degree +", below values will be used **");
        System.out.println("Rate of pay: " + getMoneyFormat(rateOfPay));
        System.out.println("Teaching Allowance: " + getMoneyFormat(teachingAllowance) + "\n");
        
        //create FacultyPaySlip object
        fPaySlip = new FacultyPaySlip(rateOfPay, teachingAllowance, emp);
        
        return fPaySlip;
    }
    
    public NonFacultyPaySlip createNonFacultyPaySlipObj(Employee emp){
        System.out.println("\n** For a Non-Faculty Employee, we need to know their Monthly Fixed Salary **\n");
        NonFacultyPaySlip nPaySlip = null;        
        double fixedSal = -1;
        boolean invalidChoice = true;

        //get valid Non-Faculty Employee's Monthly Fixed Salary until user enters correct value
        do {
            try {
                System.out.println("Enter Non-Faculty Employee's Monthly Fixed Salary:");
                fixedSal = READ.nextDouble();
                if (fixedSal < 0) {
                    throw new Exception("Invalid Input, Fixed Salary can't be negactive\n");
                }
                invalidChoice = false;
            } catch (InputMismatchException ex) {
                System.out.println("Input Mismatch\n");
                READ.next();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (invalidChoice);
        
        //create NonFacultyPaySlip object
        nPaySlip = new NonFacultyPaySlip(fixedSal, emp);
        
        return nPaySlip;
    }
    
    public void printPaySlipsReport(ArrayList<EmployeePaySlip> allEmpsPaySlip) throws IOException{
        System.out.println("Generating Pay Slips....\n");
        //java objects for writing into a file
        FileWriter file = new FileWriter("paySlips.txt");
        BufferedWriter output = new BufferedWriter(file);
        
        int totalEmps = allEmpsPaySlip.size();
        int facultyCount = 0, nonFacultyCount = 0;
        char empType = 'Z';
        
        output.write("********** Pay Slips for ABC College Employees **********\n");
        
        for(int j = 0; j < totalEmps; j++){
            //get counts of faculty & non-Faculty  employees
            empType = allEmpsPaySlip.get(j).getEmp().getType();
            if( empType == 'F'){
                facultyCount++;
            }else if( empType == 'N'){
                nonFacultyCount++;
            }
            //print pay slip of an employee
            printPaySlip( output, allEmpsPaySlip.get(j) );
        }
        
        //print final pay slips REPORT
        output.write("\n*************************************");
        output.write("\n***** PAY SLIPS REPORT *****");
        output.write("\nTotal no. of processed Employees: " + totalEmps);
        output.write("\n- Total no. of processed Faculty Employees: " + facultyCount);
        output.write("\n- Total no. of processed Non-Faculty Employees: " + nonFacultyCount);
        output.write("\n*************************************\n");        
        output.close();
        System.out.println("Pay Slips & Report has been generated & saved for you!\n"
                + "Please check 'paySlips.txt' file for the detailed report.\n"
                + "Thank you for using our app!\n");        
    }
    
    public void printPaySlip(BufferedWriter output, EmployeePaySlip paySlip) throws IOException{        
        output.write("\n*************************************");
        output.write("\n***** PAY SLIP *****");
        printEmployeeDetails(output, paySlip.getEmp());
        output.write("\n*******************");
        printSalaryDetails(output, paySlip);
        output.write("\n*************************************\n");     
    }
    
    public void printEmployeeDetails(BufferedWriter output, Employee emp) throws IOException{
        String empType;        
        output.write("\nEmployee Number: " + emp.getNumb());
        output.write("\nName: " + emp.getFullName());
        output.write("\nDepartment: " + emp.getDept());
        output.write("\nHours Worked: " + emp.getHrsWorked());

        switch (emp.getType()) {
            case 'F':
                empType = emp.getType() + "/Faculty";
                break;
            case 'N':
                empType = emp.getType() + "/Non-Faculty";
                break;          
            default:
                empType = "N/A";
                break;
        }
        output.write("\nEmployee Type: " + empType);
    }
    
    public void printSalaryDetails(BufferedWriter output, EmployeePaySlip paySlip) throws IOException{            
        output.write("\nGross Salary: " + getMoneyFormat(paySlip.calcGrossSalary()));
        output.write("\nDeductions: " + getMoneyFormat(paySlip.calcDeductions()));
        output.write("\nNet Salary: " + getMoneyFormat(paySlip.calcNetSalary()));
    }
}

//117430215