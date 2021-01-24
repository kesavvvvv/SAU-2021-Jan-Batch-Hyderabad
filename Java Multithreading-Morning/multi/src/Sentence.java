import java.util.List;

public class Sentence extends Thread{
    private List<String> str;
    int sentenceCount = 0;

    Sentence(List<String> str){
        this.str = str;
    }

    @Override
    public void run(){
        for(String line : str){
            if(line.equals("")){}
            else {
                String[] sentenceList = line.split("[!?.:]+");
                sentenceCount += sentenceList.length;
            }
        }
    }
    public int getSentenceCount(){
        return sentenceCount;
    }

}
