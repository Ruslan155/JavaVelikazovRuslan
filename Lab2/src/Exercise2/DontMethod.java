package Exercise2;

import java.util.Scanner;

class NegativeNumbers{
    float numberss;
}

public class DontMethod {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.println("Enter the length of the array=> ");
        int lenght = sc.nextInt();

        NegativeNumbers[] numb = new NegativeNumbers[lenght];

        for(int i = 0; i<numb.length; i++){
            numb[i] = new NegativeNumbers();
            System.out.println("Enter number => ");
            numb[i].numberss = sc.nextFloat();
        }

        System.out.println("Your numbers: ");
        for(int i = 0; i<numb.length; i++){
            System.out.println(numb[i].numberss);
        }

        for(int i = 0; i<numb.length; i++){
            if(numb[i].numberss >= 0){
                throw new IllegalArgumentException("Error. Positive number");
            }
        }

        int index = 0;
        float min = 0;
        for(int i = 0; i< numb.length; i++){
            if(numb[i].numberss < min){
                min = numb[i].numberss;
                index = i;
            }
        }

        System.out.println("Minimum element: "+ min +"\tIndex: "+ index);
    }
}
