package guestbook

import java.util.logging.Logger;

import javax.mail.Message 
import javax.mail.Session 
import javax.mail.Transport 
import javax.mail.internet.InternetAddress 
import javax.mail.internet.MimeMessage 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class EmailQueue extends HttpServlet {
	private static final Logger log = Logger.getLogger(this.class.getName())
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		
		try {
		Properties props = new Properties()
		Session session = Session.getDefaultInstance(props)
		
		Message message = new MimeMessage(session)
		message.from = new InternetAddress("adave@quicksolutions.com", "My QSI Email")
		message.addRecipient Message.RecipientType.TO, new InternetAddress("adave@quicksolutions.com")
		message.subject = "Test Queue Email from TestApp"
		message.text = "How are you ?. Sent from Queue"
		Transport.send message
		} catch (Throwable th) {
			th.printStackTrace();
		}
		resp.sendRedirect "/guestbook.jsp"
	}
}