//117430215
package pkgfinal;

public class NonFacultyPaySlip extends EmployeePaySlip {
    private double fixedGrossSal;

    public NonFacultyPaySlip() {
    }

    public NonFacultyPaySlip(double fixedGrossSal) {
        this.fixedGrossSal = fixedGrossSal;
    }
    
    public NonFacultyPaySlip(double fixedGrossSal, Employee emp) {
        super(emp);
        this.fixedGrossSal = fixedGrossSal;
    }

    public NonFacultyPaySlip(double fixedGrossSal, Employee emp, double grossSalary, double deductions, double netSalary) {
        super(emp, grossSalary, deductions, netSalary);
        this.fixedGrossSal = fixedGrossSal;
    }

    public double getFixedGrossSal() {
        return fixedGrossSal;
    }

    public void setFixedGrossSal(double fixedGrossSal) {
        this.fixedGrossSal = fixedGrossSal;
    }

    @Override
    public String toString() {
        return "NonFacultyPaySlip{Employee=" + super.getEmp() + ", fixedGrossSal=" + fixedGrossSal + '}';
    }
    
    // 117430215

    @Override
    public double calcGrossSalary() {
        int hrsWorked = super.getEmp().getHrsWorked();
        int minHrs = 160;
        double grossSal = 0;
        double empHourlyRate = this.fixedGrossSal/minHrs;
        
        if(hrsWorked < minHrs){ //only pay for worked hrs
            grossSal = empHourlyRate * hrsWorked;
        }else if(hrsWorked > minHrs){ //pay double for extra hours
            grossSal = this.fixedGrossSal + (2 * empHourlyRate * (hrsWorked - minHrs));
        }else{ //pay exact fixed salray for working minHrs
            grossSal = this.fixedGrossSal;
        }
        
        super.setGrossSalary(grossSal);
        
        return grossSal;
    }    
}

//117430215