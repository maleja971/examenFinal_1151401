package examenFinal_entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rol")
public class rol implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private long id;

	
	@Column
	private String description;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	

}
