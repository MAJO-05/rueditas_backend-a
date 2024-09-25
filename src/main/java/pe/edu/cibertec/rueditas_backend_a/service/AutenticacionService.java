package pe.edu.cibertec.rueditas_backend_a.service;

import pe.edu.cibertec.rueditas_backend_a.dto.LoginRequestDTO;

import java.io.IOException;

public interface AutenticacionService {
    String[] validarPlaca(LoginRequestDTO loginRequestDTO) throws IOException;
}
