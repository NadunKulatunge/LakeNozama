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
class GridLocation {
    private final int xPos;
    private final int yPos;
    private boolean occupied;
    private String occupant;
    private LotusFlower flower;
    
    private Observer observer;
    private boolean isObserver;
    
    GridLocation(int X,int Y){
        this.xPos = X;
        this.yPos = Y;
    }
    public boolean getOccupied(){
        return occupied; //if no warrior returns false, if warrior return true 
    }
    public void RemoveOccupied(){
        this.occupied = false;
    }
    public void MakeOccupied(){
        this.occupied = true;
    }
    public boolean isAvailable(){
        if(occupied==false && occupant==null){
            return true; //the space is free(available to place inhabitants) so this method will return true
        }else{
            return false;
        }
    }
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    public void setOccupant(String oc){
        this.occupant = oc;
    }
    public String getOccupant(){//Warriors dont come in as Occupants only Fish,Flowers,Treasure come in as an Occupant
        return occupant;
    }
    public boolean isFlower(){
        if (occupant=="Flower"){
            return true;
        }else{
            return false;
        }
    }
    public void setFlower(LotusFlower fl){
        this.flower = fl;
    }
    public LotusFlower getFlower(){
        return flower;
    }
    
    public void addObserver(Observer o){
        this.observer = o;
        isObserver = true;
    }
    public boolean getisObserver(){
        return isObserver;
    }
    public void notify(Warrior Wa){
        observer.update(Wa);  
    }
    
    
}
