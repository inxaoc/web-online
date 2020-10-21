import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.itmo.model.Contact;
import edu.itmo.model.Email;
import edu.itmo.model.Mailbox;
import edu.itmo.service.MailService;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    
    Mailbox mail = Mailbox.getMailbox();
    
    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastname");
    String email = request.getParameter("email");
    
    Contact contact = new Contact(firstName, lastName, email);
    
    String topic = request.getParameter("topic");
    String body = request.getParameter("body");
    
    Contact[] contacts = new Contact[1];
    contacts[0] = contact;
    String[] topics = new String[1];
    topics[0] = topic;
    String[] bodies = new String[1];
    bodies[0] = body;
    
    MailService.populateEmails(contacts, bodies, topics);
    
    List<Email> emails = mail.getEmails();
    
    response.getWriter().print("<html><body>Всего писем в почтовом ящике: "+ emails.size());
    
    response.getWriter().print("<table border=\"1\" cellspacing=\"0\">");
    
    int i =1;
    for(Email e : emails) {
    	
    	response.getWriter().print("<tr>");
    	
    	response.getWriter().print("<td>"+i+"</td>");
    	response.getWriter().print("<td>"+e.getSender().getFirstName()+"</td>");
    	response.getWriter().print("<td>"+e.getTopic()+"</td>");
    	response.getWriter().print("<td>"+e.getBody()+"</td>");
    	
    	response.getWriter().print("</tr>");
    	i++;
    	
    }
    
    response.getWriter().print("</table>");
    
    response.getWriter().print("</body></html>");

  }
}