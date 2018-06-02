package com.eheio.hello.web;

import com.eheio.hello.config.WebAppContext;
import com.eheio.hello.model.Mesure;
import com.eheio.hello.model.MesurePatient;
import com.eheio.hello.model.UserInfo;
import com.eheio.hello.service.ConsultationService;
import com.eheio.hello.service.IConsultationService;
import com.eheio.hello.service.IMesurePatientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class MedecinControllerTest {
    private MockMvc mockMvc;

    @Mock
    private IMesurePatientService mesurePatientService;
    @Mock
    private UserInfo patient;
    @Mock
    private Mesure mesure;
    @InjectMocks
    private PatientController patientController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(patientController)
                .build();
    }
    @Test
    public void testGetAll() throws Exception {
        patient.setUserId(1);
        mesure.setMesureId(1);
        List<MesurePatient> mesures = new ArrayList<MesurePatient>();
        mesures.add(new MesurePatient(1,100, mesure,patient));
        mesure.setMesureId(2);
        mesures.add(new MesurePatient(2,100, mesure,patient));
        mesure.setMesureId(2);
        mesures.add(new MesurePatient(3,20, mesure,patient));


        when(mesurePatientService.findByPatient(1)).thenReturn(mesures);
        mockMvc.perform(get("/medecin/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(12)))
                .andExpect((ResultMatcher) jsonPath("$[0].id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].valeur", is(100)))
                .andExpect((ResultMatcher) jsonPath("$[1].id", is(2)))
                .andExpect((ResultMatcher) jsonPath("$[1].valeur", is(100)))
                .andExpect((ResultMatcher) jsonPath("$[2].id", is(3)))
                .andExpect((ResultMatcher) jsonPath("$[2].valeur", is(20)));
        verifyNoMoreInteractions(mesurePatientService);
    }
}
