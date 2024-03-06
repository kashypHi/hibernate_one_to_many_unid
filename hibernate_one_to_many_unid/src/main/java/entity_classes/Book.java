package entity_classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	
@Id
private int id;
private String name;
private double cost;

public Book() {
	
}

public Book(int id, String name, double cost) {
	super();
	this.id = id;
	this.name = name;
	this.cost = cost;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

@Override
public String toString() {
	return "Book [id=" + id + ", name=" + name + ", cost=" + cost + "]";
}

}
