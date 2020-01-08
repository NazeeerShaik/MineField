public class MineField{
    private char[][] grid;
    private boolean[][] mineGrid;
    private int size;
    private int numberOfSafeCells;
    private boolean isWinner,isOnMine=false;
    public boolean isWin(){
        return isWinner;
    }
    public boolean onMine(){
        return isOnMine;
    }
    public void setUserOptions(char ch,int x,int y){
        if(grid[x][y]!='o') {
            if (ch == 'o') {
                if (mineGrid[x][y]) {
                    isOnMine = true;
                    displayGrid();
                } else {
                    grid[x][y] = 'o';
                    displayGrid();
                    numberOfSafeCells -= 1;
                    if (numberOfSafeCells == 0) isWinner = true;
                }
            } else {
                grid[x][y] = 'f';
                displayGrid();
            }
        }
    }
    MineField(int size){
        this.size=size;
        grid=new char[size][size];
        mineGrid=new boolean[size][size];
        init();
    }
    private void init(){
        int i,j;
        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                grid[i][j]='x';
                mineGrid[i][j]=false;
            }
        }
        buildMineFieldWithMines();
    }
    public void displayGrid(){
        int i,j;
        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    private void buildMineFieldWithMines(){
        Mine mine=new Mine(size);
        int noOfMines=(int)(Math.random()*((size*size))/2)+1;
        numberOfSafeCells=(size*size)-noOfMines;
        while(noOfMines>0){
            mine.getMineValues();
            if(!mineGrid[mine.x][mine.y]){
                grid[mine.x][mine.y]='m';
                mineGrid[mine.x][mine.y]=true;
                noOfMines--;
            }
        }
    }
}