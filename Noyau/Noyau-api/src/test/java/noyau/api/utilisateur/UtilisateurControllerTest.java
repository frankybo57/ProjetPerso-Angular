package noyau.api.utilisateur;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
	
	
	
}
