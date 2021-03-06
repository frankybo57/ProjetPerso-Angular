package noyau.api.utilisateur;

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
import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.repository.UtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class ListerUtilisateurControllerTest {

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
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON)
                    .andExpect(content().json(expected));
     }
	
	@Test
    public void testFindAllSansUtilisateur() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/utilisateur/liste");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.NOT_FOUND);
        Assert.assertNotNull(utiRepo.findAll());
        Assert.assertTrue(utiRepo.findAll().isEmpty());
     }

}
