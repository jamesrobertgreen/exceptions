package uk.co.greenjam.exceptions;

public class App 
{
    public static void main( String[] args )
    {
        CreateExceptions createExceptions = new CreateExceptions();
        System.out.println("************* Throw and Catch");
        createExceptions.throwAndCatchDefaultMessage();
        System.out.println("************* Throw and Catch Override");
        createExceptions.throwAndCatchOverridenMessage();
        System.out.println("************* Catch Uncaught");
        createExceptions.catchUncaught();
        System.out.println("************* No error");
        createExceptions.noError();
        System.out.println("************* General error");
        createExceptions.generalError();
    }
}
