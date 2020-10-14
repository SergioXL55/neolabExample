package com;

import com.service.TrackingService;
import com.service.impl.AnimalTracking;
import com.util.FileUtil;
import org.apache.log4j.Logger;

public class Runner {

    final static Logger logger = Logger.getLogger(FileUtil.class);

    public static void main(String[] args) {
        System.out.println("The program is started.");
        TrackingService animalTrackingService = new AnimalTracking();
        animalTrackingService.calculateAnimalsCount();
        System.out.println(animalTrackingService.getAnimalCountResult());
        System.out.println("The program is over.");
    }
}
