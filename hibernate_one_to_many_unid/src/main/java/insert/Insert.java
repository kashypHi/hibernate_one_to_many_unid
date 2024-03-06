package insert;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class Insert {

	public static void main(String[] args) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_unid");
    EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Book b1=new Book(101,"champak",145.0);
	Book b2=new Book(102,"Motupatlu",195.0);
	Book b3=new Book(103,"RajaRani",250.0);
	
	
	List<Book> books1=new ArrayList<Book>();
	books1.add(b1);
	books1.add(b2);
	
	List<Book> books2=new ArrayList<Book>();
	books2.add(b3);
	
	Author a1=new Author(1,"Anuj",books1);
	Author a2=new Author(2,"Raman",books2);
	
	et.begin();
	em.persist(b1);
	em.persist(b2);
	em.persist(b3);
	em.persist(a2);
	em.persist(a1);
	et.commit();
	
	}

}
