package org.controllers;

import org.services.TrafficLightService;

public class TrafficLightController {

	TrafficLightService traficLightservice = new TrafficLightService();

	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(traficLight.getColor());
//			traficLight.waitColorChange();
//		}
//		traficLight.stopTraficLight();
		new TrafficLightService().run();
	}

}
