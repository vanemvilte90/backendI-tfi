package dh.tfi.integrador.controller;

import dh.tfi.integrador.entities.Odontologo;
import dh.tfi.integrador.entities.Paciente;
import dh.tfi.integrador.entities.Turno;
import dh.tfi.integrador.exceptions.ResourceNotFoundException;
import dh.tfi.integrador.service.OdontologoService;
import dh.tfi.integrador.service.PacienteService;
import dh.tfi.integrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> respuesta;
        Optional<Paciente> paciente = pacienteService.buscarPaciente(turno.getPaciente().getId());
        Optional<Odontologo> odontologo= odontologoService.buscarOdontologo(turno.getOdontologo().getId());
        if (paciente.isPresent()&&odontologo.isPresent()){
            respuesta = ResponseEntity.ok(turnoService.guardarTurno(turno));
        } else{
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @PutMapping
    public Turno actualizarTurno(@RequestBody Turno turno){
        return turnoService.actualizarTurno(turno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id){
        if(turnoService.buscarTurno(id).isPresent()){
            return ResponseEntity.ok(turnoService.buscarTurno(id).get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("El turno se ha eliminado con éxito");
    }
}
