
public interface CacheInterface<T> {

	/**
	 * 
	 * @return
	 */
	public T getObject(T T);
	
	/**
	 * 
	 * @return
	 */
	public void addObject(T T);
	
	/**
	 * 
	 * @return
	 */
	public T removeObject(T T);
	
	/**
	 * 
	 * @return
	 */
	public T clearCache(T T);
	
	 /**  
     * Returns a string representation of this list. 
     *
     * @return a string representation of this list
     */
    public String toString();

}
