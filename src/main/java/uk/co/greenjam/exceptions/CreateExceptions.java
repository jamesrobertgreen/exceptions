package uk.co.greenjam.exceptions;

import java.io.IOException;

public class CreateExceptions {


    public void throwAndCatchDefaultMessage(){
        try{
            try1();
            if(true) {
                throw new MyException();
            }
            try2();
        }
        catch (MyException e){
            // error is caught..
            catchBlock(e.getMessage());
        }
        catch (Exception e){
            // error is a derived (subclass) of Exception, however the more specific catch above is used.
            generalException(e);
        }
        finally {
            // finally called
            finallyBlock();
        }
        // exception was handled so execution continues
        afterTry();
    }

    public void throwAndCatchOverridenMessage(){
        try{
            throw new MyException("This is a new message");
        }
        catch (MyException e){
            // Overridden message is used instead of default
            catchBlock(e.getMessage());
        }
    }

    public void generalError(){
        try{
            try1();
            if(true) {
                throw new MyException("General Exception");
            }
            try2();
        }
        catch (Exception e){
            // MyException is a derived (subclass) of Exception, so this exception will be caught
            catchBlock(e.getMessage());
        }
        finally {
            // finally is called
            finallyBlock();
        }
        // exception was handled so execution continues
        afterTry();
    }

    public void catchUncaught(){
        try {
            System.out.println("Try 1 calling method");
            if(true) {
                throwUncaught();
            }
            System.out.println("Try 2 calling method");
        } catch (MyException e) {
            System.out.println("Caught by calling method");
        }
        System.out.println("After try calling method");
    }

    public void throwUncaught() throws MyException {
        try{
            try1();
            if(true) {
                throw new MyException();
            }
            try2();
        // catch omitted intentionally
        } finally {
            // finally is called when try block throws an exception that is not caught
            finallyBlock();
        }
        // this line will not be called, as execution stops when the error occurs and is not caught
        afterTry();
    }



    private void generalException(Exception e) {
        System.out.println("General Exception " + e.getMessage());
    }

    public void exceptionOrder(){
        try{
            try1();
            if(true) {
                throw new MyException();
            }
            try2();
        }
        // This would give a compile time error
//        catch (Exception e){
//            generalException(e);
//        }
        catch (MyException e){
            catchBlock(e.getMessage());
        }
        finally {
            finallyBlock();
        }
        afterTry();
    }

    public void noError(){
        try{
            try1();
        }
        finally {
            // finally is called if try runs without error
            finallyBlock();
        }
        afterTry();
    }

    private void afterTry() {
        System.out.println("After Try block");
    }

    private void finallyBlock() {
        System.out.println("Finally!");
    }

    private void try1() {
        System.out.println("Try...");
    }
    private void try2() {
        System.out.println("Never called, as try block execution stops when an error occurs.");
    }

    private void catchBlock(String message) {
        System.out.println(message);
    }


}
