package Exercise;

import java.util.Scanner;

class NegativeNumbers{
    float numberss;
}

public class WithMethod {
    public static NegativeNumbers[] createArray(int k){
        Scanner sc = new Scanner(System.in, "cp1251");

        NegativeNumbers[] numb = new NegativeNumbers[k];

        for(int i = 0; i<numb.length; i++){
            numb[i] = new NegativeNumbers();
            System.out.println("Enter number=> ");
            numb[i].numberss = sc.nextFloat();
        }

        return numb;
    }

    public static void showArray(NegativeNumbers[] numb){
        System.out.println("Your numbers: ");

        for(int i = 0; i<numb.length; i++){
            System.out.println(numb[i].numberss);
        }
    }
    public static void check(NegativeNumbers[] numb){
         for(int i = 0; i<numb.length; i++){
             if(numb[i].numberss >= 0){
                 throw new IllegalArgumentException("Error. Positive number");
             }
         }
    }

    public static float min(NegativeNumbers[] numb){

        float min = 0;
        for(int i = 0; i< numb.length; i++){
            if(numb[i].numberss < min){
                min = numb[i].numberss;
            }
        }
        return min;
    }

    public static int minIndex(NegativeNumbers[] numb){
        int index = 0;
        float min = 0;
        for(int i = 0; i< numb.length; i++){
            if(numb[i].numberss < min){
                min = numb[i].numberss;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.println("Enter the length of the array=> ");
        int lenght = sc.nextInt();

        NegativeNumbers numberss[] = createArray(lenght);

        showArray(numberss);

        check(numberss);

        System.out.println("Minimum element = " + min(numberss) + " , index: "+ minIndex(numberss));

    }
}

