package dh.tfi.integrador.service;

import dh.tfi.integrador.entities.Paciente;
import dh.tfi.integrador.exceptions.ResourceNotFoundException;
import dh.tfi.integrador.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPaciente(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente actualizarPaciente(Paciente paciente) {
        if(buscarPaciente(paciente.getId()).isPresent())
            return pacienteRepository.save(paciente);
        else
            return null;
    }

    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado=buscarPaciente(id);
        if(pacienteBuscado.isPresent())
            pacienteRepository.deleteById(id);
        else{
            throw new ResourceNotFoundException("El paciente con id " + id + " no existe.");
        }
    }
}
