package dh.tfi.integrador;

import dh.tfi.integrador.entities.Domicilio;
import dh.tfi.integrador.entities.Odontologo;
import dh.tfi.integrador.entities.Paciente;
import dh.tfi.integrador.entities.Turno;
import dh.tfi.integrador.util.Json;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionOdontologoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registrarOdontologo() throws Exception {
        //Domicilio domicilio = new Domicilio("Maipu", 152, "San Salvador de Jujuy", "Jujuy");
        //Paciente paciente = new Paciente("Ramos", "Pedro", "pedro@gmail.com", 51478514, LocalDate.of(2022,04,01), domicilio);
        Odontologo odontologo = new Odontologo("Juan", "Perez", "5145");
        //Turno turno = new Turno(paciente, odontologo, LocalDate.of(2022,4,25));

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/odontologos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json.asJsonString(odontologo)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}
