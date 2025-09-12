package ExceptionHandling;

public class Question2 {
    public static void main(String[] args) {
        try{
            int a = 10/0;
            System.out.println("In try block");
        } catch (ArithmeticException ex){
            System.out.println("An exception occured");
        }
        System.out.println("Done");
    }
}

/*
* Flow of this program.
* goes in try block, found exception and move to catch block.
* Note: Always remember in try the line where exception is found the try block with no execute further it will directly
* go to catch block and execute. Any line below exception with not run it will directly go to catch block.
* */
