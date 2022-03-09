package controller.empManager;

import controller.getCheckedUserInput.EmpGetterChecked;
import model.employee.Employee;
import model.employee.FullTimeEmp;
import model.employee.Leader;
import model.employee.PartTimeEmp;
import storage.IOManager.IOManager;

import java.util.ArrayList;

public class EmpManager {
    public static final EmpGetterChecked getter = new EmpGetterChecked();
    public static ArrayList<Employee> savedList = IOManager.savedList;

    public void addEmp(Employee employee){
        savedList.add(employee);
    }
    public void removeEmp(Employee employee){
        savedList.remove(employee);
    }
    public void setCommonIn4(Employee e,String id,String name,String age,String mail){
        e.setId(id);
        e.setName(name);
        e.setAge(age);
        e.setMail(mail);
    }
    public void setFullTimeOnlyIn4(FullTimeEmp e,double base,double bonus,double minus){
        e.setBaseSalary(base);
        e.setBonus(bonus);
        e.setMinus(minus);
    }
    public void setPartTimeOnlyIn4(PartTimeEmp e,double workHour){
        e.setWorkHour(workHour);
    }
    public void setLeaderOnlyIn4(Leader e,double base){
        e.setBaseSalary(base);
    }

    public Employee getEmpById(){
        System.out.print("Enter Id of the employee: ");
        Employee emp = getter.getEmpByInputId();
        return emp;
    }
    public int indexOfEmpById(String id){
        for (int i = 0; i < savedList.size(); i++) {
            String targetId = savedList.get(i).getId();
            if(targetId.equals(id)){
                return i;
            }
        }
        return -1;
    }
    public int indexOfEmpByName(String name){
        for (int i = 0; i < savedList.size(); i++) {
            String targetName = savedList.get(i).getName();
            if(targetName.equals(name)){
                return i;
            }
        }
        return -1;
    }
}
