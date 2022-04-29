package datastores;

import game.Player;
import game.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PlayerDataStoreTest {
    PlayerDataStore playerDataStore;
    static EntityManagerFactory entityManagerFactory;

//    @BeforeAll
//    static void init(){
//        entityManagerFactory = Persistence.createEntityManagerFactory("bundesliga");
//    }

//    @BeforeEach
//    public void setUp() {
//        playerDataStore = new PlayerDataStore(entityManagerFactory);
//    }
//
//    @Test
//    @DisplayName("Testing Datastore")
//    void testingDatastore(){
//        Team manu = new Team("Man U");
//        Player christiano = new Player("Christiano Ronaldo");
//        Player messi = new Player("Messi");
//        Player coolio = new Player("Coolio");
//        christiano.setTeam(manu);
//        messi.setTeam(manu);
//        coolio.setTeam(manu);
//        playerDataStore.persistPlayer(christiano);
//        playerDataStore.persistPlayer(messi);
//        playerDataStore.persistPlayer(coolio);
//    }
}
