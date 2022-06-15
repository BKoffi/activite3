package acticite.activite3;

public class ResolveurImpl implements Resolveur {

  GrilleImpl grille = new GrilleImpl(9);
  @Override
  public void printBoard(char[][] board) {
    for (int row = 0; row < Grille.sudoku.length; row++) {
      if (row % 3 == 0 && row != 0) {
        System.out.println("-----------");
      }
      for (int column = 0; column < Grille.sudoku.length; column++) {
        if (column % 3 == 0 && column != 0) {
          System.out.print("|");
        }
        System.out.print(board[row][column]);
      }
      System.out.println();
    }
  }

  @Override
  public boolean solveBoard(char[][] board) {
    for (int row = 0; row < Grille.sudoku.length; row++) {
      for (int column = 0; column < Grille.sudoku.length; column++) {
        if (board[row][column] == 0) {
          for (int i = 0; i < grille.getDimension(); i++) {
            if (grille.isValidPlacement(board, grille.caractereValide[i], row, column)) {
              board[row][column] = grille.caractereValide[i];
              
              if (solveBoard(board)) {
                return true;
              }
              else {
                board[row][column] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }
    
}
