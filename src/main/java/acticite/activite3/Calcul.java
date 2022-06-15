package acticite.activite3;

public final class Calcul {
    /**
     *
     */
    private Calcul() {
    }
    /**
     * 
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    /** Calcul la somme de deux nombres.
     * @param a
     * @param b
     * @return la somme de a et b
     **/
    public static int somme(final int a, final int b) {
    return a + b;
    }
    /** Renvoie la note, bornée par les valeurs min et max, exemples:.
    * noteBornee(12.5,0.0,20.0) doit renvoyer 12.2
    * noteBornee(25.0,0.0,20.0) doit renvoyer 20.0
    * noteBornee(-2.0,0.0,20.0) doit renvoyer 0.0
    *@param min
    *@param max
    *@param note
    *@return la note bornée
    **/
    public static double noteBornee(final double note,
    final double min, final double max) {
    if (note >= max) {
         return max;
        }
    if (note <= min) {
        return min;
        }
    return note;
    }
    /** @return a / b si b != 0
    * @throw IllegalArgumentException si b == 0
    *@param a
    *@param b
    */
    public static int division(final int a, final int b) {
    if (b == 0) {
    throw new IllegalArgumentException("b ne doit pas etre 0");
    }
    return a / b;
    }
}

