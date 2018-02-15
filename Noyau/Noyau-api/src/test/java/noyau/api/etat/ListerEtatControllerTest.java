package noyau.api.etat;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import constantes.Constantes;
import noyau.model.Etat;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class ListerEtatControllerTest {

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
	public void testFindAllEtats() throws Exception {
		
		Etat[] liste = new Etat[] {
				Etat.INACTIF,Etat.ACTIF
		};
		
		String string = MAPPER.writeValueAsString(liste);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/etats");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON)
                    .andExpect(content().json(string));
		
	}

}
