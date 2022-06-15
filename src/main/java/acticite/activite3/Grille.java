package acticite.activite3;

public interface Grille {
        /** Caractere de case vide */
        public char[][] sudoku={};
        char EMPTY = '@';
        char a = 'a', b = 'b', c = 'c', d = 'd', e = 'e', f = 'f', g = 'g', h = 'h', i = 'i', j = 'j', k = 'k', l = 'l',
                        m = 'm', n = 'n', o = 'o', p = 'p', q = 'q', r = 'r', s = 's', t = 't', u = 'u', v = 'v',
                        w = 'w', x = 'x', y = 'y', z = 'z';

        /**
         * Caracteres pouvant être mis dans la grille
         * par exemple pour une grille 4x4 : 1, 2, 3, 4
         * par exemple pour une grille 9x9 : 1, 2, 3, 4, 5, 6, 7, 8, 9
         * par exemple pour une grille 16x16: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d,
         * e, f
         * par exemple pour une grille 25x25: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d,
         * ..., o
         */
        char[] caracteres();

        /** @return largeur/hauteur de la grille */
        int getDimension();

        /**
         * Affecte une valeur dans la grille
         * 
         * @param x     position x dans la grille
         * @param y     position y dans la grille
         * @param value valeur a mettre dans la case
         * @throw HorsBornesException si x ou y sont en dehors de la grille
         * @throw ValeurImpossibleException si la valeur est interdite aux
         *        vues des autres valeurs de la grille
         * @throw CaractereInterditException si value n'est pas un caractere
         *        pouvant être mis dans la grille
         */
        void setValue(int x, int y, char value)
                        throws HorsBornesException, ValeurImpossibleException, CaractereInterditException;

        /**
         * Recupere une valeur de la grille
         * 
         * @param x position x dans la grille
         * @param y position y dans la grille
         * @return valeur dans la case x,y
         * @throw HorsBornesException si x ou y sont en dehors de la grille
         */
        char getValue(int x, int y) throws HorsBornesException;

        /**
         * Test si une grille est terminee
         * 
         * @return true si la grille est complete
         */
        boolean complete();

        /**
         * Test si une valeur est possible dans la grille par rapport a ce qu'elle
         * contient deja
         * 
         * @param x     position x dans la grille
         * @param y     position y dans la grille
         * @param value valeur a mettre dans la case
         * @throw HorsBornesException si x ou y sont hors bornes (0-8)
         * @throw CaractereInterditException si value n'est pas un caractere pouvant
         *        être mis dans la grille
         */
        boolean possible(int x, int y, char value)
                        throws HorsBornesException, CaractereInterditException;

}
