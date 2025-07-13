
interface DataSource {
    void execute();
}

class UpdateData implements DataSource {
    @Override
    public void execute() {
        System.out.println("Updating record in the central database...");
    }
}

class ViewData implements DataSource {
    @Override
    public void execute() {
        System.out.println("Fetching and displaying requested data...");
    }
}

class DeleteData implements DataSource {
    @Override
    public void execute() {
        System.out.println("Removing record from the archive...");
    }
}

abstract class UniversityEntity {
    protected int entityId;
    protected String name;

    public UniversityEntity(int entityId, String name) {
        this.entityId = entityId;
        this.name = name;
    }

    public int getEntityId() {
        return entityId;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();
}

abstract class Employee extends UniversityEntity {
    protected String employeeId;

    public Employee(int entityId, String name, String employeeId) {
        super(entityId, name);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String getDescription() {
        return getName() + " (Employee ID: " + employeeId + ")";
    }

    public abstract void performTask(DataSource dataSource);
}

class Administrator extends Employee {
    private String adminPassword;
    private Department managedDepartment;

    public Administrator(int entityId, String name, String employeeId, String adminPassword, Department managedDepartment) {
        super(entityId, name, employeeId);
        this.adminPassword = adminPassword;
        this.managedDepartment = managedDepartment;
    }

    public Department getManagedDepartment() {
        return managedDepartment;
    }

    @Override
    public void performTask(DataSource dataSource) {
        System.out.println("Administrator " + getName() + " is performing an operation on " + managedDepartment.getName() + " using:");
        dataSource.execute();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Administrator of " + managedDepartment.getName();
    }
}

class Student extends UniversityEntity {
    private String studentId;
    private Department enrolledDepartment;

    public Student(int entityId, String name, String studentId, Department enrolledDepartment) {
        super(entityId, name);
        this.studentId = studentId;
        this.enrolledDepartment = enrolledDepartment;
    }

    public String getStudentId() {
        return studentId;
    }

    public Department getEnrolledDepartment() {
        return enrolledDepartment;
    }

    public void viewInformation(DataSource dataSource) {
        System.out.println("Student " + getName() + " is viewing information from:");
        dataSource.execute();
    }

    @Override
    public String getDescription() {
        return getName() + " (Student ID: " + studentId + "), enrolled in " + enrolledDepartment.getName();
    }
}

class University {
    private String universityName = "University of Nairobi";
    private Department[] departments;
    private int departmentCount = 0;

    public University(int maxDepartments) {
        this.departments = new Department[maxDepartments];
    }

    public void addDepartment(Department department) {
        if (departmentCount < departments.length) {
            departments[departmentCount++] = department;
            System.out.println(department.getName() + " added to " + universityName);
        } else {
            System.out.println("Cannot add more departments, maximum capacity reached.");
        }
    }

    public Department[] getDepartments() {
        return departments;
    }

    public String getUniversityName() {
        return universityName;
    }
}

class Department {
    private String name;
    private UniversityEntity[] members;
    private int memberCount = 0;

    public Department(String name, int maxMembers) {
        this.name = name;
        this.members = new UniversityEntity[maxMembers];
    }

    public void addMember(UniversityEntity member) {
        if (memberCount < members.length) {
            members[memberCount++] = member;
            System.out.println(member.getName() + " added to " + name + " department.");
        } else {
            System.out.println("Department " + name + " is full.");
        }
    }

    public String getName() {
        return name;
    }

    public UniversityEntity[] getMembers() {
        return members;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Department computerScience = new Department("Computer Science", 50);
        Department business = new Department("Business Administration", 100);

        Administrator profKamau = new Administrator(1, "Prof. Kamau", "EMP001", "admin123", computerScience);
        Administrator drOchieng = new Administrator(2, "Dr. Ochieng", "EMP002", "manager456", business);

        computerScience.addMember(profKamau);
        business.addMember(drOchieng);

        Student alice = new Student(101, "Alice Wambui", "STD001", computerScience);
        Student bob = new Student(102, "Bob Omondi", "STD002", business);

        computerScience.addMember(alice);
        business.addMember(bob);

        University uon = new University(5);
        uon.addDepartment(computerScience);
        uon.addDepartment(business);

        System.out.println("\n--- University Entities ---");
        System.out.println(profKamau.getDescription());
        System.out.println(alice.getDescription());

        System.out.println("\n--- Actions within the University of Nairobi ---");
        profKamau.performTask(new UpdateData());
        alice.viewInformation(new ViewData());
        drOchieng.performTask(new DeleteData());
    }
}