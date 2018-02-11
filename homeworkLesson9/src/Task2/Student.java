package Task2;

public class Student{
    private String name;
    private String surname;
    private int age;
    private int markAverage;

    public Student(String name, String surname, int age, int markAverage) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.markAverage = markAverage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", markAverage=" + markAverage +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getMarkAverage() {
        return markAverage;
    }

}
