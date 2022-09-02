package com.code.main;

import com.code.main.observer.model.EmailTopic;
import com.code.main.observer.model.EmailTopicSubscriber;

public class ObserverMain {

	public static void main(String... strings) {

		EmailTopic topic = new EmailTopic();

		EmailTopicSubscriber firstSubscriber = new EmailTopicSubscriber("First Subscriber");
		EmailTopicSubscriber secondSubscriber = new EmailTopicSubscriber("Second subscriber");
		EmailTopicSubscriber thirdSubscriber = new EmailTopicSubscriber("Third subscriber");

		topic.register(firstSubscriber);
		topic.register(secondSubscriber);
		topic.register(thirdSubscriber);

		firstSubscriber.SetSubject(topic);
		secondSubscriber.SetSubject(topic);
		thirdSubscriber.SetSubject(topic);

		firstSubscriber.update();
		thirdSubscriber.update();

		topic.postMessage("Hello Subscribers!");
		topic.unregister(firstSubscriber);
		topic.postMessage("Today we are going to live at 4:45");

	}

}