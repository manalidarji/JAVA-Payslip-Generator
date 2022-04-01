# JAVA-Payslip-Generator
- This project is a JAVA Console App
- It is programmed using core JAVA, using Object-Oriented Programming(OOP)
- OOP helps to keep the JAVA code DRY `Don't Repeat Yourself`, and makes the code easier to maintain, modify and debug

## Motivation
The true inspiration behind this project is the manual process of payslip generation in any start-up or small business

## About the App
- ABC College (ABCC) is a fictional Community College Located in Ontario with a
student population of approximately 5000 and a large competent workforce.
ABCC staff is divided into 2 major groups, i.e, `Faculty` and `Non-faculty` staff.
- This console app is created for Accounts clerks of this fictional college to generate MULTIPLE employees’ pay slips for A GIVEN MONTH.
- A detailed version of problem statement can be found at root level of this repo, file name: `payslip_generator_problem_statement.pdf`

## Softwares Used
- [Java Runtime Environment - 1.8.0 (JRE)](https://www.java.com/en/download/manual.jsp)
- [Java Development Kit - 17.0.2 (JDK)](https://www.oracle.com/java/technologies/downloads/)
- [Apache Netbeans - 13 - IDE](https://netbeans.apache.org/download/index.html)

## Start the App
- Install all the above mentioned softwares
- Clone the repository
- Open this project in `Apache Netbeans`
- Then open file `JAVA-Payslip-Generator\src\pkgfinal\Final.class`
- The above file contains the main JAVA function
- Click on `Run Project` or `F6` to start the game, you should be able to see initial screen as below:

```bash
**** Welcome to Pay Slip Generation App for ABC College ****

Enter the number of Employees for whom you wish to generate Pay Slips:
```

## Classes Created
- `Final` : This class contains the main class(starting point of this app)
- `ConsoleInterface` : This package handles all activities of displaying as well as accepting data from the user. It also handles printing activity of the payslips
- `Employee` : This class is uesd to store employee information like: emp numb, firstName, lastName, dept, hrsWorked, emp type
- `EmployeePaySlip` : This is an abstract class which handles calculations required for *Gross Salary, Deductions and Net Salary*. Method *calcGrossSalary()* is an abstract method inside this class
- `FacultyPaySlip` : This class generates payslip for *Faculty Members* & inherits *EmployeePaySlip class*. It also takes care about the abstract method(*calcGrossSalary*) implementation
- `NonFacultyPaySlip` : This class generates payslip for *Faculty Members* & inherits *EmployeePaySlip class*. It also takes care about the abstract method(*calcGrossSalary*) implementation
- `PositiveIntegerException` : Handles exceptions where input is not a positive integer

## Author
[Manali Darji](https://www.linkedin.com/in/manalidarji/)