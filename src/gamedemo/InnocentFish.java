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
class InnocentFish extends Fish{
    InnocentFish(GridLocation gridLocation,String Name,String fishType){
        super(gridLocation,Name,fishType);
    }
    @Override
    public void update(Warrior Wa){
        System.out.println(Wa.getName() + " warrior met the Innocent Fish");
    }
}
