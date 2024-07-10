package kz.itstep.rest2.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
}
