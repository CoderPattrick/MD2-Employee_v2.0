package view;

import controller.empManager.EmpManager;
import controller.userInputCmd.*;
import controller.getCheckedUserInput.EmpGetterChecked;
import model.employee.*;
import storage.IOManager.IOManager;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerProxy {
    private static final EmpGetterChecked getter = new EmpGetterChecked();
    private static final IOManager IOtool = new IOManager();
    private static final ArrayList<Employee> savedList = IOManager.savedList;
    private EmpManager empManager;

    public ControllerProxy(){
        empManager = new EmpManager();
    }
    public void addEmp(){
        String choice = getter.getEmpTypeByInput();
        Employee emp = null;
        InputCmd cmd;
        switch (choice){
            case "1":
                emp = new FullTimeEmp();
                cmd = new SetFullTimeEmpInfo((FullTimeEmp) emp);
                cmd.exe();
                break;
            case "2":
                emp = new PartTimeEmp();
                cmd = new SetPartTimeEmpInfo((PartTimeEmp) emp);
                cmd.exe();
                break;
            case "3":
                emp = new Leader();
                cmd = new SetLeaderInfo((Leader) emp);
                cmd.exe();
        }
        savedList.add(emp);
        IOtool.writeFile(savedList);
    }//done method Add!
    public void removeEmpById(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input the ID of employee you wanna remove: ");
        String id = input.nextLine();
        int index = empManager.indexOfEmpById(id);
        if(index==-1){
            System.err.println("No employee with id " + id);
            return;
        }
        Employee emp = savedList.get(index);
        System.out.println(emp);
        System.out.println("\n1. OK  2.Cancel");
        System.out.print("Confirm removing employee: ");
        Scanner inputCf = new Scanner(System.in);
        String choice = inputCf.nextLine();
        if(choice.equals("1")) {
            empManager.removeEmp(emp);
            IOtool.writeFile(savedList);
        }
    }//done method Remove!
    public void setEmpIn4(){
        Employee emp = empManager.getEmpById();
        String empType = getter.getEmpTypeByInput();
        String id = getter.getIdByInput();
        String name = getter.getNameByInput();
        String age = getter.getAgeByInput();
        String mail = getter.getMailByInput();
        empManager.setCommonIn4(emp,id,name,age,mail);
        switch (empType){
            case "1":
            case "2":
            case "3":
        }
    }

    public void displayCompletion(){
        System.out.println("Complete!");
    }
    public void displayMenu(){
        System.out.println("Menu");
        System.out.println("1. Display all employee.");
        System.out.println("2. Add an employee.");
        System.out.println("3. Remove an employee by ID.");
        System.out.println("4. Set employee information by ID.");
        System.out.println("5. Display employees with lower salary than average.");
        System.out.println("6. All Part-time employees'  salary.");
        System.out.println("7. Search employee(s)");
        System.out.println("20. Exit program.\n");
        System.out.print("Your choice: ");
    }
    public void displaySpecifiedList(ArrayList<Employee> list){
        for (Employee e: list
        ) {
            System.out.println(e);
        }
    }
    public void displayAllList(){
        for (Employee e:savedList
        ) {
            System.out.println(e);
        }
    }
    public void confirmNextAction(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted!");
        }
        System.out.println("\nPress Enter to get back to Menu");
        Scanner input = new Scanner(System.in);
        String threadBlock = input.nextLine();
    }

}
