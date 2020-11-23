/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import static gamedemo.GameDemo.al;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 160317J
 */
abstract class Warrior implements Inhabitants, Runnable{
    private boolean Fins = true;
    private boolean Immortal = false;
    private boolean Alive = true;
    private int id;
    private static int NumberOfWarriors=0; //to keep track of Number of warriors (If random number of warriors created)
    private String Name;
    private Grid g;
    private GridLocation gl;
    private GridLocation newLoc;
    private boolean winner;
    private Treasure t;
    Warrior(Grid grid, GridLocation gridLocation, String Name,Treasure t){
        this.id = ++NumberOfWarriors;
        this.Name = Name;
        this.g = grid;
        this.gl = gridLocation;
        this.winner = false;
        this.t = t;
        gridLocation.MakeOccupied();
        Inhabitants i = this;
        GameDemo.al.add(i);
        t.addWarriors(this);
        
    }

    public void run(){
        while((Alive && Fins) && (!winner)){
            swimRandom();
        }
        
        
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    
    public int getRandom(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public GridLocation selectLocation(int way){
        switch (way) {
            case 1://up
                if(gl.getY()!=10){
                    newLoc = g.getLoc(gl.getX(),gl.getY()+1);
                }else{
                    newLoc = null;
                }
                    break;
            case 2://right
                if(gl.getX()!=10){
                    newLoc = g.getLoc(gl.getX()+1,gl.getY());
                }else{
                    newLoc = null;
                }
                     break;
            case 3://down
                if(gl.getY()!=0){
                    newLoc = g.getLoc(gl.getX(),gl.getY()-1);
                }else{
                    newLoc = null;
                }
                     break;
            case 4://left
                if(gl.getX()!=0){
                    newLoc = g.getLoc(gl.getX()-1,gl.getY());
                }else{
                    newLoc = null;
                }
                     break;
        }
        return newLoc;
    }
    public void swimRandom(){
        int x;
        boolean locationSelected = false;
        while(!locationSelected){
            x = getRandom(1,4);
            if(swim(selectLocation(x))){
                locationSelected = true;
            }
        }
    }
    public String getName(){
        return Name;
    }
    public static int getNumberOfWarriors(){
        return NumberOfWarriors;
    }
    public int getId(){
        return id;
    }
    
    public boolean getFins(){
        return Fins;
    }
    public void setFins(boolean Fins){
        this.Fins = Fins;
    }
    
    public boolean getImmortal(){
        return Immortal;
    }
    public void setImmortal(){
        this.Immortal = true;
    }
    
    public boolean getAlive(){
        return Alive;
    }
    public void setAlive(){
        this.Alive = false;
    }
    
    public void PickLotus(){
        this.setImmortal();
    }
    public void LooseFins(){
        this.Fins = false;
    }
    public boolean Die(){
        if(this.Immortal==false){
            this.Alive = false;
            return true;
        }else{
            return false;
        }
    }
    public Grid getGrid(){
        return g;
    }
    public GridLocation getGridLocation(){
        return gl;
    }
    public boolean swim(GridLocation newLoc){
            if (newLoc!=null){
                synchronized(newLoc){
                    if (!newLoc.getOccupied()){
                        gl.RemoveOccupied();
                        gl = newLoc;
                        gl.MakeOccupied();
                        System.out.println(Name + " warrior swam to: " + "(" + gl.getX() + ","+ gl.getY() + ")");
                        if(gl.getisObserver()){
                            gl.notify(this);
                        }
                        return true;
                    }else{
                        return false;
                    }
                }
            }else{
                return false;
            }

    }


}


