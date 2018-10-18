package fr.afcepf.al32.groupe2.entity;

/**
 * Interface to put on entity which are followable by an ISuscriber.
 * Methods specific to IFOllowable are put in IFollowableElementService because of the difficulty of injecting a dao in an entity (can't manage to make aspect work). 
 * @author aguilhem
 *
 */
public interface IFollowableElement {
	String getType();
	
	Long getId();
}
