package examenfinal_serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import examenfinal_commons.*;
import examenfinal_dao.*;
import examenFinal_entidades.*;
import examenfinal_serviceimpl.*;
import examenfinal_service.*;


@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer>
implements UsuarioService{
	
	@Autowired
	private CrudRepository<Usuario, Integer> usuarioDao;


	@Override
	public CrudRepository<Usuario, Integer> getDao() {
		// TODO Auto-generated method stub
		return usuarioDao;
	}

}
