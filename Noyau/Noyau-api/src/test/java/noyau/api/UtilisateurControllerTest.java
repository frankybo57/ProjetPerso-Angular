package noyau.api;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.repository.UtilisateurRepository;
import noyau.service.Verrou;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class UtilisateurControllerTest {
	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Autowired
    private UtilisateurRepository utiRepo;
    
    private static final ResultMatcher INTERNAL_SERVER_ERROR = status().isInternalServerError();
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
        
        utiRepo.save(new Utilisateur("",""));
        utiRepo.deleteAll();
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void testFindAll() throws Exception {
    	Utilisateur utilisateur;
    	List utilisateurs = new ArrayList();
    	String expected;
    	
    	utilisateur = new Utilisateur("utilisateur1", "mdp");
    	utilisateur.setDroits(Droit.ADMINISTRATEUR);
    	utilisateur = utiRepo.save(utilisateur);
    	utilisateur.setPassword(null);
    	utilisateurs.add(utilisateur);
    	
    	utilisateur = new Utilisateur("utilisateur2", "mdp2");
    	utilisateur.setDroits(Droit.UTILISATEUR);
    	utilisateur = utiRepo.save(utilisateur);
    	utilisateur.setPassword(null);
    	utilisateurs.add(utilisateur);
    	
    	
    	utilisateur = new Utilisateur("utilisateur3", "mdp3");
    	utilisateur.setDroits(Droit.UTILISATEUR);
    	utilisateur = utiRepo.save(utilisateur);
    	utilisateur.setPassword(null);
    	utilisateurs.add(utilisateur);
    	
    	utilisateur = new Utilisateur("utilisateur4", "mdp4");
    	utilisateur.setDroits(Droit.UTILISATEUR);
    	utilisateur = utiRepo.save(utilisateur);
    	utilisateur.setPassword(null);
    	utilisateurs.add(utilisateur);
    	
    	expected = MAPPER.writeValueAsString(utilisateurs);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/utilisateur/liste");
        this.mockMvc.perform(builder)
                    .andExpect(OK)
                    .andExpect(JSON)
                    .andExpect(content().json(expected));
     }
	
	@Test
    public void testFindAllSansUtilisateur() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/utilisateur/liste");
        this.mockMvc.perform(builder)
                    .andExpect(NOT_FOUND);
        Assert.assertNotNull(utiRepo.findAll());
        Assert.assertTrue(utiRepo.findAll().isEmpty());
     }
	
	@Test
    public void testCreateOneNonCodeSansId() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin","admin",Droit.ADMINISTRATEUR);
		
		String string = MAPPER.writeValueAsString(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/utilisateur/")
        																.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        																.content(string);
        this.mockMvc.perform(builder)
                    .andExpect(CREATED);
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
                    .andExpect(CREATED);
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
                    .andExpect(INTERNAL_SERVER_ERROR);
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
                    .andExpect(INTERNAL_SERVER_ERROR);
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
                    .andExpect(BAD_REQUEST);
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
                    .andExpect(BAD_REQUEST);
        Assert.assertNotNull(utiRepo.findByLogin("admin"));
     }
	
	@Test
    public void testFindOneNonCode() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin","admin",Droit.ADMINISTRATEUR);
		utiRepo.save(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/utilisateur/"
        																+ utilisateur.getLogin()
        																+ ":"
        																+ utilisateur.getPassword());
        this.mockMvc.perform(builder)
                    .andExpect(OK);
     }
	
	@Test
    public void testFindOneCode() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin",Verrou.cryptage("admin"),Droit.ADMINISTRATEUR);
		utiRepo.save(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/utilisateur/code/"
														        		+ "admin"
																		+ ":"
																		+ "admin");
        this.mockMvc.perform(builder)
                    .andExpect(OK);
     }
	
	@Test
    public void testFindOneNonCodeSansUtilisateur() throws Exception {	
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/utilisateur/"
        																+ "test"
        																+ ":"
        																+ "cqs");
        this.mockMvc.perform(builder)
                    .andExpect(NOT_FOUND);
     }
	
	@Test
    public void testFindOneCodeSansUtilisateur() throws Exception {
		Utilisateur utilisateur = new Utilisateur("admin",Verrou.cryptage("admin"),Droit.ADMINISTRATEUR);
		utiRepo.save(utilisateur);
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/utilisateur/code/"
														        		+ "gfsgf"
																		+ ":"
																		+ "qfe");
        this.mockMvc.perform(builder)
                    .andExpect(NOT_FOUND);
     }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUpdateLoginNonCode() throws Exception  {
		final Map map = new HashMap();
		final String login = "nouveaulogin";
		Utilisateur utilisateur = new Utilisateur("ancienlogin","password",Droit.UTILISATEUR);
		utilisateur = utiRepo.save(utilisateur);
	
		map.put("utilisateur", utilisateur);
		map.put("login", login);
		
		String json = MAPPER.writeValueAsString(map);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/utilisateur/update/login/")
																		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(json);
		this.mockMvc.perform(builder)
					.andExpect(CREATED)
					.andExpect(JSON);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals(login, temp.getLogin());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUpdateLoginCode() throws Exception  {
		final Map map = new HashMap();
		final String login = "nouveaulogin";
		Utilisateur utilisateur = new Utilisateur("ancienlogin",Verrou.cryptage("password"),Droit.UTILISATEUR);
		utilisateur = utiRepo.save(utilisateur);
	
		utilisateur.setPassword("password");
		map.put("utilisateur", utilisateur);
		map.put("login", login);
		
		String json = MAPPER.writeValueAsString(map);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/utilisateur/code/update/login/")
																		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(json);
		this.mockMvc.perform(builder)
					.andExpect(CREATED)
					.andExpect(JSON);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals(login, temp.getLogin());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUpdateLoginNonCodeNouveauLoginNull() throws Exception  {
		final Map map = new HashMap();
		final String login = null;
		Utilisateur utilisateur = new Utilisateur("ancienlogin","password",Droit.UTILISATEUR);
		utilisateur = utiRepo.save(utilisateur);
	
		map.put("utilisateur", utilisateur);
		map.put("login", login);
		
		String json = MAPPER.writeValueAsString(map);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/utilisateur/update/login/")
																		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(json);
		this.mockMvc.perform(builder)
					.andExpect(BAD_REQUEST);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals("ancienlogin", temp.getLogin());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUpdateLoginCodeNouveauLoginNull() throws Exception  {
		final Map map = new HashMap();
		final String login = null;
		Utilisateur utilisateur = new Utilisateur("ancienlogin",Verrou.cryptage("password"),Droit.UTILISATEUR);
		utilisateur = utiRepo.save(utilisateur);
	
		utilisateur.setPassword("password");
		map.put("utilisateur", utilisateur);
		map.put("login", login);
		
		String json = MAPPER.writeValueAsString(map);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/utilisateur/code/update/login/")
																		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(json);
		this.mockMvc.perform(builder)
					.andExpect(BAD_REQUEST);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals("ancienlogin", temp.getLogin());
		
	}
	
}
