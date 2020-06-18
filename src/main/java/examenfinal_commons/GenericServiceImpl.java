package examenfinal_commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public abstract class GenericServiceImpl
<T, ID extends Serializable> 
implements GenericService<T,ID>{

	public GenericServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		
		return getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		// TODO Auto-generated method stub
		getDao().deleteById(id);
	}

	@Override
	public T get(ID id) {
		// TODO Auto-generated method stub
		Optional<T>obj = getDao().findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		List<T>returnList= new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}
	
	
	public abstract CrudRepository <T, ID>getDao();
	
}
