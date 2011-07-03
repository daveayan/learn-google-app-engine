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

import com.google.appengine.api.labs.taskqueue.TaskOptions;

class EmailQueueServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(this.class.getName())
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		TaskOptions taskOptions = TaskOptions.Builder.url("/emailqueue").param(address, "someaddress")
		Queue queue = QueueFactory.getQueue("email")
		queue.add(taskOptions)
	}
}
