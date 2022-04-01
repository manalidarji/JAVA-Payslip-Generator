//117430215
package pkgfinal;

public abstract class EmployeePaySlip {
    private Employee emp;
    private double grossSalary;
    private double deductions;
    private double netSalary;

    public EmployeePaySlip() {
    }

    public EmployeePaySlip(Employee emp) {
        this.emp = emp;
    }

    public EmployeePaySlip(Employee emp, double grossSalary, double deductions, double netSalary) {
        this.emp = emp;
        this.grossSalary = grossSalary;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "EmployeePaySlip{" + "emp=" + emp + ", grossSalary=" + grossSalary + ", deductions=" + deductions + ", netSalary=" + netSalary + '}';
    }
    
    public abstract double calcGrossSalary();
    
    public double calcDeductions(){
        //tax variables
        double incomeTaxPercentage = 0.25;
        double taxFreeAllowance = 2500;
        double taxableAmt = 0;
        //health Surcharge variables
        double healthSurchargeLimit = 3000;
        double healthSurcharge;    
        
        //calculate taxable income
        taxableAmt = this.grossSalary - taxFreeAllowance;
        
        //check taxable income
        if( taxableAmt <= 0 ){
            this.deductions = 0;
            return this.deductions;
        }
   
        //assigning healthSurcharge value as per the limit
        if( this.grossSalary > healthSurchargeLimit ){
            healthSurcharge = 33;
        }else if( this.grossSalary <= healthSurchargeLimit ){
            healthSurcharge = 19.20;
        }else{
            healthSurcharge = 0;
        }
        
        //calculate total deductions
        this.deductions = ( incomeTaxPercentage * taxableAmt ) + healthSurcharge;     
        return this.deductions;
    }
    
    public double calcNetSalary(){
        this.netSalary = this.grossSalary - this.deductions;
        return this.netSalary;
    }   
}

//117430215