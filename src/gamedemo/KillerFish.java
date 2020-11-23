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
class KillerFish extends Fish{
    KillerFish(GridLocation gridLocation, String Name,String fishType){
        super(gridLocation,Name,fishType);
    }
    public void Kill(Warrior Wa){
        Wa.Die();
    }
    @Override
    public void update(Warrior Wa){
        if(Wa.Die()){
            System.out.println(Wa.getName() + " warrior was eaten by a killer fish");
        }else{
            System.out.println(Wa.getName() + " warrior(Immortal) met a killer Fish");
        }
    }
}
