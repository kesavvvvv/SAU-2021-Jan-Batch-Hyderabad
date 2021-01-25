import java.util.ArrayList;
import java.util.List;

public class Gun implements Cloneable {

    private List<String> guns;

    public List<String> getGuns() {
        return guns;
    }

    public void setGuns(List<String> gunssss) {
        this.guns = gunssss;
    }

    public Gun(List<String> gunClass){
        this.guns = gunClass;

    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> temp = new ArrayList<String>();
        for(String s : this.getGuns()){
            temp.add(s);
        }
        return new Gun(temp);
    }
}
