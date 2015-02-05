package lab1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab your challenge is to fix the code in both classes to use proper
 * encapsulation and the other best practices as explained by your instructor.
 *
 * @author Jim Lombardo, WCTC Instructor
 * @version 1.01
 */
public class Employee {

    private String firstName;
    private String lastName;
    private String ssn;
    private Date birthDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date currentDate;
    private String fmtDate;

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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Employee() {
        currentDate = new Date();
    }

    private String getFmtDate() {
        return fmtDate;
    }

    private void setFmtDate() {

        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(currentDate);
        this.fmtDate = fmtDate;
    }

    public void becomeEmployee() {
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
    }

    // Assume this must be performed first
    private void meetWithHrForBenefitAndSalryInfo() {
        getFmtDate();
        System.out.println("Met with Hr on " + fmtDate);
        metWithHr = true;
    }

    // Assume this is must be performed second
    private void meetDepartmentStaff() {
        getFmtDate();
        if (metWithHr) {
            System.out.println("Met with Dept. Staff on " + fmtDate);
            metDeptStaff = true;
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    private void reviewDeptPolicies() {
        getFmtDate();
        if (metWithHr && metDeptStaff) {
            System.out.println("Reviewed Dept. Policies on " + fmtDate);
            reviewedDeptPolicies = true;
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    private void moveIntoCubicle(String cubeId) {
        getFmtDate();
        if (metWithHr && metDeptStaff && reviewedDeptPolicies) {
            System.out.println("Moved into cube on " + fmtDate);
            this.cubeId = cubeId;
            this.movedIn = true;
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }
    }


    public String getStatus() {
        if(metWithHr && metDeptStaff
           && reviewedDeptPolicies && movedIn) {
            return "Orientation is completed on: " + fmtDate;
        } else {
            return fmtDate + ": Orientation in progress...";
        }
    }
}
