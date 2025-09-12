package ExceptionHandling;

public class Question3 {
    public static void main(String[] args) {
        /*
        try{
            int[] arr = {1, 2, 3};
            int element = arr[4];
        } finally{
            System.out.println("The code is running fine");
        }

        This block of code with get execute -> there is exception in try block it will catch and run the finally
         block as the exception is no being handled (no catch) it will throw exception and run finally block.
         */
/*
        try {
            int[] arr = {1, 2, 3};
            int element = arr[4];
        }catch(Exception ex){
            System.out.println("Parent exception has been called");
        }
        catch(ArithmeticException ex){
            System.out.println("Arithmetic exception");
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Array index out of Bound Exception");
        }

        finally {
            System.out.println("The programme executed");
        }
        -------------------------------------------------------
        Is this program it will throw java: exception java.lang.ArithmeticException has already been caught

        because Exception class in the parent class of all unchecked exception so if parent class executed first it
        can handle all below call task so no other exception need to be performed and compiler will ask to delete
        other exception.

 */
        /*
        try {
            int[] arr = {1, 2, 3};
            int element = arr[4];
        }catch(ArithmeticException ex){
            System.out.println("Arithmetic exception");
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Array index out of Bound Exception");
        }
        catch(Exception ex){
            System.out.println("Parent exception has been called");
        }
        finally {
            System.out.println("The programme executed");
        }

        *******************************************************
        Here the program flows in this way: In try block exception caught and created an object of that exception
        now it will match every catch block that it belongs to which exception and will execute that particular catch
        block if no object matched that it will run the parent object catch Exception class, it will handle all.
         */

    }
}
