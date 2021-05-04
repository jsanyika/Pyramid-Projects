public class Primary extends Grid {

    public Primary(){
        for(int i = 0; i <= 9; i ++){
            for(int j = 0; j <= 9; j++){
                this.getGrid()[i][j] = 'o';
            }
        }
    }
}
