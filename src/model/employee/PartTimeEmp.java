package model.employee;

public class PartTimeEmp extends absPartTimeEmp{
    public PartTimeEmp(String id, String name, String age, String mail, double workHour) {
        super(id, name, age, mail, workHour);
    }

    public PartTimeEmp() {
    }

    @Override
    public double getSalary() {
        return getWorkHour()*getSALARY_PER_HOUR();
    }
}
