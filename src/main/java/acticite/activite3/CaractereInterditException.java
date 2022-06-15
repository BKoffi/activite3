package acticite.activite3;

public class CaractereInterditException extends Exception {

    /**
    * Message d'erreur.
    *
    */
    String ex="Vous avez entré un caractère interdit !" ;
    public CaractereInterditException(String message){
        super(message);
    }
}
