package model;

public class Student {
    private String ID;
    private String name;
    private int age;

    private String gender;

    private String address;

    private double GPA;

    public Student(String ID) {
    }

    public Student(String ID, String name, int age, String gender, String address, double GPA) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.GPA = GPA;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", GPA=" + GPA +
                '}';
    }

    public String writeToFile() {
        return ID + "," + name + "," + age + "," + gender + "," + address + "," + GPA;
    }

}
