package dh.tfi.integrador.service;

import dh.tfi.integrador.entities.Odontologo;
import dh.tfi.integrador.exceptions.ResourceNotFoundException;
import dh.tfi.integrador.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;

    public List<Odontologo> listarOdontologos(){
        return odontologoRepository.findAll();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> buscarOdontologo(Long id){
        return odontologoRepository.findById(id);
    }

    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        if(buscarOdontologo(odontologo.getId()).isPresent())
            return odontologoRepository.save(odontologo);
        else
            return null;
    }

    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado = buscarOdontologo(id);
        if (odontologoBuscado.isPresent())
            odontologoRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("El odontologo con id " + id + " no existe.");
    }

}
