import jdk.nashorn.internal.runtime.ECMAException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.InvalidMarkException;
import java.util.HashMap;
import java.util.List;

public class toObject {
    public static void main(String[] args) {
        try {
            int t;
            HashMap<Integer, Integer> totMarks = new HashMap<>();
            File file = new File("student.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Students que= (Students) jaxbUnmarshaller.unmarshal(file);
            List<Student> data = que.getStudents();

            for(Student temp:data){
                System.out.println(temp.getRoll() + " " + temp.getSubject() + " " + temp.getMarks());
                if(totMarks.containsKey(temp.getRoll())) {
                    t = totMarks.get(temp.getRoll()) + temp.getMarks();
                    totMarks.put(temp.getRoll(), t);
                }
                else
                    totMarks.put(temp.getRoll(), temp.getMarks());
            }
            try {
                FileOutputStream fout = new FileOutputStream("student.txt");
                ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(totMarks);
                out.close();
                fout.close();
                System.out.println("Wrote to txt file");
            } catch(Exception e) {
                System.out.println("hi" + e);
            }
        }catch (JAXBException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}