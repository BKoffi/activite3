package acticite.activite3;

public class ValeurImpossibleException extends Exception {
    /**
    * Message d'erreur.
    *
    */
    String ex= "La valeur entrée n'est pas autorisée !";
     public ValeurImpossibleException(String message){
        super(message);
     }
}
