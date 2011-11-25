package info.matecki;

import com.googlecode.jeeunit.JeeunitRunner;
import info.matecki.tutorial1.bl.PersonEJBBean;
import info.matecki.tutorial1.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.ejb.EJB;
import java.util.Collection;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */

@RunWith(JeeunitRunner.class)
public class MyTest

{
    @EJB
    PersonEJBBean myEJBBean;

    @Before
    public void prepare()
    {
        for (int i=0; i<10; i++)
        {
            myEJBBean.savePerson("Name_"+i, "Surname_"+i);
        }
    }

    @Test
    public void testFindAllPersons()
    {
        assertNotNull(myEJBBean);
        Collection<Person> allPersons = myEJBBean.findAllPersons();
        assertTrue(allPersons.size()>0);
    }
}
