package ua.training.model.entity;

public class Employee {

    private int id;
    private String name;
    private int depatmentId;


    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepatmentId() {
        return depatmentId;
    }

    public void setDepatmentId(int depatmentId) {
        this.depatmentId = depatmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depatmentId=" + depatmentId +
                '}';
    }
}
