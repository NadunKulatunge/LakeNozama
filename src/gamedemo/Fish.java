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
abstract class Fish implements Inhabitants, Observer{
    private int id;
    private static int NumberOfFish=0;
    private String Name;
    private GridLocation gl;
    
    Fish(GridLocation gridLocation, String Name, String fishType){
        this.id = ++NumberOfFish;
        this.Name = Name;
        this.gl = gridLocation;
        gridLocation.setOccupant(fishType);
        gridLocation.addObserver(this);
        Inhabitants i = this; //taking this object as inhabitants variable and adding it into the semester 2 al arraylist which is also in type inhabitants 
        GameDemo.al.add(i);
        System.out.println(fishType + " created on (" + gl.getX() +","+ gl.getY()+")");
        
    }
    public static int getNumberOfFish(){
        return NumberOfFish;
    }
    public int getId(){
        return id;
    }

    @Override
    public String getName() {
        return Name;
    }

    public GridLocation getGridLocation() {
        return gl;
    }
    abstract public void update(Warrior Wa);
}
