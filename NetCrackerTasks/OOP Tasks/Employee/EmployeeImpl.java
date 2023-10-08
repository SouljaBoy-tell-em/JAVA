public class EmployeeImpl implements Employee{
    private String firstName;
    private String lastName;
    private int salary;
    private Employee manager;

    public EmployeeImpl() {
        this.salary = 1000;
        this.manager = null;
    }
    public EmployeeImpl(String firstName, String lastName, Employee manager) {

        this.firstName = firstName;
        this.lastName  =  lastName;
        this.salary    =      1000;
        this.manager   =   manager;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary += value;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void setManager(Employee manager) {
        this.manager= manager;
    }

    @Override
    public String getManagerName() {

        if(manager == null)
            return "No manager";
        return manager.getFullName();
    }

    public Employee getManager() {
        return manager;
    }

    @Override
    public Employee getTopManager() {

        if(manager == null)
            return this;
        return manager.getTopManager();
    }
}
