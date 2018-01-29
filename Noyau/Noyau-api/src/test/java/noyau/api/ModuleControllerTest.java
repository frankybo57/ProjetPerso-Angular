package noyau.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import noyau.model.Etat;
import noyau.model.Module;
import noyau.repository.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web.xml")
@ContextConfiguration({"/applicationContext.xml","/dispatcher-servlet.xml"})
public class ModuleControllerTest {

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    @Mock
    private ModuleRepository modRepo;
    
    @InjectMocks
    private ModuleController moduleController;

    private static final ResultMatcher OK = MockMvcResultMatchers.status().isOk();
    
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
    public void testMyMvcController() throws Exception {
    	Module module;
    	List<Module> modules = new ArrayList();
    	List expected = new ArrayList();
    	List result;
    	
    	module = new Module("module1");
    	module.setId(1L);
    	module.setEtat(Etat.ACTIF);
    	modules.add(module);
    	expected.add(module);
    	
    	module = new Module("module2");
    	module.setId(42L);
    	module.setEtat(Etat.ACTIF);
    	modules.add(module);
    	expected.add(module);
    	
    	Mockito.when(modRepo.findAllByEtat(Etat.ACTIF)).thenReturn(modules);
    	
        ResultMatcher msg = MockMvcResultMatchers.model()
                            .attribute("msg", "Spring quick start!!");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/modules-actifs/");
        this.mockMvc.perform(builder)
                    .andExpect(OK);
     }
}
