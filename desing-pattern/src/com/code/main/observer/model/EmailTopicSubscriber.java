package com.code.main.observer.model;

import com.code.main.observer.controller.Observer;
import com.code.main.observer.controller.Subject;

public class EmailTopicSubscriber implements Observer {

	private String name;

	private Subject topic;

	public EmailTopicSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update() {

		String msg = (String) topic.getUpdate(this);
		if (msg == null)
			System.out.println("No new message on this topic");
		else
			System.out.println(this.name + " " + "Retreving message " + msg);
	}

	@Override
	public void SetSubject(Subject subject) {

		this.topic = subject;

	}

}
