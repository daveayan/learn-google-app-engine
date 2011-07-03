package guestbook;

import com.google.appengine.api.users.User 
import com.google.appengine.api.users.UserService 
import com.google.appengine.api.users.UserServiceFactory 
import javax.servlet.http.HttpServlet 
import javax.servlet.http.HttpServletRequest 
import javax.servlet.http.HttpServletResponse 


public class GuestBookServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		UserService userService = UserServiceFactory.getUserService()
		User user = userService.currentUser
		
		if (user) {
			resp.contentType = "text/plain"
			1.times{
				resp.writer.println "Hello, $user.nickname";
			}
		} else {
			resp.sendRedirect(userService.createLoginURL(req.getRequestURI()))
		}
	}
}