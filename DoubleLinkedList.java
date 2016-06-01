import java.util.function.Predicate;

/**
 * Class for a circular double-ended list
 * @author Martin Appelmann 4685580 Group 2a 
 * @author Benjamin Effner 4633079 Group 2a
 * @param <T> ein doppelt verkettetes Element der Liste
 */
public class DoubleLinkedList<T extends Comparable<T>> implements List<T> { 

    private DoubleLinkedList<T> prev;
    private DoubleLinkedList<T> next;
    private T item;

    /**
     * Create a empty list
     */
    public DoubleLinkedList() {
        this.prev = this;
        this.next = this;
    }

    /**
     * Create a list and link a new element
     * @param prev previous list element
     * @param next next list element
     * @param item the item
     */
    private DoubleLinkedList(DoubleLinkedList<T> prev, DoubleLinkedList<T> next, T item) {
        this.prev = prev;
        prev.next = this;
        this.next = next;
        next.prev = this;
        this.item = item;
    }

    @Override
    public boolean isEmpty() {
        return firstItem() == null;
    }

    @Override
    public int length() {
        DoubleLinkedList<T> cur = this;
        int length = 0;
        while (!cur.isEmpty()) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    @Override
    public T firstItem() {
        return next.item;
    }
	
     /**
     * Returns the element at the specified position in this list.
     * @param i - index of the element to return
     * @return he element at the specified position in this list
     */
    public T get(int i) {
    	DoubleLinkedList<T> cur = prev;
    	int c = 0;
    	while (c <= i) {
    		c++;
            cur = cur.next;
        }
    	return cur.item;
    }

    @Override
    public void insert(T p) {
        DoubleLinkedList<T> cur = next;
        while (cur.item != null && cur.item.compareTo(p) == -1 ) {
            cur = cur.next;
        }
        new DoubleLinkedList<T>(cur.prev, cur, p);
    }

    @Override
    public void delete(T p) {
        DoubleLinkedList<T> cur = next;
        while (cur.item != null && cur.item.compareTo(p) != 0) {
            cur = cur.next;
        }
        if (cur.item != null) {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
    }
    
	/**
     * Removes the element at the front position in this list. Returns the element that was removed from the list.
     * @return the element previously at the front position
     */
    public T delete() {
    	DoubleLinkedList<T> cur = next;
    	cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    	return cur.item;        
    }

    /**
	 * prueft ob ein Objekt in einer liste ist
	 * @param x das zu suchende Objekt
	 * @return true wenn es enthalten ist
	 */
    public boolean isInList(T x) {
    	DoubleLinkedList<T> cur = next;
    	if (x == null) {
    		return false;
    	}
        while (cur != null) {
            if (x.equals(cur.item)) {
                return true;
			}
            cur = cur.next;
        }
        return false;
    }
	
	/**
	 * fuegt alle Elemente einer Liste zu einer anderen zu. Die reihenfolge wird dabei umgedreht
	 * @param list ist die zu kopierende liste
	 */
    public void addAll(List<T> list) {
        for (int i = 1; i < list.length() + 1; i++) {
            this.insert(list.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DoubleLinkedList<T> cur = this;
        while (!cur.isEmpty()) {
            stringBuilder.append(cur.firstItem()).append("\n");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }
    
	/**
	 * Allgemeine Filterfunktion. Benutzt Predicatefunktionen.
	 * @param predicate ist der angewendete Filter
	 * @return gibt eine Liste aus
	 */
    public List<T> filter(Predicate<T> predicate) {
    	DoubleLinkedList<T> list = new DoubleLinkedList<T>();
		DoubleLinkedList<T> cur = next;
		if (cur == null) {
			System.out.println("Cur ist null");
		}
		while (cur.item != null) {
			if (predicate.test((T) cur.item)) {
				list.insert((T) cur.item);
    		}
			cur = cur.next;
    	}
		return list;
    }
}
