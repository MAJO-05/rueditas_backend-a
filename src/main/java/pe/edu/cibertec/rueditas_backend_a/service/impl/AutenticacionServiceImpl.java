package pe.edu.cibertec.rueditas_backend_a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_backend_a.service.AutenticacionService;
import pe.edu.cibertec.rueditas_backend_a.dto.LoginRequestDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarPlaca(LoginRequestDTO loginRequestDTO) throws IOException{

        String[] datosPlaca = null;
        Resource resource = resourceLoader.getResource("classpath:placas.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){

                String linea;
                while ((linea = br.readLine()) != null){

                    String[] datos = linea.split(";");
                    if (loginRequestDTO.numeroPlaca().equals(datos[0])){

                        datosPlaca = new String[5];
                        datosPlaca[0] = datos[1];
                        datosPlaca[1] = datos[2];
                        datosPlaca[2] = datos[3];
                        datosPlaca[3] = datos[4];
                        datosPlaca[4] = datos[5];
                        break;
                    }
                }
        }catch (IOException e) {

            datosPlaca = null;
            throw new IOException(e);

        }

        return datosPlaca;

    }
}
