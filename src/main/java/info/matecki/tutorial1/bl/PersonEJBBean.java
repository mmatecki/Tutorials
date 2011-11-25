package info.matecki.tutorial1.bl;


import info.matecki.tutorial1.domain.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * @author Maciej Matecki - maciej.matecki@qnt.pl
 */
@Stateless
public class PersonEJBBean {

    @PersistenceContext(unitName = "tut1")
    private EntityManager em;

    public void savePerson(String name, String surname)
    {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        em.persist(person);
    }
    
    public Collection<Person> findAllPersons()
    {
        String jpql = "select p from Person p";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }
}
