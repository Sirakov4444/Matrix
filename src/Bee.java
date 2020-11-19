import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Bee {
    static int flowerWreaths=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

         //one wreath needs 15 flowers.
        int[] roses = Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] lilies = Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer>rosesQueue=new ArrayDeque<>();
        ArrayDeque<Integer>liliesStack=new ArrayDeque<>();

        ArrayDeque<Integer>storedRRqueue=new ArrayDeque<>();
        ArrayDeque<Integer>storedLLstack=new ArrayDeque<>();


        for(Integer a : roses){
            rosesQueue.offer(a);
        }
        for(Integer b : lilies){
            liliesStack.push(b);
        }
          int lifet=0;//TODO <<<<<
        while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()){

            int sum=rosesQueue.peek() + liliesStack.peek();

            if(sum==15){
                flowerWreaths++;
                rosesQueue.poll();
                liliesStack.pop();
            }else if(sum > 15){
                int toDecrease=liliesStack.pop() - 2 ;
                liliesStack.push(toDecrease);
            }else if(sum>=0){
                lifet+=sum;
                liliesStack.pop();
                rosesQueue.poll();
            }
        }
        int additional=lifet/15;
        flowerWreaths+=additional;

        if(flowerWreaths>=5){
            System.out.println("You made it, you are going to the competition with "+flowerWreaths+" wreaths!" );
        }else {
            System.out.println("You didn't make it, you need "+(5-flowerWreaths)+" wreaths more!");
        }

    }
}