/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

/**
 *
 * @author 160317J
 */
class Grid {
    GridLocation[][] grid; //making a 2D array to put GridLocations(This will be related to the code in line 18))
    Grid(){
        grid = new GridLocation[11][11]; //Creating the 2D array inside the constructar
        for(int y=0; y<11; y++){ 
            for(int x=0; x<11; x++){
                grid[y][x] = new GridLocation(x,y);//generating GridLocation objects and adding them into the grid
            }
        }
    }
    public void addInhabitant(Inhabitants i,int x, int y){
        
    }
    public GridLocation getLoc(int x,int y){
        return grid[y][x];
    }
}
