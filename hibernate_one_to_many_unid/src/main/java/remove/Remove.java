package remove;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class Remove {

	public static void main(String[] args) {
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_unid");
		    EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			// remove of Book -> 102
			
			Author a=em.find(Author.class, 1);
			Book b=null;
			List<Book> books=a.getBooks();
			
			Iterator <Book>it2=books.iterator();
			
			while(it2.hasNext()) {
				Book tem=it2.next();
				if(tem.getId()==102) {
					b=tem;
					it2.remove();//removing book present in author List with id 102
					}
				}//end of while
			
			et.begin();
			em.merge(a);
			em.remove(b);
			et.commit();
	}

}
