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
class RubberFish extends Fish{
    RubberFish(GridLocation gridLocation,String Name,String fishType){
        super(gridLocation,Name,fishType);
    }
    public void StealFins(Warrior Wa){
        if (Wa.getFins()==true){
            Wa.setFins(false);
        }
    }
    @Override
    public void update(Warrior Wa){
        Wa.LooseFins();
        System.out.println(Wa.getName() + " warrior lost a Fin");
    }
                          
}
