package noyau.api.utilisateur;

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
import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.repository.UtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class AjouterUtilisateurControllerTest {

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Autowired
    private UtilisateurRepository utiRepo;
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
        
        utiRepo.save(new Utilisateur("",""));
        utiRepo.deleteAll();
    }
    
    @Test
    public void test() {
    	Assert.assertNotNull(utiRepo);
    }
    
    @Test
    public void testCreateOneNonCodeSansId() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin","admin",Droit.ADMINISTRATEUR);
		
		String string = MAPPER.writeValueAsString(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/utilisateur/")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.CREATED);
        Assert.assertNotNull(utiRepo.findByLogin("admin"));
     }
	
	@Test
    public void testCreateOneCodeSansId() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin","admin",Droit.ADMINISTRATEUR);
		
		String string = MAPPER.writeValueAsString(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/utilisateur/code/")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.CREATED);
        Assert.assertNotNull(utiRepo.findByLogin("admin"));
     }
	
	@Test
    public void testCreateOneNonCodeAvecId() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin","admin",Droit.ADMINISTRATEUR);
		utilisateur.setId(3L);
		
		String string = MAPPER.writeValueAsString(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/utilisateur/")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.INTERNAL_SERVER_ERROR);
        Assert.assertNull(utiRepo.findByLogin("admin"));
     }
	
	@Test
    public void testCreateOneCodeAvecId() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin","admin",Droit.ADMINISTRATEUR);
		utilisateur.setId(3L);
		
		String string = MAPPER.writeValueAsString(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/utilisateur/code/")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.INTERNAL_SERVER_ERROR);
        Assert.assertNull(utiRepo.findByLogin("admin"));
     }
	
	@Test
    public void testCreateOneNonCodeDejaExistant() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin","admin",Droit.ADMINISTRATEUR);
		utiRepo.save(utilisateur);
		
		String string = MAPPER.writeValueAsString(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/utilisateur/")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.BAD_REQUEST);
        Assert.assertNotNull(utiRepo.findByLogin("admin"));
     }
	
	@Test
    public void testCreateOneCodeDejaExistant() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin","admin",Droit.ADMINISTRATEUR);
		utiRepo.save(utilisateur);
		
		String string = MAPPER.writeValueAsString(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/utilisateur/code/")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.BAD_REQUEST);
        Assert.assertNotNull(utiRepo.findByLogin("admin"));
     }

}
