package noyau.api.utilisateur;

import java.util.HashMap;
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
import noyau.service.Verrou;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class ModifierUtilisateurControllerTest {

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
					.andExpect(Constantes.CREATED)
					.andExpect(Constantes.JSON);
		
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
					.andExpect(Constantes.CREATED)
					.andExpect(Constantes.JSON);
		
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
					.andExpect(Constantes.BAD_REQUEST);
		
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
					.andExpect(Constantes.BAD_REQUEST);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals("ancienlogin", temp.getLogin());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUpdatePasswordNonCode() throws Exception  {
		final Map map = new HashMap();
		final String password = "nouveaupassword";
		Utilisateur utilisateur = new Utilisateur("login","ancienpassword",Droit.UTILISATEUR);
		utilisateur = utiRepo.save(utilisateur);
	
		map.put("utilisateur", utilisateur);
		map.put("password", password);
		
		String json = MAPPER.writeValueAsString(map);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/utilisateur/update/password/")
																		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(json);
		this.mockMvc.perform(builder)
					.andExpect(Constantes.CREATED)
					.andExpect(Constantes.JSON);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals(password, temp.getPassword());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUpdatePasswordCode() throws Exception  {
		final Map map = new HashMap();
		final String password = "nouveaupassword";
		Utilisateur utilisateur = new Utilisateur("login",Verrou.cryptage("ancienpassword"),Droit.UTILISATEUR);
		utilisateur = utiRepo.save(utilisateur);
	
		utilisateur.setPassword("ancienpassword");
		map.put("utilisateur", utilisateur);
		map.put("password", password);
		
		String json = MAPPER.writeValueAsString(map);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/utilisateur/code/update/password/")
																		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(json);
		this.mockMvc.perform(builder)
					.andExpect(Constantes.CREATED)
					.andExpect(Constantes.JSON);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals(Verrou.cryptage(password), temp.getPassword());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUpdatePasswordNonCodeNouveauPasswordNull() throws Exception  {
		final Map map = new HashMap();
		final String password = null;
		Utilisateur utilisateur = new Utilisateur("login","ancienpassword",Droit.UTILISATEUR);
		utilisateur = utiRepo.save(utilisateur);
	
		map.put("utilisateur", utilisateur);
		map.put("password", password);
		
		String json = MAPPER.writeValueAsString(map);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/utilisateur/update/password/")
																		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(json);
		this.mockMvc.perform(builder)
					.andExpect(Constantes.BAD_REQUEST);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals("ancienpassword", temp.getPassword());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUpdatePasswordCodeNouveauPasswordNull() throws Exception  {
		final Map map = new HashMap();
		final String password = null;
		Utilisateur utilisateur = new Utilisateur("login",Verrou.cryptage("ancienpassword"),Droit.UTILISATEUR);
		utilisateur = utiRepo.save(utilisateur);
	
		utilisateur.setPassword("ancienpassword");
		map.put("utilisateur", utilisateur);
		map.put("password", password);
		
		String json = MAPPER.writeValueAsString(map);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/utilisateur/code/update/password/")
																		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
																		.content(json);
		this.mockMvc.perform(builder)
					.andExpect(Constantes.BAD_REQUEST);
		
		final Utilisateur temp = utiRepo.findOne(utilisateur.getId());
		Assert.assertNotNull(temp);
		Assert.assertEquals(Verrou.cryptage("ancienpassword"), temp.getPassword());
		
	}

}
