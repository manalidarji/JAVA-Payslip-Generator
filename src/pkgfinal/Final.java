//117430215
package pkgfinal;

import java.io.IOException;
import java.util.ArrayList;

public class Final {
    public static void main(String[] args) {
        //ConsoleInterface Object
        ConsoleInterface CI = new ConsoleInterface();
        
        //all pay Slips
        ArrayList<EmployeePaySlip> allEmpsPaySlip = new ArrayList();
        allEmpsPaySlip = CI.createAllEmpsPaySlip();
        
        try {
            //print all employees pay slip & final pay slips report
            CI.printPaySlipsReport(allEmpsPaySlip);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
//117430215