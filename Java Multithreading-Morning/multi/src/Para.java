import java.util.List;

public class Para extends Thread{

    private List<String> str;
    int paragraphCount = 0;

    Para(List<String> str){
        this.str = str;
    }

    @Override
    public void run(){
        for(String line : str){
            if(line.equals(""))
            {
                paragraphCount++;
            }
        }
    }
    public int getParagraphCount(){
        return paragraphCount;
    }
}
