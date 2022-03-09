package model.employee;

public abstract class absPartTimeEmp extends Employee{
    private final double SALARY_PER_HOUR = 50;
    private double workHour;

    public absPartTimeEmp() {
    }

    public absPartTimeEmp(String id, String name, String age, String mail, double workHour) {
        super(id, name, age, mail);
        this.workHour = workHour;
    }

    public double getSALARY_PER_HOUR() {
        return SALARY_PER_HOUR;
    }

    @Override
    public String toString() {
        return "PartTimeEmp{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age='" + getAge() + '\'' +
                ", mail='" + getMail() + '\'' +
                ", SALARY_PER_HOUR=" + SALARY_PER_HOUR +
                ", workHour=" + workHour +
                '}';
    }

    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }
}
