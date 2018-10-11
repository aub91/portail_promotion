package fr.afcepf.al32.groupe2.entity;

public interface IFollowableElement {

	void addSubscriber(ISubscriber subscriber);
	
	void removeSubscriber(ISubscriber subscriber);
	
	void notifySubscribers();

}
