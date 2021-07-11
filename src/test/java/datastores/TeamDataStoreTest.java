package datastores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import game.Player;
import game.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamDataStoreTest {

    private static EntityManagerFactory entityManagerFactory;
    TeamDataStore teamDataStore;

    @BeforeAll
    static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("bundesliga");
    }

    @BeforeEach
    void setUp() {
        teamDataStore = new TeamDataStore(entityManagerFactory);
    }

    @Test
    public void addTeam(){
        Team team = new Team("1 FC. Kaiserslautern");
        teamDataStore.addTeam(team);
    }

    @Test
    public void addTeamWithPlayer(){
        Team team = new Team("1 FC. Kaiserslautern");
        teamDataStore.addTeam(team);
    }
}
