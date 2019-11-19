package www;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import www.User;

public class Services {

	public Services(){
	}
	//Finds newest id
	public int maxid() {

		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "Lab4" );
	    EntityManager entitymanager = ufactory.createEntityManager();
	    TypedQuery<User> query = entitymanager.createQuery("Select u.id from User AS u",User.class);
	    List<User> list = query.getResultList();
	    
	    StringBuilder sb = new StringBuilder();
	    for (Object object : list) {
	        sb.append(object);
	    }
	    String s=sb.toString();
	    char c = s.charAt(s.length()-1);
	    int  i=Character.getNumericValue(c); 
	    
	    entitymanager.close( );
	    ufactory.close( );
	    return i;
	}
	
	//Existence checks
	public boolean accountExist(String username,String pwd) {
		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "Lab4" );
	    EntityManager entitymanager = ufactory.createEntityManager();
	    TypedQuery<User> query = entitymanager.createQuery("Select u from User AS u WHERE u.username = :username AND u.pwd=:pwd",User.class);
	    query.setParameter("username", username);
	    query.setParameter("pwd", pwd);
	    List<User> list = query.getResultList();
	    if(list.isEmpty()) {
	    	entitymanager.close( );
		    ufactory.close( );
	    	return false;
	    }
	    entitymanager.close( );
	    ufactory.close( );
		return true;
	}
	
	public boolean usernameExist(String username) {
		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "Lab4" );
	    EntityManager entitymanager = ufactory.createEntityManager();
	    TypedQuery<User> query = entitymanager.createQuery("Select u from User AS u WHERE u.username = :username",User.class);
	    query.setParameter("username", username);
	    List<User> list = query.getResultList();
	    if(list.isEmpty()) {
	    	entitymanager.close( );
		    ufactory.close( );
	    	return false;
	    }
	    entitymanager.close( );
	    ufactory.close( );
		return true;
	}
	
	public boolean pwdExist(String pwd) {
		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "Lab4" );
	    EntityManager entitymanager = ufactory.createEntityManager();
	    TypedQuery<User> query = entitymanager.createQuery("Select u from User AS u WHERE u.pwd=:pwd",User.class);
	    query.setParameter("pwd", pwd);
	    List<User> list = query.getResultList();
	    if(list.isEmpty()) {
	    	entitymanager.close( );
		    ufactory.close( );
	    	return false;
	    }
	    entitymanager.close( );
	    ufactory.close( );
		return true;
	}
	
	public boolean emailExist(String email) {
		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "Lab4" );
	    EntityManager entitymanager = ufactory.createEntityManager();
	    TypedQuery<User> query = entitymanager.createQuery("Select u from User AS u WHERE u.email=:email",User.class);
	    query.setParameter("email", email);
	    List<User> list = query.getResultList();
	    if(list.isEmpty()) {
	    	entitymanager.close( );
		    ufactory.close( );
	    	return false;
	    }
	    entitymanager.close( );
	    ufactory.close( );
		return true;
		
	
	}
	
	
}
