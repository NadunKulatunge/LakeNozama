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
class NormalWarrior extends Warrior{
    NormalWarrior(Grid g, GridLocation gl, String Name,Treasure t){
        super(g, gl, Name,t);
        System.out.println("Normal Warrior " + Name + " created on (" + gl.getX() +","+ gl.getY()+")");
    }
    public void eat(){
        System.out.println("Normal Warrior "+ super.getName() +" ate.");
    }
    public void sleep(){
        System.out.println("Normal Warrior "+ super.getName() +" slept.");
    }     
}
