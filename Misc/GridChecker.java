/**
 * Author: Andrew Zurn
 * Date: 11/09/12
 */
public class GridChecker{
  
  public static boolean checkGrid(String[][] grid){ //return true if in compliance, false if not
    for(int i = 0; i<5; i++){ //rows
      for(int j = 0; j<5; j++){ //columns
        String animal = grid[i][j];
        if(animal == null || animal == "") break;
        
        String badAnimal = "";
        if (animal == "mongoose") badAnimal = "snake";
        else if(animal == "snake") badAnimal = "mouse";
        else if(animal == "mouse") badAnimal = "elephant";
        else if (animal == "elephant") badAnimal = "mouse";
        
        boolean notCompliant = checkSurrounding(badAnimal, grid, i, j);
        if(notCompliant == true) return false;
      }
    }
    return true;
  }
  
  public static boolean checkSurrounding(String badAnimal, String[][] grid, int i, int j){ //return true if a rule is broken
    try{ //up
      if( grid[i-1][j] == badAnimal){
        return true;
      }
    }
    catch(Exception ie){} //index out of bounds
    try{ //down
      if( grid[i+1][j] == badAnimal){
        return true;
      }
    }
    catch(Exception ie){} //index out of bounds
    try{ //left
      if( grid[i][j-1] == badAnimal){
        return true;
      }
    }
    catch(Exception ie){} //index out of bounds
    try{ //right
      if( grid[i][j+1] == badAnimal){
        return true;
      }
    }
    catch(Exception ie){} //index out of bounds
    try{ //up-right
      if( grid[i-1][j+1] == badAnimal){
        return true;
      }
    }
    catch(Exception ie){} //index out of bounds
    try{ //up-left
      if( grid[i-1][j-1] == badAnimal){
        return true;
      }
    }
    catch(Exception ie){} //index out of bounds
    try{ //down-right
      if( grid[i+1][j+1] == badAnimal){
        return true;
      }
    }
    catch(Exception ie){} //index out of bounds
    try{ //down-left
      if( grid[i+1][j-1] == badAnimal){
        return true;
      }
    }
    catch(Exception ie){} //index out of bounds
    return false;
  }
  
  public static void main(String[] args){
    String grid1[][] = new String[5][5]; //bad grid
    grid1[0][4] = "mongoose";
    grid1[2][2] = "snake";
    grid1[3][0] = "mongoose";
    grid1[3][2] = "elephant";
    grid1[4][0] = "snake";
    grid1[4][2] = "mouse";
    String grid2[][] = new String[5][5]; //good grid
    grid2[0][0] = "snake";
    grid2[0][3] = "moose";
    grid2[1][0] = "elephant";
    grid2[2][2] = "mongoose";
    grid2[2][4] = "mongoose";
    grid2[4][2] = "elephant";
    System.out.println("Grid 1's compliance is: " + GridChecker.checkGrid(grid1)); 
    System.out.println("Grid 2's compliance is: " + GridChecker.checkGrid(grid2)); 
  }
}