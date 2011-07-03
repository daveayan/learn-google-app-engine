package guestbook

import com.google.appengine.api.users.User 
import com.google.appengine.api.users.UserServiceFactory 
import java.util.logging.Logger 
import javax.jdo.PersistenceManager 
import javax.servlet.http.HttpServlet 
import javax.servlet.http.HttpServletRequest 
import javax.servlet.http.HttpServletResponse 

public class SignGuestbookServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(SignGuestbookServlet.class.getName());
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		User user = UserServiceFactory.userService.currentUser
		
		String content = req.getParameter ("content")
        Greeting greeting = new Greeting(user, content, new Date())

        PersistenceManager pm = PMF.get().persistenceManager
        
        try {
            pm.makePersistent(greeting)
        } finally {
            pm.close()
        }

		resp.sendRedirect("/guestbook.jsp")
	}
}