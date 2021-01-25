import java.util.ArrayList;
import java.util.List;

public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {

        List<String> gunClassOri = new ArrayList<String>();
        gunClassOri.add("DMR-14");
        gunClassOri.add("MAC-10");

        Gun guns1 = new Gun(gunClassOri);

        Gun guns2 = (Gun) guns1.clone();
        Gun guns3 = (Gun) guns1.clone();
        List<String> gunClass1 = guns2.getGuns();
        List<String> gunClass2 = guns3.getGuns();

        gunClass1.remove("MAC-10");
        gunClass1.add("Diamatti");

        gunClass2.remove("DMR-14");
        gunClass2.add("Kar98k");

        System.out.println("Warzone Class: "+ guns1.getGuns());
        System.out.println("New Cloned Warzone Class 1: "+ gunClass1);
        System.out.println("New Cloned Warzone Class 2: "+ gunClass2);

    }
}
