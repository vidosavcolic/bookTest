import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rest.app.book;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class bookControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private bookRepo bookRepo;

    @InjectMocks
    private bookController bookController;

    book RECORD1 = new book(1B,"The Great Gatsby", "Romance and life-long obsession", 7);
    book RECORD2 = new book(2B,"Nineteen Eighty-Four", "Dystopian social science fiction", 6);
    book RECORD3 = new book(3B,"The Catcher in the Rye", "Subjective style from the point of view of Holden Caulfield", 9);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(bookController).build();
    }
}
