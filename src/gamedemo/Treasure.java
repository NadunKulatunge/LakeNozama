/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import java.util.ArrayList;

/**
 *
 * @author 160317J
 */
class Treasure implements Observer{
    private GridLocation gl;
    private static ArrayList<Warrior> warriors= new ArrayList<>(); 
    Treasure(GridLocation gridLocation){
        this.gl = gridLocation;
        gl.setOccupant("Treasure");
        gl.addObserver(this);
    }
    public void Notify(){
        for(Warrior Wa : warriors){
            Wa.setWinner(true);
        }
    }
    public void update(Warrior Wa){
        System.out.println(Wa.getName() + " warrior swam to the Treasure Chest");
        GameDemo.gameEnd(Wa.getName() + " warrior won the game");
        System.out.println(Wa.getName() + " warrior won the game");
        Notify();
    }

    public static ArrayList<Warrior> getWarriors() {
        return warriors;
    }
    public void addWarriors(Warrior Wa){
        warriors.add(Wa);
    }
}
