package recettes.api.type.ingredient;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
import recettes.model.TypeIngredient;
import recettes.repository.TypeIngredientRepository;
import recettes.service.TypeIngredientService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath*:/web-test.xml")
@ContextConfiguration({"/applicationtestContext.xml","/dispatcher-servlet.xml"})
public class ListerTypeIngredientControllerTest {

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Autowired
    private TypeIngredientRepository tiRepo;
    @Autowired
    private TypeIngredientService tiService;
    
    private final Set<TypeIngredient> expected = new HashSet<TypeIngredient>();
	private final Set<TypeIngredient> auxiliaire = new HashSet<TypeIngredient>();
	private int expectedNbNiveauZero;
    
    @Before
    public void setup() {
		if(tiRepo.count()>0) {
			tiRepo.deleteAll();
		}
		tiService.effacer();
    	
    	MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    public void preparation() {	
		TypeIngredient ti = new TypeIngredient("Epice");
		ti.setNiveau((short) 0);
		ti = tiRepo.save(ti);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tp = new TypeIngredient("Viande");
		tp.setNiveau((short) 0);
		tp = tiRepo.save(tp);
		expected.add(tp);
		auxiliaire.add(tp);
		ti = new TypeIngredient("Féculent");
		ti.setNiveau((short) 0);
		ti = tiRepo.save(ti);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tf = new TypeIngredient("Volaille");
		tf.setNiveau((short) 1);
		tf.setTypePere(tp);
		tf = tiRepo.save(tf);
		expected.add(tf);
		auxiliaire.add(tf);
		ti = new TypeIngredient("Légume");
		ti.setNiveau((short) 0);
		ti = tiRepo.save(ti);
		expected.add(ti);
		auxiliaire.add(ti);
		TypeIngredient tpf = new TypeIngredient("Poulet");
		tpf.setNiveau((short) 2);
		tpf.setTypePere(tf);
		tpf = tiRepo.save(tpf);
		expected.add(tpf);
		auxiliaire.add(tpf);
		ti = new TypeIngredient("Boeuf");
		ti.setNiveau((short) 1);
		ti.setTypePere(tp);
		ti = tiRepo.save(ti);
		expected.add(ti);
		auxiliaire.add(ti);
		
		expectedNbNiveauZero = 4;
	}
    
    @Test
	public void testFindAll() throws Exception {
    	preparation();
    	TypeIngredient type;
    	for(int i = 0; i < 10; i++) {
    		type = new TypeIngredient("type"+i);
    		type.setPrive(i%2 == 1);
    		type = tiRepo.save(type);
    	}
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/type-ingredient/liste/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON);
	}

    @Test
	public void testFindAllHierarchie() throws Exception {
    	preparation();
    	TypeIngredient type;
    	for(int i = 0; i < 10; i++) {
    		type = new TypeIngredient("type"+i);
    		type.setPrive(i%2 == 1);
    		type = tiRepo.save(type);
    	}
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/type-ingredient/liste/hierarchisee/");
        this.mockMvc.perform(builder)
                    .andExpect(Constantes.OK)
                    .andExpect(Constantes.JSON);
	}
}
