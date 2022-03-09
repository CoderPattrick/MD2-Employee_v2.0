package model.employee;

public class Leader extends absLeader{
    public Leader(String id, String name, String age, String mail, double baseSalary) {
        super(id, name, age, mail, baseSalary);
    }

    public Leader() {
    }

    @Override
    public double getSalary() {
        return getBaseSalary()+getBONUS_LEADER();
    }

}
