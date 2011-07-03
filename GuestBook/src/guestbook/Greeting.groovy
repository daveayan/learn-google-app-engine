package guestbook

import java.util.logging.Logger;

import com.google.appengine.api.datastore.Key 
import com.google.appengine.api.users.User 
import javax.jdo.annotations.IdGeneratorStrategy 
import javax.jdo.annotations.PersistenceCapable 
import javax.jdo.annotations.Persistent 
import javax.jdo.annotations.PrimaryKey 

@PersistenceCapable
class Greeting {
	
	private static final Logger log = Logger.getLogger(Greeting.class.getName())
	
	public String toString() {
		return "$author wrote on $date, $system_date, $cron_job_run_count, $task_queue_run_count \n $content"
	}
	
	public Greeting(User author, String content, Date date) {
		this.author = author
		this.content = content
		this.date = date
		this.system_date = new Date()
		this.cron_job_run_count = 0
		this.task_queue_run_count = 0
	}
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public Key key
	
	@Persistent
	public User author
	
	@Persistent
	public String content
	
	@Persistent
	public Date date
	
	@Persistent
	private Date system_date
	
	@Persistent
	private Integer cron_job_run_count
	
	@Persistent
	private Integer task_queue_run_count
	
	@Persistent private String address
}