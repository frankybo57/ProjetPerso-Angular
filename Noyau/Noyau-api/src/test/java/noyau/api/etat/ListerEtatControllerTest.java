package noyau.api.etat;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import noyau.model.Etat;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class ListerEtatControllerTest {

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private static final ObjectMapper MAPPER = new ObjectMapper();
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
    
    @Test
	public void testFindAllEtats() throws Exception {
		
		Etat[] liste = new Etat[] {
				Etat.INACTIF,Etat.ACTIF
		};
		
		String string = MAPPER.writeValueAsString(liste);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules/etats");
        this.mockMvc.perform(builder)
                    .andExpect(OK)
                    .andExpect(JSON)
                    .andExpect(content().json(string));
		
	}

}
