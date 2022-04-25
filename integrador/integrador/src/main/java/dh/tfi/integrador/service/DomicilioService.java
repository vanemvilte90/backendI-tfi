package dh.tfi.integrador.service;

import dh.tfi.integrador.entities.Domicilio;
import dh.tfi.integrador.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService  {

    @Autowired
    DomicilioRepository domicilioRepository;

    public List<Domicilio> listarDomicilios(){
        return domicilioRepository.findAll();
    }

    public Domicilio guardarDomicilios(Domicilio domicilio){
        return domicilioRepository.save(domicilio);
    }

    public Optional<Domicilio> buscarDomicilio(Long id){
        return domicilioRepository.findById(id);
    }

    public Domicilio actualizarDomicilio(Domicilio domicilio) {
        if(buscarDomicilio(domicilio.getId()).isPresent())
            return domicilioRepository.save(domicilio);
        else
            return null;
    }

    public void eliminarDomicilio(Long id){
        domicilioRepository.deleteById(id);
    }

}
