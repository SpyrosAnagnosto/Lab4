package www;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
//@NamedQuery    (query ="Select u from User AS u WHERE u.username = :username", name ="uname")


public class User {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private int id;
	   private String username;
	   private String pwd;
	   private String email;
	   private String fullname;
	   private String bday;
	   
	   public User( int id,String username, String pwd,String email,String fullname,String bday) {
	      super( );
	      this.id= id;
	      this.username = username;
	      this.pwd = pwd;
	      this.email = email;
	      this.fullname = fullname;
	      this.bday = bday;
	   }

	   public User( ) {
	      super();
	   }
	   
	   public int getId( ) {
		      return id;
	   }
	   
	   public String getUsername( ) {
	      return username;
	   }
	   
	   public String getPwd( ) {
		      return pwd;
	   }
	   
	   public String getEmail( ) {
		      return email;
	   }
	   
	   public String fullname( ) {
		      return fullname;
	   }
		   
		   
	   public String getBday( ) {
			  return bday;
	   }
	   
	   public void setId(int id) {
	      this.id = id;
	   }
	   
	   public void setUsername(String username) {
		      this.username = username;
	   }
	   
	   public void setPassword(String pwd) {
		      this.pwd = pwd;
	   }
	   
	   public void setEmail(String email) {
		      this.email = email;
	   }
	   
	   public void setFullname(String fullname) {
		      this.fullname = fullname;
	   }
		   
	   
		   
	   public void setBday(String bday) {
			  this.bday = bday;
	   }
	   
	   @Override
	   public String toString() {
	      return "User [username=" + username + ", password=" + pwd + ", email=" + email+ ", fullname= " + fullname + ", bday=" + bday+"]";
	   }
}