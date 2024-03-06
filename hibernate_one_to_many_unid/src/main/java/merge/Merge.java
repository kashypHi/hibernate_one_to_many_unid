package merge;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class Merge {

	public static void main(String[] args) {
		    EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_unid");
		    EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			//Book b1=new Book(104,"Rich Man",325);
			//Book b2=new Book(105,"Humour",220);
			
			Book b3=new Book (102,"Ram nam",120);
			
			Author a=em.find(Author.class, 1);
			
			//a.getBooks().add(b1);
			//a.getBooks().add(b2);
			a.getBooks().add(b3);
			
			et.begin();
		//	em.persist(b1);
		//	em.persist(b2);
			em.persist(b3);
			em.merge(a);
			et.commit();
			
	}

}
