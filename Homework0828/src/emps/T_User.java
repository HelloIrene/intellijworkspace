package emps;

import java.sql.Date;

public class T_User {
    public int empNo;
    public String empName;
    public String empJob;
    public Date empDate;
    public double empSal;
    public double empComm;
    public int empDepart;

    public T_User() {

    }

    public T_User(int empNo, String empName, String empJob, Date empDate,
                  double empSal, double empComm, int empDepart) {
        this.empNo = empNo;
        this.empName = empName;
        this.empJob = empJob;
        this.empDate = empDate;
        this.empSal = empSal;
        this.empComm = empComm;
        this.empDepart = empDepart;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public Date getEmpDate() {
        return empDate;
    }

    public void setEmpDate(Date empDate) {
        this.empDate = empDate;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public double getEmpComm() {
        return empComm;
    }

    public void setEmpComm(double empComm) {
        this.empComm = empComm;
    }

    public int getEmpDepart() {
        return empDepart;
    }

    public void setEmpDepart(int empDepart) {
        this.empDepart = empDepart;
    }
}
