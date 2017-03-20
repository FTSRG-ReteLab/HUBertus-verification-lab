package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

/**
 * Created by Zsolti on 2017. 03. 20..
 */
public class FollowSpeedPeriodically extends  Thread {
    private TrainController controller;


    public  FollowSpeedPeriodically(TrainController Controller){
        this.controller = Controller;

    }

    @Override
    public void run()
    {
        while(true) {
            controller.followSpeed();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
