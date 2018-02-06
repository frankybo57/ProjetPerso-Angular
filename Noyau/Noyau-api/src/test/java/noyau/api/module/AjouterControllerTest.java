package noyau.api.module;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import noyau.model.Module;
import noyau.repository.ModuleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class AjouterControllerTest {

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Autowired
    private ModuleRepository modRepo;
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
        modRepo.save(new Module("module"));
        modRepo.deleteAll();
    }
    
    @Test
    public void test() {
    	Assert.assertNotNull(modRepo);
    }
    
    @Test
    public void testCreateAvecId() throws Exception {
		modRepo.deleteAll();
		
    	Module module;
    	
    	module = new Module("module1");
    	module.setId(3L);
    	module.setEtat(Etat.ACTIF);
    	
    	String string = MAPPER.writeValueAsString(module);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/modules")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.BAD_REQUEST);

        modRepo.deleteAll();
     }
	
	@Test
    public void testCreateSansId() throws Exception {
		modRepo.deleteAll();
    	
    	Module module = new Module("module1");
    	module.setEtat(Etat.ACTIF);
    	
    	String string = MAPPER.writeValueAsString(module);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/modules")
														        		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.CREATED)
                    .andExpect(Constantes.JSON);

        modRepo.deleteAll();
     }

}
