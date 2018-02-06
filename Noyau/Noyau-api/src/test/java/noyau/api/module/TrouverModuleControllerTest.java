package noyau.api.module;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
import noyau.model.Module;
import noyau.repository.ModuleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class TrouverModuleControllerTest {

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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void testFindById() throws Exception {
		modRepo.deleteAll();
    	
    	Module module;
    	Module module2;
    	List modules = new ArrayList();
    	String expected;
    	
    	module = new Module("module1");
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	module = new Module("module2");
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	
    	module2 = new Module("module3");
    	module2.setEtat(Etat.INACTIF);
    	module2 = modRepo.save(module2);
    	modules.add(module2);
    	final Long id = module2.getId();
    	
    	module = new Module("module4");
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	expected = MAPPER.writeValueAsString(module2);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/"+id);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON)
                    .andExpect(content().json(expected));
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindByIdSansModule() throws Exception {
		
    	modRepo.deleteAll();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/1");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.NOT_FOUND);
        
        modRepo.deleteAll();
     }
}
