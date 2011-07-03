package guestbook

import javax.jdo.JDOHelper 
import javax.jdo.PersistenceManagerFactory 

class PMF {
	private static final PersistenceManagerFactory pmfInstance =
	JDOHelper.getPersistenceManagerFactory("transactions-optional");
	
	private PMF() {
	}
	
	public static PersistenceManagerFactory get() {
		return pmfInstance;
	}
	
}