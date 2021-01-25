import entity.EmployeeAddress;
import entity.EmployeeCourse;
import entity.EmployeeData;
import entity.EmployeeDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Employee {

    private static EmployeeData emp1;
    private static EmployeeData emp2;
    private static EmployeeData emp3 ;
    private static EmployeeDetails empDet1;
    private static EmployeeDetails empDet2;
    private static EmployeeDetails empDet3;
    private static EmployeeAddress empAdd1;
    private static EmployeeAddress empAdd2;
    private static EmployeeAddress empAdd3;
    private static EmployeeAddress empAdd4;
    private static EmployeeCourse empCourse1 ;
    private static EmployeeCourse empCourse2 ;
    private static EmployeeCourse empCourse3 ;


    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeData.class)
                .addAnnotatedClass(EmployeeDetails.class)
                .addAnnotatedClass(EmployeeAddress.class)
                .addAnnotatedClass(EmployeeCourse.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        setData();
        setDetails();

        try {
            session.beginTransaction();

            session.save(emp1);
            session.save(emp2);
            session.save(emp3);
            session.save(empDet1);
            session.save(empDet2);
            session.save(empDet3);

            session.getTransaction().commit();
            session.close();
            session = sessionFactory.openSession();
            EmployeeData empGetDB = session.get(EmployeeData.class, 1);
            session.close();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }

    public static void setData() {
        emp1 = new EmployeeData("Kesav", "R");
        emp2 = new EmployeeData("Neelesh", "G");
        emp3 = new EmployeeData("Anam", "S");
        empDet1 = new EmployeeDetails("9176290646","kesav@mail.com", emp1);
        empDet2 = new EmployeeDetails("9884431282","neelesh@mail.com", emp2);
        empDet3 = new EmployeeDetails("8939456120","raj@mail.com", emp3);
        empAdd1 = new EmployeeAddress("Virugambakkam", "Chennai", "600092", emp1);
        empAdd2 = new EmployeeAddress("Vadapalani", "Chennai", "600080", emp2);
        empAdd3 = new EmployeeAddress("Pallikaranai", "Chennai", "600100", emp2);
        empAdd4 = new EmployeeAddress("KK Nagar", "Chennai", "600078", emp3);
        empCourse1 = new EmployeeCourse("Antennas");
        empCourse2 = new EmployeeCourse("Embedded");
        empCourse3 = new EmployeeCourse("Data Structures");

    }

    public static void setDetails() {
        emp1.getEmpAddress().add(empAdd1);
        emp2.getEmpAddress().add(empAdd2);
        emp2.getEmpAddress().add(empAdd3);
        emp3.getEmpAddress().add(empAdd4);
        emp1.getCourse().add(empCourse1);
        emp2.getCourse().add(empCourse1);
        emp1.getCourse().add(empCourse2);
        emp2.getCourse().add(empCourse2);
        emp1.getCourse().add(empCourse3);
        emp2.getCourse().add(empCourse3);
        emp3.getCourse().add(empCourse3);
        empCourse1.getEmployee().add(emp1);
        empCourse2.getEmployee().add(emp1);
        empCourse3.getEmployee().add(emp1);
        empCourse1.getEmployee().add(emp2);
        empCourse2.getEmployee().add(emp2);
        empCourse3.getEmployee().add(emp2);
        empCourse3.getEmployee().add(emp3);
    }
}
