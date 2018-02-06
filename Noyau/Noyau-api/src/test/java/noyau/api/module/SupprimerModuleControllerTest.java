package noyau.api.module;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class SupprimerModuleControllerTest {

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
    public void testDeleteInexistant() throws Exception {
		modRepo.deleteAll();
		
    	Module module;
    	
    	module = new Module("module1");
    	module.setId(3L);
    	module.setEtat(Etat.ACTIF);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/modules/"+module.getId());
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.NOT_FOUND);

        modRepo.deleteAll();
     }
	
	@Test
    public void testDeleteExistant() throws Exception {
		modRepo.deleteAll();
    	
    	Module module = new Module("module1");
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/modules/"+module.getId());
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.NO_CONTENT);

        modRepo.deleteAll();
     }
	
	
}
