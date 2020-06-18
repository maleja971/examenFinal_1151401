package examenfinal_commons;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T, ID extends Serializable>{

    static T save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T>getAll();

}
