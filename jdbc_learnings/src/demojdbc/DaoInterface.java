package demojdbc;

import java.util.Collection;

public interface DaoInterface<T, ID> {
	Collection<T> getAll();
	
	T getOne(ID id);
	
	void create(T t);
	
	void update(T t);
	
	void deleteOne(ID id);
}
