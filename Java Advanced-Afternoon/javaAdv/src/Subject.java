import javax.xml.bind.annotation.XmlAttribute;
import java.time.LocalDate;

public class Subject {

    int id;
    @toUpper(toUpper = true)
    String name;
    @toUpper(toUpper = true)
    String prgLang;

    String status;
    @addDate(addDate = true)
    private LocalDate localDate = null;

    public Subject(){}
    public Subject(int id, String name, String prgLang, String status){
        this.id = id;
        this.name = name;
        this.prgLang = prgLang;
        this.status = status;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrgLang() {
        return prgLang;
    }

    public void setPrgLang(String prgLang) {
        this.prgLang = prgLang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLocalDate() { return localDate; }

    public void setLocalDate(LocalDate localDate) { this.localDate = localDate; }

}

