package sets;

import java.util.Iterator;

/**
 * A LinkedList-based implementation of Set
 */

  /********************************************************
   * NOTE: Before you start, check the Set interface in
   * Set.java for detailed description of each method.
   *******************************************************/
  
  /********************************************************
   * NOTE: for this project you must use linked lists
   * implemented by yourself. You are NOT ALLOWED to use
   * Java arrays of any type, or any Collection-based class 
   * such as ArrayList, Vector etc. You will receive a 0
   * if you use any of them.
   *******************************************************/ 

  /********************************************************
   * NOTE: you are allowed to add new methods if necessary,
   * but do NOT add new files (as they will be ignored).
   *******************************************************/

public class LinkedSet<E> implements Set<E> {
  private LinkedNode<E> head;
  

  // Constructors
  public LinkedSet() {
	  head = null;
  }

  public LinkedSet(E e) {
    this.head = new LinkedNode<E>(e, null);
  }

 private LinkedSet(LinkedNode<E> head) {
  	
  }

  @Override
  public int size() {
	int count = 0;
	for(E e: this){
		count ++;
	}
	return count;
  }

  @Override
  public boolean isEmpty() {
	  if(head == null)
	  {
		 return true;
	  }
	  return false;
	  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedNodeIterator<E>(this.head);
   
    
  }

  @Override
  public boolean contains(Object o) {
	  for(E e: this){
		  if(e.equals(o)){
			  return true;
		  }
	  }
	  return false;
  }

  @Override
  public boolean isSubset(Set<E> that) {
	  boolean a = true;
	  for(E e: this){
		if(!that.contains(e)){
			a = false;
		}
	}return a;
  }

  @Override
  public boolean isSuperset(Set<E> that) {
	  boolean a = true;
	  for(E e: that){
		  if(!this.contains(e)){
			  a = false;
		  }
	  }return a;
  }

  @Override
 public Set<E> adjoin(E e) {  
	 LinkedSet<E> set = new LinkedSet<E>();
	 for(E a: this){
		 set.add(a);
	 }
	  if(set.contains(e)){
		  return set;
	  }
	  
	  set.add(e);
	  return set;
  }

  @Override
  public Set<E> union(Set<E> that) {
	  LinkedSet<E> list = new LinkedSet<E>();
	  for(E e: this){
		  list.add(e);
	  }
	  for(E e: that){
		  if(!list.contains(e))
		  list.add(e);
	  }
	  return list;
  }

  @Override
  public Set<E> intersect(Set<E> that) {
	  LinkedSet<E> newlist = new LinkedSet<E>();
	  for(E e: this){
		 if(that.contains(e)){
			 newlist.add(e);
		 }
	  }
	  return newlist;
  }

  @Override
  public Set<E> subtract(Set<E> that) {
    LinkedSet<E> set = new LinkedSet<E>();
    if(this == that){
    	return set;
    }
    
    for(E e : this){
    	if(!that.contains(e)){
    		set.add(e);
    	}
    }
    return set;
  }

  @Override
  public Set<E> remove(E e) {
	LinkedSet<E> newset = new LinkedSet<E>();
	for(E a : this){
		if(!a.equals(e)){
			( newset).add(a);
		}
	  }
	return newset;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (! (o instanceof Set)) {
      return false;
    }
    Set<E> that = (Set<E>)o;
    return this.isSubset(that) && that.isSubset(this);
  }

  @Override
    public int hashCode() {
    int result = 0;
    for (E e : this) {
      result += e.hashCode();
    }
    return result;
  }
  
public void add(E e){
	if(head == null){
		head = new LinkedNode<E>(e, null);
	}
	else
	{
		LinkedNode<E> temp = new LinkedNode<E>(e, head);
		head = temp;
	}
}
	
  
}
