package be.technifutur.technisandwich.exceptions;


public class FormValidationException extends RuntimeException{
    public  FormValidationException(String message) {
        super(message);
    }
}
