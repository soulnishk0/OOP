public class Employee {
    int id;
    String name;
    int age;
    int salary;
    char gender;
    int fixedBugs;
    int defaultBugRate;

    public Employee(int id, String name, int age, int salary, char gender, int fixedBugs, int defaultBugRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.fixedBugs = fixedBugs;
        this.defaultBugRate = defaultBugRate;
    }
    public void print(){
        System.out.println("Employee:");
        System.out.print("id: " + this.id + ", ");
        System.out.print("name: " + this.name + ", ");
        System.out.print("age: " + this.age + ", ");
        System.out.print("salary: " + this.salary + ", ");
        System.out.print("gender: " + this.gender + ", ");
        System.out.print("findBugs: " + this.fixedBugs + ", ");
        System.out.print("defaultBugRate: " + this.defaultBugRate + ".");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", fixedBugs=" + fixedBugs +
                ", defaultBugRate=" + defaultBugRate +
                '}';
    }
}
