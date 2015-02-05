package lab1;

import java.util.Date;
import java.text.SimpleDateFormat;

public class HrManager {

    private Employee employee = new Employee();
    
    public void hire(String firstName, String lastName, String ssn){

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSsn(ssn);
        
        employee.becomeEmployee();

        System.out.println("The employee's status is: " + employee.getStatus());
    }
        

}