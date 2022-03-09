package controller.userInputCmd;
import model.employee.PartTimeEmp;
import java.util.Scanner;

public class SetPartTimeEmpInfo implements InputCmd {
    SetCommonInfo commonSetter;
    PartTimeEmp emp;

    public SetPartTimeEmpInfo(PartTimeEmp emp){
        this.emp=emp;
        commonSetter = new SetCommonInfo(emp);
    }
    private void setPartTimeOnlyInfo(){
        System.out.print("Input Work-hour: ");
        double wh= getter.getWorkHourByInput();
        emp.setWorkHour(wh);
    }
    @Override
    public void exe() {
        commonSetter.setCommonInfo();
        setPartTimeOnlyInfo();
    }
}
