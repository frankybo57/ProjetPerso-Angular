package recette.api.type.plat;

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

import constantes.Constantes;
import recettes.model.TypePlat;
import recettes.repository.TypePlatRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class ListerTypePlatControllerTest {

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Autowired
    private TypePlatRepository tpRepo;
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
	public void testFindAll() throws Exception {
    	TypePlat type;
    	for(int i = 0; i < 10; i++) {
    		type = new TypePlat("type"+i,"type"+i);
    		type.setPrive(i%2 == 1);
    		type = tpRepo.save(type);
    	}
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/types-plats/liste/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON);
	}

}
