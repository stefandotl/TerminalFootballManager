package datastores;

import game.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TeamDataStore {

    EntityManagerFactory entityManagerFactory;

    public TeamDataStore(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private TeamDataStore(){
    }

    public void addTeam(Team team) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(team);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
