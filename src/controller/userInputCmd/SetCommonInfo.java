package controller.userInputCmd;

import model.employee.Employee;
import controller.getCheckedUserInput.EmpGetterChecked;
import java.util.Scanner;

public class SetCommonInfo {
    private EmpGetterChecked getter = new EmpGetterChecked();
    Employee emp;
    public SetCommonInfo(Employee e) {
        emp = e;
    }
    void setCommonInfo(){
        System.out.print("Enter Id: ");
        String id = getter.getIdByInput();
        System.out.print("Enter name: ");
        String name = getter.getNameByInput();
        System.out.print("Enter age: ");
        String age = getter.getAgeByInput();
        System.out.print("Enter mail: ");
        String mail = getter.getMailByInput();
        emp.setId(id);
        emp.setName(name);
        emp.setAge(age);
        emp.setMail(mail);
    }
}
