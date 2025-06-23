package com.duoc.backend.mensaje;

import com.duoc.backend.Mensaje.Mensaje;
import com.duoc.backend.Mensaje.MensajeController;
import com.duoc.backend.Mensaje.MensajeModelAssembler;
import com.duoc.backend.Mensaje.MensajeRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MensajeControllerTest {

    @InjectMocks
    private MensajeController mensajeController;

    @Mock
    private MensajeRepository mensajeRepository;

    @Mock
    private MensajeModelAssembler assembler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void probarRutInvalido() {

        Mensaje mensajeBody = new Mensaje();
        mensajeBody.setRutUsuario("11111");
        mensajeBody.setLatitud(1);
        mensajeBody.setLongitud(1);


        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("192.168.0.100");

        ResponseEntity<?> resultado =  mensajeController.crearMensaje(mensajeBody, request);

        assertEquals(500, resultado.getStatusCode().value());
        assertEquals("rut es invalido", resultado.getBody());
    }
}
