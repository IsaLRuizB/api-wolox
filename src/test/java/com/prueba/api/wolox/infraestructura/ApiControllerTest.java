package com.prueba.api.wolox.infraestructura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.api.wolox.dto.Permiso;
import com.prueba.api.wolox.testDataBuilder.ComandoPermisoBuilder;
import com.prueba.api.wolox.testDataBuilder.PermisoTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ApiControllerTest {

    public static final String ID_ALBUM = "2";
    public static final String PERMISO = "1";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getUsuarioPorPermiso() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/Api/consultar/{idAlbum}/{tipoPermiso}", ID_ALBUM,PERMISO)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

}
