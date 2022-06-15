package acticite.activite3;

public interface Resolveur {

        /**
         * @param board Grille de sudoku
         */
        void printBoard(char[][] board);

        /**
         * @param board Grille de sudoku
         */
        boolean solveBoard(char[][] board);
}
