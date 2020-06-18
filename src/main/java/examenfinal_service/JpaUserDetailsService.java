package examenfinal_service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examenfinal_dao.*;
import examenFinal_entidades.*;
import examenfinal_service.*;
import examenfinal_commons.*;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
        Usuario usuario1 = usuarioDao.findById(usuario1);
        
        if(usuario == null) {
        	logger.error("Error en el Login: no existe el usuario '" + usuario1 + "' en el sistema!");
        	throw new UsernameNotFoundException("Username: " + usuario1 + " no existe en el sistema!");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(rol role: usuario.getRol()) {
        	logger.info("Role: ".concat(role.getAuthority()));
        	authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        
        if(authorities.isEmpty()) {
        	logger.error("Error en el Login: Usuario '" + usuario1 + "' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + usuario1 + "' no tiene roles asignados!");
        }
        
		return new User(usuario1.getUsuario(), usuario1.getClave()(), usuario1.getEmpresa(),usuario1.getRol(), true, true, true, authorities));
	}

}
