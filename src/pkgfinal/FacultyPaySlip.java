package pkgfinal;

public class FacultyPaySlip extends EmployeePaySlip {
    private double rateOfPay;
    private double teachingAllowance;

    public FacultyPaySlip() {
    }

    public FacultyPaySlip(double rateOfPay, double teachingAllowance) {
        this.rateOfPay = rateOfPay;
        this.teachingAllowance = teachingAllowance;
    }
    
    public FacultyPaySlip(double rateOfPay, double teachingAllowance, Employee emp) {
        super(emp);
        this.rateOfPay = rateOfPay;
        this.teachingAllowance = teachingAllowance;
    }

    public FacultyPaySlip(double rateOfPay, double teachingAllowance, Employee emp, double grossSalary, double deductions, double netSalary) {
        super(emp, grossSalary, deductions, netSalary);
        this.rateOfPay = rateOfPay;
        this.teachingAllowance = teachingAllowance;
    }
    

    public double getRateOfPay() {
        return rateOfPay;
    }

    public void setRateOfPay(double rateOfPay) {
        this.rateOfPay = rateOfPay;
    }

    public double getTeachingAllowance() {
        return teachingAllowance;
    }

    public void setTeachingAllowance(double teachingAllowance) {
        this.teachingAllowance = teachingAllowance;
    }

    @Override
    public String toString() {
        return "FacultyPaySlip{Employee=" + super.getEmp() + ", rateOfPay=" + rateOfPay + ", teachingAllowance=" + teachingAllowance + '}';
    }

    @Override
    public double calcGrossSalary() {
        double grossSal = (super.getEmp().getHrsWorked() * this.rateOfPay) + this.teachingAllowance;
        super.setGrossSalary(grossSal);
        return grossSal;
    }    
}
