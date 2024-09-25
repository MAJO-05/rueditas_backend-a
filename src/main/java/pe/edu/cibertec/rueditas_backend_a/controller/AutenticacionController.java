package pe.edu.cibertec.rueditas_backend_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_backend_a.dto.LoginRequestDTO;
import pe.edu.cibertec.rueditas_backend_a.dto.LoginResponseDTO;
import pe.edu.cibertec.rueditas_backend_a.service.AutenticacionService;
import java.util.Arrays;
import java.io.IOException;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){

        try {
                String[] datosPlaca = autenticacionService.validarPlaca(loginRequestDTO);
                if (datosPlaca == null){
                    return new LoginResponseDTO("01","Error: Placa no encontrada","","","","","");
                }

            return new LoginResponseDTO("00", "", datosPlaca[0], datosPlaca[1], datosPlaca[2], datosPlaca[3], datosPlaca[4]);

            } catch (IOException e) {
            return new LoginResponseDTO("99", "Error: Ocurrió un problema", "", "","","","");
            }




    }
}
