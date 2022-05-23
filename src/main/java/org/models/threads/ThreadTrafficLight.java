package org.models.threads;

import org.models.TrafficLightColor;

public class ThreadTrafficLight implements Runnable {
	TrafficLightColor color = TrafficLightColor.RED; //default
	boolean stop;
	boolean colorChanged;

	public void run() {
	}

	public TrafficLightColor getColor() {
		return color;
	}

	public void setColor(TrafficLightColor color) {
		this.color = color;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean isColorChanged() {
		return colorChanged;
	}

	public void setColorChanged(boolean colorChanged) {
		this.colorChanged = colorChanged;
	}

}
