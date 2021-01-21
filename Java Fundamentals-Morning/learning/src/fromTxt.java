import java.io.*;
import java.util.*;

public class fromTxt {
    private static Students que;
    public static void main(String[] args) {
        try {
            FileInputStream fIn = new FileInputStream("student.txt");
            ObjectInputStream in = new ObjectInputStream(fIn);
          //  que = (Students) in.readObject();

            HashMap<Integer, Integer> totMarks = (HashMap<Integer, Integer>)in.readObject();

            List<Map.Entry<Integer, Integer> > list =
                    new LinkedList<Map.Entry<Integer, Integer> > (totMarks.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2)
                {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });

            HashMap<Integer, Integer> sortedMarks = new LinkedHashMap<Integer, Integer>();
            for (Map.Entry<Integer, Integer> aa : list) {
                sortedMarks.put(aa.getKey(), aa.getValue());
            }

            File file = new File("RankList.csv");
            FileWriter outputfile = new FileWriter(file);

            try {
                BufferedWriter op = new BufferedWriter(outputfile);
                op.write("Rank RollNo Marks");
                op.newLine();

                int rank = 1;
                for(Integer i: sortedMarks.keySet()) {
                    op.write(rank + " " + i + " " + sortedMarks.get(i));
                    op.newLine();
                    System.out.println(rank + " " + i + " " + sortedMarks.get(i));
                    rank++;
                }
                op.close();
                outputfile.close();
                System.out.println("Wrote to csv file");
            }catch (IOException ioException) {
                ioException.printStackTrace();
            }

            System.out.println(totMarks);
            in.close();
            fIn.close();

        } catch (Exception e) {
            System.out.println("kn serialization Exception occured:" + e);
        }
    }
}
