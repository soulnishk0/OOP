public class EmployeeFactory {
    static String[] namesWomen = {"Nika", "Anya", "Lina", "Sveta"};
    static String[] namesMan = {"Boris", "Nikolay", "Tom", "Jon"};

     static int rand(int min, int max) {
        int delta = max - min;

        double rand = Math.random();
        return (int) (rand * delta + min);
    }

    static String generateName(char gender){
        int rand = rand(0, 4);
        System.out.println(rand);
        if (gender =='m') return namesMan[rand];
        else return namesWomen[rand];
    }

    static char generateGender(){
        int rand = rand(0, 2);
        System.out.println(rand);
        if (rand == 0) return 'm';
        else return 'w';
    }

    static int generateSalary(){
        int rand = rand(1000, 5000);
        return rand;
    }

    static int generateFindBugs(){
        int rand = rand(0, 10);
        return rand;
    }

    static int generateDefaultBugRate(){
        int rand = rand(100, 400);
        return rand;
    }

    static int generateAge(){
        int rand = rand(20, 50);
        return rand;
    }


    Employee[] generateEmployees(int size){
        Employee[] employees = new Employee[size];
        for (int i = 0; i < size; i++) {
            char gender = generateGender();
            String name = generateName(gender);
            int salary = generateSalary();
            int fixedBugs = generateFindBugs();
            int defaultBugRate = generateDefaultBugRate();
            int age = generateAge();
            Employee employee = new Employee((int) i + 1, name, age, salary, gender, fixedBugs, defaultBugRate);
            employees[i] = employee;
        }
        return employees;
    }
}
