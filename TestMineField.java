import java.util.*;
public class TestMineField {
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        MineField mineField=new MineField(size);
        mineField.displayGrid();
        while(!mineField.isWin() && !mineField.onMine()){
            String  userOption=in.next();
            int x=Integer.parseInt(userOption.substring(userOption.indexOf('(')+1,userOption.indexOf(',')));
            int y=Integer.parseInt(userOption.substring(userOption.indexOf(',')+1,userOption.indexOf(')')));
            mineField.setUserOptions(userOption.charAt(0),x,y);
            //System.out.println(mineField.isWin()+" "+mineField.onMine());
        }
    }
}
