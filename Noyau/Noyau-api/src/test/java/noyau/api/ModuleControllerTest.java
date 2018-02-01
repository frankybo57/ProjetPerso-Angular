package noyau.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import noyau.model.Etat;
import noyau.model.Module;
import noyau.repository.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class ModuleControllerTest {

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Autowired
    private ModuleRepository modRepo;
    
    private static final ResultMatcher BAD_REQUEST = status().isBadRequest();
    private static final ResultMatcher NOT_FOUND = status().isNotFound();
    private static final ResultMatcher OK = status().isOk();
    private static final ResultMatcher CREATED = status().isCreated();
    private static final ResultMatcher JSON = content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
	private static final ResultMatcher NO_CONTENT = status().isNoContent();
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
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
                    .andExpect(OK)
                    .andExpect(JSON)
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
                    .andExpect(NOT_FOUND);
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindAllActifsSansModules() throws Exception {
		
    	modRepo.deleteAll();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/actifs/");
        this.mockMvc.perform(builder)
                    .andExpect(NOT_FOUND);
        
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
                    .andExpect(OK)
                    .andExpect(JSON)
                    .andExpect(content().json(expected));
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindAllModulesOrderByIdSansModule() throws Exception {
		
    	modRepo.deleteAll();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modulesbyid/");
        this.mockMvc.perform(builder)
                    .andExpect(NOT_FOUND);
        
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
                    .andExpect(OK)
                    .andExpect(JSON)
                    .andExpect(content().json(expected));
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindAllSansModule() throws Exception {
		
    	modRepo.deleteAll();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/");
        this.mockMvc.perform(builder)
                    .andExpect(NOT_FOUND);
        
        modRepo.deleteAll();
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
                    .andExpect(OK)
                    .andExpect(JSON)
                    .andExpect(content().json(expected));
        
        modRepo.deleteAll();
     }
	
	@Test
    public void testFindByIdSansModule() throws Exception {
		
    	modRepo.deleteAll();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/1");
        this.mockMvc.perform(builder)
                    .andExpect(NOT_FOUND);
        
        modRepo.deleteAll();
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
                    .andExpect(BAD_REQUEST);

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
                    .andExpect(CREATED)
                    .andExpect(JSON);

        modRepo.deleteAll();
     }
	
	@Test
    public void testUpdateAvecId() throws Exception {
		modRepo.deleteAll();
		
    	Module module;
    	
    	module = new Module("module1");
    	module.setId(3L);
    	module.setEtat(Etat.ACTIF);
    	
    	String string = MAPPER.writeValueAsString(module);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/modules")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(OK);

        modRepo.deleteAll();
     }
	
	@Test
    public void testUpdateSansId() throws Exception {
		modRepo.deleteAll();
    	
    	Module module = new Module("module1");
    	module.setEtat(Etat.ACTIF);
    	
    	String string = MAPPER.writeValueAsString(module);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/modules")
														        		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(CREATED);
        
        Assert.assertEquals(1, modRepo.findAll().size());
        modRepo.deleteAll();
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
                    .andExpect(NOT_FOUND);

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
                    .andExpect(NO_CONTENT);

        modRepo.deleteAll();
     }
	
	@Test
	public void testFindAllEtats() throws Exception {
		modRepo.deleteAll();
		
		Etat[] liste = new Etat[] {
				Etat.INACTIF,Etat.ACTIF
		};
		
		String string = MAPPER.writeValueAsString(liste);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/etats");
        this.mockMvc.perform(builder)
                    .andExpect(OK)
                    .andExpect(JSON)
                    .andExpect(content().json(string));
		
		modRepo.deleteAll();
	}
}
