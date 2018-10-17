package fr.afcepf.al32.groupe2.entity;

/**
 * Interface to put on entity which can follow an IFollowableElement.
 * Methods specific to ISubscriber are put in ISubscriberService because of the difficulty of injecting a dao in an entity (can't manage to make aspect work). 
 * @author aguilhem
 *
 */
public interface ISubscriber {
	String getType();
	
	Long getId();

}
