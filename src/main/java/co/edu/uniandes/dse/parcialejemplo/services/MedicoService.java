package co.edu.uniandes.dse.parcialejemplo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.MedicoRepository;


@Service
public class MedicoService {

    
    @Autowired
    MedicoRepository medicoRepository;

    @Transactional
	public MedicoEntity createMedico(MedicoEntity medicoEntity) throws EntityNotFoundException, IllegalOperationException {
		
		
		if (medicoEntity.getNombre() == null)
			throw new IllegalOperationException("Nombre is not valid");
        
        if (medicoEntity.getApellido() == null)
			throw new IllegalOperationException("Apellido is not valid");

        if (medicoEntity.getRegistromedico() == null)
			throw new IllegalOperationException("Registro is not valid");
        
            if (medicoEntity.getEspecialidad() == null)
			throw new IllegalOperationException("Especialidad is not valid");
    
		
        if (medicoEntity.getId()==null)
            throw new IllegalOperationException("Id is not valid");

        if (medicoEntity.getId()<0)
            throw new IllegalOperationException("Id is not valid");
       
        if (!medicoRepository.findById(medicoEntity.getId()).isEmpty()){
             throw new IllegalOperationException("Ya existe usuario registrado con ese id");
            }

		
		return medicoRepository.save(medicoEntity);
	}

    @Transactional
	public List<MedicoEntity> getMedicos() {
		
		return medicoRepository.findAll();
	}
    
	@Transactional
	public MedicoEntity getMedico(Long Id) throws EntityNotFoundException {
		Optional<MedicoEntity> medicoEntity = medicoRepository.findById(Id);
		if (medicoEntity.isEmpty())
			throw new EntityNotFoundException("Medico no encontradi");
		return medicoEntity.get();
	}

    @Transactional
	public MedicoEntity updateMedico(Long Id, MedicoEntity medico)
			throws EntityNotFoundException, IllegalOperationException {
		Optional<MedicoEntity> medicoEntity = medicoRepository.findById(Id);
		if (medicoEntity.isEmpty())
			throw new EntityNotFoundException("No encontrado");

		if ((medico.getId()==null))
			throw new IllegalOperationException("ID is not valid");

		medico.setId(Id);
		return medicoRepository.save(medico);
	}

    @Transactional
	public void deleteMedico(Long Id) throws EntityNotFoundException, IllegalOperationException {
		Optional<MedicoEntity> medicoEntity = medicoRepository.findById(Id);
		if (medicoEntity.isEmpty())
			throw new EntityNotFoundException("Medico is not valid");
		medicoRepository.deleteById(Id);
	}


    
}
