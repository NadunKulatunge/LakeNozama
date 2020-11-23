/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 160317J
 */
class SuperWarrior extends Warrior {
    GridLocation checkLoc;
    
    SuperWarrior(Grid g, GridLocation gl, String Name, Treasure t){
        super(g,gl,Name,t);
        System.out.println("Super Warrior " + super.getName() + " created on (" + gl.getX() +","+ gl.getY()+")");
    }
    
    public void eat(){
        System.out.println("Super Warrior " + super.getName() + " ate.");
    }
    @Override
    public void swimRandom(){//Super Warrior Swim method override
        if(this.getImmortal()==false){ //Super warrior will only use bino if he's not immortal
            super.swimRandom();
            useBinocular();
        }else{
            super.swimRandom();
        }
    }
    public int getRandom(int min,int max){//method to generate random number in the range min and max
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public void sleep(){
        System.out.println("Super Warrior " + super.getName() + " slept.");
    }
    public void useBinocular(){//Binocular feature of the Super Warrior 
        //checking for flowers in every direction and if flower found takes it
        System.out.println("Super Warrior " + this.getName() + " searching for Magic Flowers");
        if(getGridLocation().getX()!=0){
            checkLoc = getGrid().getLoc(getGridLocation().getX()-1,getGridLocation().getY());
            if(checkLoc.isFlower()){
                System.out.println("Super Warrior " + this.getName() + " found a Magic Flower");
                this.setImmortal();
                System.out.println("Super Warrior " + this.getName() + " is now immortal");
            }
        }
        if(getGridLocation().getX()!=10){
            checkLoc = getGrid().getLoc(getGridLocation().getX()+1,getGridLocation().getY());
            if(checkLoc.isFlower()){
                System.out.println("Super Warrior " + this.getName() + " found a Magic Flower");
                this.setImmortal();
                System.out.println("Super Warrior " + this.getName() + " is now immortal");
            }
        }
        if(getGridLocation().getY()!=0){
            checkLoc = getGrid().getLoc(getGridLocation().getX(),getGridLocation().getY()-1);
            if(checkLoc.isFlower()){
                System.out.println("Super Warrior " + this.getName() + " found a Magic Flower");
                this.setImmortal();
                System.out.println("Super Warrior " + this.getName() + " is now immortal");
            }
        }
        if(getGridLocation().getY()!=10){
            checkLoc = getGrid().getLoc(getGridLocation().getX(),getGridLocation().getY()+1);
            if(checkLoc.isFlower()){
                System.out.println("Super Warrior " + this.getName() + " found a Magic Flower");
                this.setImmortal();
                System.out.println("Super Warrior " + this.getName() + " is now immortal");
            }
        }

    }
}
