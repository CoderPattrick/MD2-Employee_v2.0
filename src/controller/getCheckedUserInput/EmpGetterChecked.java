package controller.getCheckedUserInput;
import controller.empManager.EmpManager;
import model.employee.*;
import model.regexEmp.Regex;
import storage.IOManager.IOManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmpGetterChecked {
    private static final EmpManager EMP_MANAGER = new EmpManager();
    private static final Regex regexTool = new Regex();
    private static final IOManager IOTool = new IOManager();
    private static ArrayList<Employee> savedList = IOManager.savedList;

    public String getIdByInput(){
        Scanner inputID = new Scanner(System.in);
        String id = inputID.nextLine();
        if (EMP_MANAGER.indexOfEmpById(id)!=-1){
            System.err.print("Id exists, please try again: ");
            return getIdByInput();
        }
        if (!regexTool.isValidId(id)){
            System.err.print("Id is invalid! Try again: ");
            return getIdByInput();
        }
        return id;
    }
    public String getNameByInput(){
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (!regexTool.isValidName(name)){
            System.err.print("Name is invalid! Try again: ");
            return getNameByInput();
        }
        return name;
    }
    public String getAgeByInput(){
        Scanner input = new Scanner(System.in);
        String age;
        age = input.nextLine();
        if (!regexTool.isValidAge(age+"")){
            System.err.print("Age is invalid! Try again: ");
            return getAgeByInput();
        }
        return age;
    }
    public String getMailByInput(){
        Scanner input = new Scanner(System.in);
        String mail = input.nextLine();
        if (!regexTool.isValidMail(mail+"")){
            System.err.print("Mail is invalid! Try again: ");
            return getMailByInput();
        }
        return mail;
    }
    public double getBonusByInput(){
        Scanner input = new Scanner(System.in);
        long bonus;
        try{
            bonus = input.nextLong();
        }
        catch (InputMismatchException e){
            System.err.print("Bonus is in valid! Try again: ");
            return getBonusByInput();
        }
        if (!regexTool.isValidBonus(bonus+"")){
            System.err.print("Bonus is in valid! Try again: ");
            return getBonusByInput();
        }
        return bonus;
    }
    public double getMinusByInput(){
        Scanner input = new Scanner(System.in);
        long minus;
        try{
            minus = input.nextLong();
        }
        catch (InputMismatchException e){
            System.err.print("Minus is in valid! Try again: ");
            return getMinusByInput();
        }
        if (!regexTool.isValidMinus(minus+"")){
            System.err.print("Minus is in valid! Try again: ");
            return getMinusByInput();
        }
        return minus;
    }
    public double getBaseByInput(){
        Scanner input = new Scanner(System.in);
        long base;
        try{
            base = input.nextLong();
        }
        catch (InputMismatchException e){
            System.err.print("Base-Salary is in valid! Try again: ");
            return getBaseByInput();
        }
        if (!regexTool.isValidBase(base+"")){
            System.err.print("Base-Salary is in valid! Try again: ");
            return getBaseByInput();
        }
        return base;
    }
    public double getWorkHourByInput(){
        Scanner input = new Scanner(System.in);
        double workHour;
        try{
            workHour = input.nextDouble();
        }
        catch (InputMismatchException e){
            System.err.print("Work-hour is in valid! Try again: ");
            return getWorkHourByInput();
        }
        if (!regexTool.isValidWorkHour(""+workHour)){
            System.err.print("Work-hour is in valid! Try again: ");
            return getWorkHourByInput();
        }
        return workHour;
    }
    //EmpType: 1-Full-time 2.Part-time 3.Leader
    public String getEmpTypeByInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("1.Full-time employee  2.Part-time employee  3.Leader");
        System.out.println("Type of employee of your choice: ");
        String choice = input.nextLine();
        switch (choice){
            case "1":
            case "2":
            case "3":
                break;
            default:
                System.err.println("Invalid input! Try again! ");
                return getEmpTypeByInput();
        }
        return choice;
    }

    public Employee getEmpByInputId(){
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        int index = EMP_MANAGER.indexOfEmpById(id);
        if(index!=-1){
            Employee emp = savedList.get(index);
            return emp;
        }
        return null;
    }

    public Employee getEmployeeByInput(int choice){
        Employee newEmployee;
        System.out.print("id: ");
        String id = getIdByInput();

        System.out.print("name: ");
        String name = getNameByInput();

        System.out.print("age: ");
        String age = getAgeByInput();

        System.out.print("email: ");
        String mail = getMailByInput();

        if(choice==1){
            System.out.print("bonus: ");
            double bonus = getBonusByInput();

            System.out.print("minus: ");
            double minus = getMinusByInput();

            System.out.print("base-salary: ");
            double base = getBaseByInput();
            newEmployee = new FullTimeEmp(id,name,age,mail,base,bonus,minus);
        }
        else if(choice==2){
            System.out.print("workHour: ");
            double workHour = getWorkHourByInput();
            newEmployee = new PartTimeEmp(id,name,age,mail,workHour);
        }
        else {
            System.out.print("base-salary: ");
            double base = getBaseByInput();
            newEmployee = new Leader(id,name,age,mail,base);
        }
        return newEmployee;
    }
}
