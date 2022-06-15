package acticite.activite3;


public class GrilleImpl implements Grille {

    private char[] elementTableau={0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};

    public char[] caractereValide={};

    private int size;
    public GrilleImpl(int size){
        size = this.size;
        if (size<=9) {
            for (int i = 1; i <=size; i++) {
                int j=i-1;
                this.caractereValide[j]=elementTableau[i];
            }
        } else {
            for (int i = 0; i < size; i++) {
                this.caractereValide[i]=elementTableau[i];
            }
        }
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                sudoku[i][j]=EMPTY;
            }
        }
    }

    @Override
    public char[] caracteres() {
        return caractereValide;
    }

    @Override
    public int getDimension() {
        return this.size;
    }

    @Override
    public void setValue(int x, int y, char value) {
        
        try {
            Boolean isValide=false;
            for (int i = 0; i < caractereValide.length; i++) {
                if(value==caractereValide[i]) {
                isValide=true;
                }
            }
            if (!isValide) {
                throw new CaractereInterditException("Vous avez entré un caractère interdit !");
            }
            if (x>getDimension()||y>getDimension()) {
                throw new HorsBornesException("Le nombre entré est Hors bornes !");
            } 
             if (isNumberInColumn(sudoku, value, y)||isNumberInRow(sudoku, value, x)||isNumberInBox(sudoku, value, x, y)) {
                throw new ValeurImpossibleException("La valeur entrée n'est pas autorisée !");
            } 
            
            for (int i = 0; i < sudoku.length; i++) {
                if (i==x) {
                    for (int j = 0; j < sudoku.length; j++) {
                        if (j==y) {
                            sudoku[i][j]=value;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public char getValue(int x, int y) {
        try {
             if (x>getDimension()||y>getDimension()) {
                throw new HorsBornesException("Les coordonnées entrées sont Hors bornes !");
            }
            return sudoku[x][y];

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public boolean complete() {
        try {
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku.length; j++) {
                    if (sudoku[i][j]!=EMPTY) {
                        char value =sudoku[i][j];
                        sudoku[i][j]=EMPTY;
                        return !isNumberInRow(sudoku, value, i) &&
                        !isNumberInColumn(sudoku, value, j) &&
                        !isNumberInBox(sudoku, value, i, j);
                    }
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean possible(int x, int y, char value) {
        try {
            if (x>getDimension()||y>getDimension()) {
                throw new HorsBornesException("Le nombre entré est Hors bornes !");
            } 
            Boolean isValide=false;
            for (int i = 0; i < caractereValide.length; i++) {
                if(value==caractereValide[i]) {
                isValide=true;
                }
            }
            if (!isValide) {
                throw new CaractereInterditException("Vous avez entré un caractère interdit !");
            }
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku.length; j++) {
                    if (!isNumberInRow(sudoku, value, i) &&
                    !isNumberInColumn(sudoku, value, j) &&
                    !isNumberInBox(sudoku, value, i, j)) {
                        return true;
                    }
                }
            }
            return false;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private static boolean isNumberInRow(char[][] board, char value, int row) {
        for (int i = 0; i < board.length; i++) {
          if (board[row][i] == value) {
            return true;
          }
        }
        return false;
      }
      
      private static boolean isNumberInColumn(char[][] board, char value, int column) {
        for (int i = 0; i < board.length; i++) {
          if (board[i][column] == value) {
            return true;
          }
        }
        return false;
      }
      
      private static boolean isNumberInBox(char[][] board, char value, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;
        
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
          for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
            if (board[i][j] == value) {
              return true;
            }
          }
        }
        return false;
      }
      public boolean isValidPlacement(char[][] board, char number, int row, int column) {
        return !isNumberInRow(board, number, row) &&
            !isNumberInColumn(board, number, column) &&
            !isNumberInBox(board, number, row, column);
      }
      
    
}
