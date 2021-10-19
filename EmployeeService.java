public class EmployeeService {
    Employee[] employeeAll;

    public EmployeeService(Employee[] employeeAll) {
        this.employeeAll = employeeAll;
    }

    void employeePrint(){
        for (Employee employee: employeeAll) {
            if (employee != null) {
                employee.print();
                System.out.println();
            }
        }
    }

    int calculateSalaryAndBonus(){
        int moneyForSalaryAndBonus = 0;
        for (Employee employee: employeeAll) {
            moneyForSalaryAndBonus += employee.salary;
            moneyForSalaryAndBonus += employee.defaultBugRate * employee.fixedBugs;
        }
        return moneyForSalaryAndBonus;
    }

    Employee getById(long id){
        for (Employee employee: employeeAll) {
            if (employee.id == id) return employee;
        }
        return null;
    }

    Employee[] getByName(String name){
        Employee[] employeesArrayByName  = new Employee[employeeAll.length];
        int countEmployeesByName = 0;
        for (Employee employee: employeeAll) {
            if (employee.name.equals(name)) employeesArrayByName[countEmployeesByName++] = employee;
        }
        Employee[] employeesArrayByNameResult  = new Employee[countEmployeesByName];
        for (int i = 0; i < countEmployeesByName; i++) {
            employeesArrayByNameResult[i] = employeesArrayByName[i];
        }
        return employeesArrayByNameResult;
    }

    Employee[] sortByName() {
        Employee[] employees = employeeAll.clone();
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                Employee temp = employees[i];
                if (temp.name.compareTo(employees[j].name) < 0){
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        return employees;
    }

    Employee[] sortByNameAndSalary() {
        Employee[] employees = employeeAll.clone();
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                Employee template = employees[i];
                if (template.name.equals(employees[j].name)){
                    if (template.salary > employees[j].salary){
                        employees[i] = employees[j];
                        employees[j] = template;
                        break;
                    }
                }
                if (template.name.compareTo(employees[j].name) < 0){
                    employees[i] = employees[j];
                    employees[j] = template;
                }
            }
        }
        return employees;
    }

    Employee edit(Employee employeeNew) {
        if (employeeNew.id > employeeAll.length){
            return null;
        }
        Employee employeeCurrent = getById(employeeNew.id);
        Employee employeeUpdated = new Employee(employeeNew.id, employeeNew.name, employeeNew.age, employeeNew.salary, employeeNew.gender, employeeNew.fixedBugs, employeeNew.defaultBugRate);
        employeeAll[employeeNew.id - 1] = employeeUpdated;
        return employeeCurrent;
    }

    Employee remove(int id){
        Employee employee = getById(id);
        Employee[] newEmployeeAll = new Employee[this.employeeAll.length - 1];
        int countNewEmployeeAll = 0;
        for (int i = 0; i < this.employeeAll.length; i++) {
            if (this.employeeAll[i].id != id) {
                newEmployeeAll[countNewEmployeeAll++] = this.employeeAll[i];
            }
        }
        this.employeeAll = newEmployeeAll;
        return employee;
    }
}
