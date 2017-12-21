package sets;

import java.util.Iterator;

import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
	private LinkedNode<E> current;
	
	
  // Constructors
  public LinkedNodeIterator(LinkedNode<E> head) {
	  current = head;
	  
  }

  @Override
  public boolean hasNext() {
	 return (current != null);
  }

  @Override
  public E next() {
	if(hasNext()){
		E data = current.getData();
		current = current.getNext();
		return data;
	}
	
	throw new NoSuchElementException();

  }

  @Override
  public void remove() {
    // Nothing to change for this method
    throw new UnsupportedOperationException();
  }
}
