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
class LotusFlower implements Observer{
    private int petals;
    private GridLocation gl;
    
    LotusFlower(GridLocation gridLocation){
        this.gl = gridLocation;
        this.petals = 100;
        gl.setOccupant("Flower");
        gl.addObserver(this);
        gl.setFlower(this);
        
    }
    public void Pluck(Warrior Wa){
        if (petals > 0){
            Wa.PickLotus();
            petals = petals - 1;
        }
    }
    public void update(Warrior Wa){  
        if(Wa.getImmortal()==false){
            this.Pluck(Wa);
            System.out.println(Wa.getName() + " warrior became immortal");
        }
    }
}
