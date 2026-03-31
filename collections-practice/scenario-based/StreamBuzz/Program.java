import java.util.List;

public class Program {
    public void calThreshhold(int threshhold, List<String> names ,List<List<Integer>> likes){
        int k=0;
    for (int i = 0; i < likes.size(); i++) {
        int c = 0;
        for (int j = 0; j < likes.get(i).size(); j++){
            if(threshhold <= likes.get(i).get(j)){
                c++;
            }
        }
        if(c>0){
            k++;
        System.out.println(names.get(i)+" - "+c);
        }

    }
    if(k==0){
        System.out.println("No top-performing posts this week");
    }
    }
    public void calAverageLikes(List<List<Integer>> likes){
        int sum = 0;
        for(int i=0;i<likes.size();i++){
            for(int j=0;j<likes.get(i).size();j++){
                sum += likes.get(i).get(j);
            }
        }
        int avg = sum/(likes.size() * likes.get(0).size());
        System.out.println("Overall average weekly likes: "+avg);
    }
}
