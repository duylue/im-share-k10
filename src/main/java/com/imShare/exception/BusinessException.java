package com.imShare.exception;

<<<<<<< HEAD
public class BusinessException {
=======
public class BusinessException extends RuntimeException{
    private int status;
    public BusinessException(int status, String message){
        super(message);
        this.status = status;
    }
>>>>>>> 84d83efe770d60f8bd552e5bbf0748550a483571
}
