package org.services;

import static org.models.TrafficLightColor.GREEN;
import static org.models.TrafficLightColor.RED;
import static org.models.TrafficLightColor.YELLOW;

import org.models.threads.ThreadTrafficLight;

public class TrafficLightService {

	ThreadTrafficLight thread = new ThreadTrafficLight();
	private final long limitTime = 10000l; // 10s

	private synchronized void ChangeColor() {
		switch (thread.getColor()) {
		case RED:
			thread.setColor(GREEN);
			break;

		case YELLOW:
			thread.setColor(RED);
			break;

		case GREEN:
			thread.setColor(YELLOW);
			break;

		default:
			break;
		}
		thread.setColorChanged(true);
		notify();
	}

	public void waitColorChange() {
		while (!thread.isColorChanged()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		thread.setColorChanged(false);
	}

	public synchronized void stopTraficLight() {
		System.out.println("Killing the Thread");
		thread.setStop(true);
	}

	public void run() {
		long stopTime = System.currentTimeMillis() + limitTime;

		new Thread(thread).start();
		while (!thread.isStop() && System.currentTimeMillis() < stopTime) {
			try {
				System.out.println(thread.getColor());
				Thread.sleep(thread.getColor().getStandBy());
				ChangeColor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stopTraficLight();
	}
}
