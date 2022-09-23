package co.edu.uniandes.dse.parcialejemplo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Entidad genérica de la que heredan todas las entidades. Contiene la
 * referencia al atributo id
 * (15%) Cree la entidad _MedicoEntity_ 
 * en la carpeta correspondiente. Un médico tiene un nombre, un apellido, un registro médico, una especilidad y un id de tipo _Long_ que representa su llave primaria.
 *
 * @author ISIS2603
 */


@Entity
@Getter
@Setter
public class MedicoEntity extends BaseEntity {
	private Long id;
    private String nombre;
    private String apellido;
    private String registromedico;
    private String especialidad;
}


