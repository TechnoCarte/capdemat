package fr.cg95.cvq.service.users;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonObject;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.IsIndividual;
import fr.cg95.cvq.service.request.IAutofillTriggerService;
import fr.cg95.cvq.util.Critere;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IIndividualService extends IAutofillTriggerService {

    Long create(@IsIndividual Adult adult, boolean assignLogin)
        throws CvqException;

    Long create(@IsIndividual Child child);

    void modify(@IsIndividual Individual individual, JsonObject atom)
        throws CvqException;

    List<Individual> get(final Set<Critere> criteriaSet, final String orderedBy,
        final boolean searchAmongArchived);

    List<Individual> get(Set<Critere> criterias, Map<String,String> sortParams,
        Integer max, Integer offset);

    Integer getCount(Set<Critere> criterias);

    Individual getById(@IsIndividual final Long id)
        throws CvqObjectNotFoundException;

    Adult getAdultById(@IsIndividual final Long id)
        throws CvqObjectNotFoundException;
    
    Child getChildById(@IsIndividual final Long id)
        throws CvqObjectNotFoundException;

    Adult getByLogin(@IsIndividual final String login);

    /**
     * Get an individual by its Liberty Alliance federation key.
     */
    Individual getByFederationKey(final String federationKey);

    void modifyPassword(@IsIndividual final Adult adult, final String oldPassword, final String newPassword)
        throws CvqException, CvqBadPasswordException;

    /**
     * @param adult The {@link Adult} to validate
     * @param login Whether this {@link Adult} must be a login account
     *              (then we need to validate question/answer and password)
     * @return The list of invalid fields
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    List<String> validate(Adult adult, boolean login)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    List<String> validate(Adult adult)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    List<String> validate(Child child)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    /**
     * Returns {@link Individual individuals} in state {@link UserState New}, {@link UserState Modified} or
     * {@link UserState Invalid} whose the last modification date is past the maximum delay.
     *
     * @param max Maximum number of individuals to retrieve
     * @return [
     *      int Total of individuals found,
     *      List<Individual> Individuals actually retrieved
     *  ]
     */
    public List<Object> findLateTasks(int max);

    /**
     * Returns {@link Individual individuals} in state {@link UserState New}, {@link UserState Modified} or
     * {@link UserState Invalid} whose the last modification date is past the alert delay.
     *
     * @param max Maximum number of individuals to retrieve
     * @return [
     *      Long Total of individuals found,
     *      List<Individual> Individuals actually retrieved
     *  ]
     */
    public List<Object> findUrgentTasks(int max);

    /**
     * Returns {@link Individual individuals} in state {@link UserState New}, {@link UserState Modified} or
     * {@link UserState Invalid} whose the last modification date is post the alert delay.
     *
     * @param max Maximum number of individuals to retrieve
     * @return [
     *      Long Total of individuals found,
     *      List<Individual> Individuals actually retrieved
     *  ]
     */
    public List<Object> findUsualTasks(int max);
}
