package kz.itstep.rest2.exceptions;

public class UserExistException extends Exception{
    public UserExistException(String message){
        super(message);
    }
}
