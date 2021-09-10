import java.util.LinkedList;

public class Cache<T> implements CacheInterface<T> {

	
	private double HR1;
	private double HR2;
	private double HR;
	private int NH1;
	private int NH2;
	private int NH;
	private int NR1;
	private int NR2;
	private int NR;
	private int LevelOneSize;
	private int LevelTwoSize;
	private LinkedList<T> LevelOne;
	private LinkedList<T> LevelTwo;
	
	/**
	 * 
	 */
	public Cache(int size) {
		LevelOne = new LinkedList<T>();
		LevelTwo = new LinkedList<T>();
		LevelOneSize = size;
		
	}
	
	public Cache(int size1, int size2) {
		LevelOne = new LinkedList<T>();
		LevelTwo = new LinkedList<T>();
		LevelOneSize = size1;
		LevelTwoSize = size2;
		
	}

	@Override
	public T getObject(T o) {
		NR1++;
		if(LevelOne.contains(o)) {
			NH1++;
			T result = o;
			removeObject(o);
			addObject(result);
			return result;
			
		} else if(LevelTwoSize != 0) {
			
			NR2++;
			if(LevelTwo.contains(o)) {
				NH2++;
				T result = o;
				removeObject(o);
				addObject(result);
				return result;
			}
		}
		
		
		addObject(o);
		return o;
	}

	@Override
	public void addObject(T o) {
		LevelOne.addFirst(o);
		LevelTwo.addFirst(o);
		
		
		if(LevelOne.size() > LevelOneSize) LevelOne.removeLast();
		if(LevelTwo.size() > LevelTwoSize) LevelTwo.removeLast();
	}

	@Override
	public T removeObject(T o) {
		T result = o;
		if(LevelOne.contains(o)) LevelOne.remove(o);
		if(LevelTwo.contains(o)) LevelTwo.remove(o);
		return result;
	}

	@Override
	public T clearCache(T o) {
		LevelOne.removeAll(LevelOne);
		LevelTwo.removeAll(LevelTwo);
		return o;
	}
	
	public String toString() {
		NH = NH1 + NH2;
		NR = NR1;
		
		
		HR = (double)NH / NR;
		HR1 = (double)NH1 / NR1;
		HR2 = (double)NH2 / NR2;
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println( "First level cache with " + LevelOneSize + " entries has been created");
		System.out.println("Second level cache with "+ LevelTwoSize +" entries has been created ");
		System.out.println("................................");
		System.out.println("Total number of references:        " + NR1);
		System.out.println("Total number of cache hits:        " + NH);
		System.out.println(" ");
		System.out.println("The global hit ratio:  " + HR);
		System.out.println(" ");
		System.out.println("Number of 1st-level cache references:" + NR1);
		System.out.println("Number of 1st-level cache hits:    " + NH1);
		System.out.println("1st-level cache hit ratio:         " + HR1);
		System.out.println();
		System.out.println("Number of 2nd-level cache references:" + NR2);
		System.out.println("Number of 2nd-level cache hits:    " + NH2);
		String last = "2nd-level cache hit ratio:         " + HR2;
		return last;
	}
}
