public class Mine{
    int size,x,y;
    Mine(int size){
        this.size=size;
    }
    public void getMineValues(){
        x=(int)(Math.random()*size);
        y=(int)(Math.random()*size);
    }
}