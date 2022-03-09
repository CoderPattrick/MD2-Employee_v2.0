package model.employee;

public class FullTimeEmp extends absFullTimeEmp {
    public FullTimeEmp(String id, String name, String age, String mail, double baseSalary, double bonus, double minus) {
        super(id, name, age, mail, baseSalary, bonus, minus);
    }

    public FullTimeEmp() {
    }

    @Override
    public double getSalary() {
        double result = getBaseSalary()+getBonus()-getMinus();
        return result;
    }
}
