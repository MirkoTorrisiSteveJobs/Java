public class Tris {
    private String[][] scheme={ {" ", " ", " ", " ", " ", " ", " " },
                                {" ", " ", " ", " ", " ", " ", " " },
                                {" ", " ", " ", " ", " ", " ", " " },
                                {" ", " ", " ", " ", " ", " ", " " },
                                {" ", " ", " ", " ", " ", " ", " " },
                                {" ", " ", " ", " ", " ", " ", " " } };
    public String[][] getScheme() {
        return scheme;
    }
    public boolean isEmptyAndDraw(String choice, String player){
        try {
            int col = Integer.parseInt(choice);
            for (int i = scheme.length - 1; i >= 0; i--) {
                if (scheme[i][col].equalsIgnoreCase(" ")) {
                    scheme[i][col] = player;
                    return true;
                }
            }
            return false;
        }
        catch (Exception e) {
            System.out.println("Insert a number between 0 and "+(scheme.length-1));
            return false;
        }
    }
    public boolean itsOver(){
        for(int i = 0; i <scheme.length; i++){
            for(int n = 0; n< scheme[i].length; n++){
                if(scheme[i][n].equalsIgnoreCase(" ")){
                    return false;
                }
            }
        }
        return true;
    }
    public String printScheme(){
        String board = "[0][1][2][3][4][5][6]";
        for(int i = 0; i < scheme.length; i++ ){
            board+="\n";
            for(int n = 0; n < scheme[i].length; n++){
                board+= "["+scheme[i][n]+"]";
            }
        }
        return board;
    }
    private boolean checkOrizontalVertical(){
        for(int i = 0; i < scheme.length ; i++){
            for(int n = 0; n < scheme[i].length-3; n++) {
                if (!scheme[i][n].equals(" ") && scheme[i][n] == scheme[i][n + 1] && scheme[i][n + 1] == scheme[i][n + 2] && scheme[i][n + 2] == scheme[i][n + 3]) {
                    return true;
                }
            }
        }
        for(int i = 0; i < scheme.length-3; i++) {
            for (int n = 0; n < scheme[i].length; n++) {
                if (!scheme[i][n].equals(" ") && scheme[i][n] == scheme[i + 1][n] && scheme[i + 1][n] == scheme[i + 2][n] && scheme[i + 2][n] == scheme[i + 3][n]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(){
        for(int row = 3; row < scheme.length; row++) {
            for (int col = 0; col < scheme[0].length - 3; col++) {
                if (scheme[row][col] != " " && scheme[row][col] == scheme[row - 1][col + 1] && scheme[row - 1][col + 1] == scheme[row - 2][col + 2] && scheme[row - 2][col + 2] == scheme[row - 3][col + 3]) {
                    return true;
                }
            }
        }
        for(int row = 3; row < scheme.length; row++) {
            for (int col = 3; col < scheme[0].length; col++) {
                if (scheme[row][col] != " " && scheme[row][col] == scheme[row - 1][col - 1] && scheme[row - 1][col - 1] == scheme[row - 2][col - 2] && scheme[row - 2][col - 2] == scheme[row - 3][col - 3]) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkWin(){
        if( checkDiagonal() || checkOrizontalVertical()){
            return true;
        }
        else{
            return false;
        }
    }
}
