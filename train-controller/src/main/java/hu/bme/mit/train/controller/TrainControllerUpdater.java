package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.TimerTask;

/**
 * Created by Thomas on 2017. 03. 20..
 */
public class TrainControllerUpdater extends TimerTask {
    private TrainController trainController;

    public TrainControllerUpdater(TrainController trainController) {
        this.trainController = trainController;
    }

    @Override
    public void run() {
        trainController.followSpeed();
    }
}
