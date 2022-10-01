package Example;

public class ExampleThirteen {
    public static void main(String[] args){
        try{
            int i = args.length;
            int h = 10/1;
            args[i+1] = "10";
        }
        catch (ArithmeticException e){
            System.out.println("Ділення на нуль");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Індекс не існує");
        }
    }
}
