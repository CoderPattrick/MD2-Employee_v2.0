package controller.userInputCmd;
import model.employee.Leader;
import java.util.Scanner;

public class SetLeaderInfo implements InputCmd {
    SetCommonInfo commonSetter;
    Leader emp;

    public SetLeaderInfo(Leader emp){
        this.emp=emp;
        commonSetter = new SetCommonInfo(emp);
    }
    private void setLeaderOnlyInfo(){
        System.out.print("Input Base-Salary: ");
        double base = getter.getBaseByInput();
        emp.setBaseSalary(base);
    }

    @Override
    public void exe() {
        commonSetter.setCommonInfo();
        setLeaderOnlyInfo();
    }
}
