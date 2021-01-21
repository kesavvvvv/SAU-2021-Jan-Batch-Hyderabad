import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "subjects")
public class Subjects {
    private List<Subject> subjects;

    public Subjects() {}
    public Subjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @XmlElement(name = "subject")
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
