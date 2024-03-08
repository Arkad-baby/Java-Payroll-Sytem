import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
   public abstract double calculalteSalary();
   @Override
   public String toString() {
       return "Employee [name=" + name + ", id=" + id + ", salary=" + calculalteSalary() + "]";
   }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    FullTimeEmployee(String name,int id,double monthlySalary){
        super(name, id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculalteSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private int workedHrs;

public PartTimeEmployee(String name,int id,double hourlyRate,int workedHrs){
    super(name, id);
    this.hourlyRate=hourlyRate;
    this.workedHrs=workedHrs;
}

    @Override
    public double calculalteSalary(){
        return hourlyRate*workedHrs;
    }
    
}

class PayRoll{
    private ArrayList<Employee> employeeList;

    public PayRoll(){
        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
         Employee employeeToRemove=null;
         for (Employee employee : employeeList) {
           if( employee.getId()==id){
            employeeToRemove=employee;
            break;
           }
         }
         if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);

         }
    }

    public void displayEmployee(){
        System.out.println("List of employees in the company:");
        for (Employee employee : employeeList) {
            // System.out.println( "name:" + employee.getName() + " salary:" + employee.calculalteSalary() );
            System.out.println(employee.toString());
        }
    }
}

public class PayRollSystem {
    public static void main(String[] args) {
        FullTimeEmployee full_emp1=new FullTimeEmployee("Kumar", 1, 50000);
        PartTimeEmployee part_emp1=new PartTimeEmployee("Vikas",2,100,50);
        PayRoll pr=new PayRoll();
        pr.addEmployee(full_emp1);
        pr.addEmployee(part_emp1);
        pr.displayEmployee();
        pr.removeEmployee(2);
        pr.displayEmployee();

    }
    
}
