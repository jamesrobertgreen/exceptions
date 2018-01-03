package uk.co.greenjam.exceptions;

public class MyException extends Exception{

    public MyException(){
        super("Default exception message used if one isn't provided.");
    }

    public MyException(String message){
        super(message);
    }

}
