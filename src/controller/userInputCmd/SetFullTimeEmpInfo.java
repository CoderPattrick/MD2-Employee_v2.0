package controller.userInputCmd;
import controller.getCheckedUserInput.EmpGetterChecked;
import model.employee.FullTimeEmp;
import java.util.Scanner;

public class SetFullTimeEmpInfo implements InputCmd {
    SetCommonInfo commonSetter;
    FullTimeEmp emp;

    public SetFullTimeEmpInfo(FullTimeEmp emp){
        this.emp=emp;
        commonSetter = new SetCommonInfo(emp);
    }
    private void setFullTimeOnlyInfo(){
        System.out.print("Input Base-Salary: ");
        double base = getter.getBaseByInput();
        System.out.print("Input bonus: ");
        double bonus = getter.getBonusByInput();
        System.out.print("Input minus: ");
        double minus = getter.getMinusByInput();

        emp.setBonus(bonus);
        emp.setMinus(minus);
        emp.setBaseSalary(base);
    }

    @Override
    public void exe() {
        commonSetter.setCommonInfo();
        setFullTimeOnlyInfo();
    }
}
