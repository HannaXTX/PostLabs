package Labs.Lab0.ADT;

public interface Listable<T extends Comparable<T>> {

	//DEFINITION OF ADT
	
	void add(T arr);

	boolean remove(T arr);

	boolean find(T arr);

	void clear();

	boolean isEmpty();

	int size();

	void traverse();

	 T get(int i);
}
