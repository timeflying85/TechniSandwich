package be.technifutur.technisandwich.exceptions;

public class RessourceNotFoundException extends RuntimeException{

    public RessourceNotFoundException(){
        super("the requested resource was not found");
    }

    public RessourceNotFoundException(Throwable cause){
        super("the requested resource was not found", cause);
    }

}

