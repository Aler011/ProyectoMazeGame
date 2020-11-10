
import javax.swing.*;

public class TheArchitect extends JFrame {
    public void setExit(int WallXCord, int WallYCord) { //records the location of the exit so we can show it when its time
        this.WallXCord = WallXCord;
        this.WallYCord = WallYCord;
    }

    public void showWall() { //used when its time to show the exit.  
        updatedMatrix[WallXCord][WallYCord] = "E";
    }

    public void playerMove(int xScale, int yScale, String[][] currentMatrix,int totalDimonds)throws StupidAssMove
    {
       int x=0;
       int y=0;
       int found=0; 
       globalTotalDimonds=totalDimonds; //use this later for the gui dimond count
       nextLevel(false); //dont go to the next level yet.
       String[][] junkMatrix=currentMatrix;//we will be updating currentMatrix  
        for (int i = 0; i < currentMatrix.length; i++) { //for loop will find were the player is now
        
        for (int j = 0; j < currentMatrix[i].length; j++) 
        {
           if(currentMatrix[i][j].equals("P")) {//La matriz actual se topó con la posición del jugador.
           
            x=i;//record the players position
            y=j;
            found = 1;
            break;
           }
        }}
            if(currentMatrix[x+xScale][y+yScale].equals("H")) { //La matriz actual se topó con un diamante escondido("H").
            
                currentMatrix[x][y]="N";
                currentMatrix[x+xScale][y+yScale]="P";
                currentMatrix[x][y]="N";
                Collected+=1;//we got a hidden dimond! wow!
            }
            else if(currentMatrix[x+xScale][y+yScale].equals("D")) { //La matriz actual se topó con un diamante("D").
            
                currentMatrix[x][y]="N";
                currentMatrix[x+xScale][y+yScale]="P";
                Collected+=1;//we got a dimond
            }
            else if(currentMatrix[x+xScale][y+yScale].equals("M") && currentMatrix[x+(xScale*2)][y+(yScale*2)].equals("N")) {//La matriz actual se topó con una pared movible("N").
            
                currentMatrix[x][y]="N";
                currentMatrix[x+xScale][y+yScale]="P"; 
                currentMatrix[x+(xScale*2)][y+(yScale*2)]="M";
            }
            else if (currentMatrix[x+xScale][y+yScale].equals("N")) { //La matriz actual no se topó con nada("N"), realizó un movimientoi normal.
            
                currentMatrix[x][y]="N";
                currentMatrix[x+xScale][y+yScale]="P"; 
            }
            else if (currentMatrix[x+xScale][y+yScale].equals("E")) {//La matriz actual se topó con la salida("E").
            
                currentMatrix[x][y]="N";
                currentMatrix[x+xScale][y+yScale]="P"; 
                nextLevel(true);//allow the next level to be loaded.
            }
            else {
               throw new StupidAssMove("Ass Hole hit wall!");
            }
            if(Collected==totalDimonds) {//if we have all the dimonds give the player the exit //if 7
            showWall();
            }   
            updatedMatrix=currentMatrix;  //we will return updatedMatrix for the gui                     
        }

    public void nextLevel(boolean tOrF)//true we go to next level, false we update current level's gui 
    {
        level=tOrF;
    }
    
    public boolean getLevel()//returs level true or false
    {
        return level;
    }
        
    public int getDimondsLeft()
    {
        return globalTotalDimonds-Collected;//for GUI JLabel, show how many dimonds are left to be collected
    }
    
    public String[][] getUpdatedMatrix()//returns the updated matrix for the gui to display
    {
        return updatedMatrix;    
    }
    
    private class StupidAssMove extends RuntimeException
    {
         public StupidAssMove(String event)
         {
             JFrame frame = new JFrame("Warning");
             JOptionPane.showMessageDialog(frame, "You Stupid Ass, Ran into something did you?");
         }
    }
    
    int foundPlayer = 0;
    String[][] updatedMatrix;
    int WallXCord;
    int WallYCord;
    int Collected = 0;
    boolean level;
    int globalTotalDimonds = 0;
}
