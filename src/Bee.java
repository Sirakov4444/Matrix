import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheMatrix {

    static int beeRow=0;
    static int beeCow=0;
    static int pollinatedFlower=0;
    static  boolean isOver =false;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int size = Integer.parseInt(bf.readLine());

        String[][] matrix = new String[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = bf.readLine().split("");
        }
        findBee(matrix);


        String command=bf.readLine();
        while (!command.equals("End") && !isOver){   // || && !isWon
                switch (command){
                    case "up":
                        beeRow--;
                        if(isValid(matrix)){
                            matrix[beeRow+1][beeCow]=".";
                            if(matrix[beeRow][beeCow].equals("f")){
                                            pollinatedFlower++;
                                            matrix[beeRow][beeCow]="B";
                            }else if(matrix[beeRow][beeCow].equals("O")){
                                      beeRow--;
                                if(isValid(matrix)){
                                          matrix[beeRow+1][beeCow]=".";
                                          if(matrix[beeRow][beeCow].equals("f")){
                                              pollinatedFlower++;
                                              matrix[beeRow][beeCow]="B";
                                          }else {
                                              matrix[beeRow+1][beeCow]=".";
                                              matrix[beeRow][beeCow]="B";
                                          }
                                      }else {
                                    matrix[beeRow+1][beeCow]=".";
                                    isOver=true;
                                    continue;
                                }

                            }else {
                                matrix[beeRow+1][beeCow]=".";
                                matrix[beeRow][beeCow]="B";
                            }
                        }else {
                            matrix[beeRow+1][beeCow]=".";
                            isOver=true;
                            continue;
                        }
                        break;
                    case "down":
                        beeRow++;
                        if(isValid(matrix)){
                            matrix[beeRow-1][beeCow]=".";
                            if(matrix[beeRow][beeCow].equals("f")){
                                pollinatedFlower++;
                                matrix[beeRow][beeCow]="B";
                            }else if(matrix[beeRow][beeCow].equals("O")){
                                beeRow++;
                                if(isValid(matrix)){
                                    matrix[beeRow-1][beeCow]=".";
                                    if(matrix[beeRow][beeCow].equals("f")){
                                        pollinatedFlower++;
                                        matrix[beeRow][beeCow]="B";
                                    }else {
                                        matrix[beeRow-1][beeCow]=".";
                                        matrix[beeRow][beeCow]="B";
                                    }
                                }else {
                                    matrix[beeRow-1][beeCow]=".";
                                    isOver=true;
                                    continue;
                                }

                            }else {
                                matrix[beeRow-1][beeCow]=".";
                                matrix[beeRow][beeCow]="B";
                            }
                        }else {
                            matrix[beeRow-1][beeCow]=".";
                            isOver=true;
                            continue;
                        }
                        break;
                    case "left":
                        beeCow--;
                        if(isValid(matrix)){
                            matrix[beeRow][beeCow+1]=".";
                            if(matrix[beeRow][beeCow].equals("f")){
                                pollinatedFlower++;
                                matrix[beeRow][beeCow]="B";
                            }else if(matrix[beeRow][beeCow].equals("O")){
                                beeCow--;
                                if(isValid(matrix)){
                                    matrix[beeRow][beeCow+1]=".";
                                    if(matrix[beeRow][beeCow].equals("f")){
                                        pollinatedFlower++;
                                        matrix[beeRow][beeCow]="B";
                                    }else {
                                        matrix[beeRow][beeCow+1]=".";
                                        matrix[beeRow][beeCow]="B";
                                    }
                                }else {
                                    matrix[beeRow][beeCow+1]=".";
                                    isOver=true;
                                    continue;
                                }

                            }else {
                                matrix[beeRow][beeCow+1]=".";
                                matrix[beeRow][beeCow]="B";
                            }
                        }else {
                            matrix[beeRow][beeCow+1]=".";
                            isOver=true;
                            continue;
                        }
                        break;
                    case "right":
                        beeCow++;
                        if(isValid(matrix)){
                            matrix[beeRow][beeCow-1]=".";
                            if(matrix[beeRow][beeCow].equals("f")){
                                pollinatedFlower++;
                                matrix[beeRow][beeCow]="B";
                            }else if(matrix[beeRow][beeCow].equals("O")){
                                beeCow++;
                                if(isValid(matrix)){
                                    matrix[beeRow][beeCow-1]=".";
                                    if(matrix[beeRow][beeCow].equals("f")){
                                        pollinatedFlower++;
                                        matrix[beeRow][beeCow]="B";
                                    }else {
                                        matrix[beeRow][beeCow-1]=".";
                                        matrix[beeRow][beeCow]="B";
                                    }
                                }else {
                                    matrix[beeRow][beeCow-1]=".";
                                    isOver=true;
                                    continue;
                                }

                            }else {
                                matrix[beeRow][beeCow-1]=".";
                                matrix[beeRow][beeCow]="B";
                            }
                        }else {
                            matrix[beeRow][beeCow-1]=".";
                            isOver=true;
                            continue;
                        }
                        break;
                    default:
                        throw new IllegalStateException("kur");
                }
                command=bf.readLine();
        }
        if(isOver){
            System.out.println("The bee got lost!");
        }
        if(pollinatedFlower<5){
            System.out.println("The bee couldn't pollinate the flowers, she needed " +(5-pollinatedFlower)+ " flowers more");
        }else {
            System.out.println("Great job, the bee manage to pollinate "+pollinatedFlower+" flowers!");
        }
        //System.out.println();
        printOut(matrix);

    }
    private  static boolean isValid (String[][]maxx){
        return  beeRow>=0 && beeRow<maxx.length && beeCow>=0 && beeCow<maxx.length;
    }
    private static void printOut(String[][]mx){
        for (int i = 0; i <mx.length ; i++) {
            for (int j = 0; j <mx[i].length ; j++) {
                System.out.print(mx[i][j]);
            }
            System.out.println();
        }
    }
    private static void findBee(String[][]mx2){
        for (int i = 0; i <mx2.length ; i++) {
            for (int j = 0; j <mx2[i].length ; j++) {
                if(mx2[i][j].equals("B")){
                    beeRow=i;
                    beeCow=j;
                }
            }
        }
    }
}
