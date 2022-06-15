package acticite.activite3;

public class HorsBornesException extends Exception {


    /**
    * Message d'erreur.
    *
    */
    String ex="Le nombre entré est Hors bornes !";
    public HorsBornesException(String message){
        super(message);
    }
}
