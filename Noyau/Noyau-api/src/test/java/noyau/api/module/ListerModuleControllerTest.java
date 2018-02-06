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
public class ListerModuleControllerTest {

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
    public void testFindAllModulesActifsAvecModulesActifs() throws Exception {
		modRepo.deleteAll();
    	
    	Module module;
    	List modules = new ArrayList();
    	String expected;
    	
    	module = new Module("module1");
    	module.setId(1L);
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	module = new Module("module2");
    	module.setId(42L);
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	module = new Module("module3");
    	module.setId(47L);
    	module.setEtat(Etat.INACTIF);
    	module = modRepo.save(module);
    	
    	module = new Module("module4");
    	module.setId(452L);
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	expected = MAPPER.writeValueAsString(modules);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/actifs/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON)
                    .andExpect(content().json(expected));
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindAllModulesActifsSansModulesActifs() throws Exception {
    	Module module;
    	
    	module = new Module("module1");
    	module.setId(1L);
    	module.setEtat(Etat.INACTIF);
    	module = modRepo.save(module);
    	
    	module = new Module("module2");
    	module.setId(42L);
    	module.setEtat(Etat.INACTIF);
    	module = modRepo.save(module);
    	
    	module = new Module("module3");
    	module.setId(47L);
    	module.setEtat(Etat.INACTIF);
    	module = modRepo.save(module);
    	
    	module = new Module("module4");
    	module.setId(452L);
    	module.setEtat(Etat.INACTIF);
    	module = modRepo.save(module);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/actifs/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.NOT_FOUND);
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindAllActifsSansModules() throws Exception {
		
    	modRepo.deleteAll();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/actifs/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.NOT_FOUND);
        
        modRepo.deleteAll();
     }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void testFindAllOrderById() throws Exception {
		modRepo.deleteAll();
    	
    	Module module;
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
    	
    	
    	module = new Module("module3");
    	module.setEtat(Etat.INACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	module = new Module("module4");
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	expected = MAPPER.writeValueAsString(modules);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modulesbyid/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON)
                    .andExpect(content().json(expected));
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindAllModulesOrderByIdSansModule() throws Exception {
		
    	modRepo.deleteAll();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modulesbyid/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.NOT_FOUND);
        
        modRepo.deleteAll();
     }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void testFindAll() throws Exception {
		modRepo.deleteAll();
    	
    	Module module;
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
    	
    	
    	module = new Module("module3");
    	module.setEtat(Etat.INACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	module = new Module("module4");
    	module.setEtat(Etat.ACTIF);
    	module = modRepo.save(module);
    	modules.add(module);
    	
    	expected = MAPPER.writeValueAsString(modules);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON)
                    .andExpect(content().json(expected));
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindAllSansModule() throws Exception {
		
    	modRepo.deleteAll();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.NOT_FOUND);
        
        modRepo.deleteAll();
     }

}
