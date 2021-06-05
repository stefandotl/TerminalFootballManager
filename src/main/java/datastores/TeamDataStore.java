package datastores;

import game.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TeamDataStore {

    EntityManagerFactory entityManagerFactory;

    public TeamDataStore(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private TeamDataStore(){
    }

    public void addTeam(Team team) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(team);
        em.getTransaction().commit();
        em.close();
    }
}
