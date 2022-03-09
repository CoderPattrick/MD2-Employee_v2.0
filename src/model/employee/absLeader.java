package model.employee;

public abstract class absLeader extends Employee{
    private double baseSalary;
    private final double BONUS_LEADER = 50000;
    @Override
    public String toString() {
        return "Boss{" +
                "baseSalary=" + baseSalary +
                ", bonus4lead=" + BONUS_LEADER +
                ", id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age='" + getAge() + '\'' +
                ", mail='" + getMail() + '\'' +
                '}';
    }

    public double getBONUS_LEADER() {
        return BONUS_LEADER;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public absLeader(String id, String name, String age, String mail, double baseSalary) {
        super(id, name, age, mail);
        this.baseSalary = baseSalary;
    }

    public absLeader() {
    }
}
