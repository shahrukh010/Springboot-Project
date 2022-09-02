package com.code.main.observer.model;

import java.util.ArrayList;
import java.util.List;

import com.code.main.observer.controller.Observer;
import com.code.main.observer.controller.Subject;

public class EmailTopic implements Subject {

	private List<Observer> observer;
	private String message;

	public EmailTopic() {
		this.observer = new ArrayList<>();
	}

	@Override
	public void register(Observer observer) {

		if (observer == null)
			throw new NullPointerException("Null Object/Observer");

		if (!this.observer.contains(observer)) {

			this.observer.add(observer);
		}
	}

	@Override
	public void unregister(Observer observer) {

		this.observer.remove(observer);
	}

	@Override
	public void notifyObserver() {

		for (Observer observer : this.observer) {

			observer.update();
		}
	}

	@Override
	public Object getUpdate(Observer observer) {
		return this.message;
	}

	public void postMessage(String msg) {
		System.out.println("Message posted to my topic:" + msg);
		this.message = msg;

		notifyObserver();
	}

}
