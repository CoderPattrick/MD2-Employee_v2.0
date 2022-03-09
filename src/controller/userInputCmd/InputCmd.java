package controller.userInputCmd;

import controller.getCheckedUserInput.EmpGetterChecked;
import model.employee.Employee;
import storage.IOManager.IOManager;

import java.util.ArrayList;

public interface InputCmd {
    EmpGetterChecked getter = new EmpGetterChecked();
    ArrayList<Employee> savedList = IOManager.savedList;
    void exe();
}
