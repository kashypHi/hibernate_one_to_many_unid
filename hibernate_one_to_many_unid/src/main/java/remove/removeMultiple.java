package remove;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class removeMultiple {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_unid");
	    EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//Book-> 102,104
		
		Author a=em.find(Author.class, 1);
		
		List<Book> books=a.getBooks();
		List<Book> books2=new ArrayList<Book>();
		
		Iterator<Book> itr=books.iterator();
		
		while(itr.hasNext()) {
			Book temp=itr.next();
			
			if(temp.getId()==102 ||temp.getId()==104) {
				books2.add(temp);
				itr.remove();
			}
		} //End of while
		
		et.begin();
		em.merge(a);
		
		for(Book b:books2) {
			em.remove(b);
		}
		et.commit();
	}

}
