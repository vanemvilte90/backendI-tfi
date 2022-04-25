package dh.tfi.integrador.service;

import dh.tfi.integrador.entities.Turno;
import dh.tfi.integrador.exceptions.ResourceNotFoundException;
import dh.tfi.integrador.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    TurnoRepository turnoRepository;

    public List<Turno> listarTurnos(){
        return turnoRepository.findAll();
    }

    public Turno guardarTurno(Turno turno){
        return turnoRepository.save(turno);
    }

    public Optional<Turno> buscarTurno(Long id){
        return turnoRepository.findById(id);
    }

    public Turno actualizarTurno(Turno turno) {
        if(buscarTurno(turno.getId()).isPresent())
            return turnoRepository.save(turno);
        else
            return null;
    }

    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        Optional<Turno> turnoBuscado= buscarTurno(id);
        if (turnoBuscado.isPresent())
            turnoRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("El turno con id " + id + " no existe.");
    }

}
