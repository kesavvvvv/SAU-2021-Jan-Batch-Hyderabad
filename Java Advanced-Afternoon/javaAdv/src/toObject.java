import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class toObject {
    public static void main(String[] args) {
        try {
            File file = new File("subjectInfo.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Subjects.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Subjects subjects = (Subjects) jaxbUnmarshaller.unmarshal(file);

            List<Subject> subjects1 = subjects.getSubjects();

            for(Subject data: subjects1){

                toUpper(data);
                addDate(data);

                System.out.println(data.getId() +" "+ data.getName() +" " +data.getPrgLang()+" "+data.getStatus() + " " + data.getLocalDate());
            }

            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaadv?","root", "root")){


                try (Statement stmt = connection.createStatement()) {
                    String sql = "create table assignment(id int PRIMARY KEY, name varchar(100), Language varchar(100), Status varchar(20), Date date)";
                    stmt.execute(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String sql = "insert into assignment(id, name, Language, Status, Date) values(?, ?, ?, ?, ?)";

                List<Subject> assignment = subjects.getSubjects();
                for(Subject data : assignment) {
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, data.getId());
                        stmt.setString(2, data.getName());
                        stmt.setString(3, data.getPrgLang());
                        stmt.setString(4, data.getStatus());
                        stmt.setDate(5, Date.valueOf(data.getLocalDate()));
                        stmt.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }



        } catch (JAXBException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void toUpper(Object object) throws IllegalArgumentException {
        Class<?> objectClass = object.getClass();
        for(Field field : objectClass.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(toUpper.class)){
                toUpper addDate = field.getAnnotation(toUpper.class);
                if(addDate.toUpper())
                    field.set(object, field.get(object).toString().toUpperCase());
            }
        }
    }

    public static void addDate(Object object) throws IllegalArgumentException {
        Class<?> objectClass = object.getClass();

        for(Field field : objectClass.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(addDate.class)){
                addDate addDate = field.getAnnotation(addDate.class);
                if(addDate.addDate())
                    field.set(object, LocalDate.now());
            }
        }
    }

}
