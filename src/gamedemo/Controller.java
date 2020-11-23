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
class Controller {
    Grid grid;
    NormalWarrior wa1;
    NormalWarrior wa2;
    SuperWarrior wa3;
    SuperWarrior wa4;
    Controller(){
       
        grid = new Grid();
        Treasure t = new Treasure(grid.getLoc(5,5));
        
        
        wa1 = new NormalWarrior(grid, grid.getLoc(0, 0), "Jett",t);
        wa2 = new NormalWarrior(grid, grid.getLoc(10, 0), "Raiden",t);
        wa3 = new SuperWarrior(grid, grid.getLoc(10, 10), "Scorpion",t);
        wa4 = new SuperWarrior(grid, grid.getLoc(0, 10), "Sub-Zero",t);
        
        Thread w1 = new Thread(wa1);
        Thread w2 = new Thread(wa2);
        Thread w3 = new Thread(wa3);
        Thread w4 = new Thread(wa4);
        
        Fish if1 = new InnocentFish(getFreeLocation(0,10), "Nemo", "InnocentFish");
        Fish if2 = new InnocentFish(getFreeLocation(0,10), "Marlin", "InnocentFish");
        Fish rf1 = new RubberFish(getFreeLocation(0,10), "Lenny", "RubberFish");
        Fish rf2 = new RubberFish(getFreeLocation(0,10), "Dory", "RubberFish");  
        Fish kf1 = new KillerFish(getFreeLocation(0,10), "Goro", "KillerFish");
        Fish kf2 = new KillerFish(getFreeLocation(0,10), "Jabberjaw", "KillerFish");
                
        LotusFlower lf1 = new LotusFlower(getFreeLocation(0,10));
        LotusFlower lf2 = new LotusFlower(getFreeLocation(0,10));
        LotusFlower lf3 = new LotusFlower(getFreeLocation(0,10));
        LotusFlower lf4 = new LotusFlower(getFreeLocation(0,10));
        LotusFlower lf5 = new LotusFlower(getFreeLocation(0,10));
        
        System.out.println("All the Inhabitants:");
        for(Inhabitants x:al){
            System.out.print(x.getName()+ ", ");
        }
        w1.start();
        w2.start();
        w3.start();
        w4.start();
        
        System.out.println("\n -------------------------------");
        
        //sw1.useBinocular("left"); //making the SW1 use bino to his left
    }
    public int getRandom(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public GridLocation getFreeLocation(int min,int max){
        boolean locationSelected = false;
        GridLocation x;
        while (!locationSelected){
            x = grid.getLoc(getRandom(min,max), getRandom(min,max));
            if(x.isAvailable()){
                locationSelected = true;
                return x;
            }
        }
        return null;
    }
   
}
