import java.util.List;

public class Word extends Thread{

    private List<String> str;
    int countWord = 0;

    Word(List<String> str){
        this.str = str;
    }

    @Override
    public void run(){
        for(String line : str){
            if(line.equals("")){}
            else {
                String[] wordList = line.split("\\s+");
                countWord += wordList.length;
            }
        }
    }
    public int getWordCount(){
        return countWord;
    }
}
