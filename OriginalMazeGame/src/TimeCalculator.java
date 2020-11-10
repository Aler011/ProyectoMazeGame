public class TimeCalculator
{
int minutes=0;
int seconds=0;
    //Este método determina el tiempo de un jugador tiene para completar cada nivel basado en su tamaño(del nivel) y el total de diamantes(delnivel). 
    public void calcTimeforMaze(int totalDimonds, int xSize, int ySize)
    {
        if(xSize/ySize < 1)//this method should be changed in order to provide a more relistic time system.
        {
            minutes+=(ySize/xSize)*1+1;
        }
        else
            minutes+=(ySize/xSize)*1+1;
        if(totalDimonds >6 && totalDimonds*.10 + seconds <= 60)
            minutes+=(ySize/xSize)*1+1;
        else
        {
            minutes+=1;          
        }
        if(minutes ==0)
           minutes=2;
     }
    
    public int getMinutes()
    {
        return minutes;    
    }

    public int getSeconds()
    {
        return seconds;
    }
}//end class
