package game;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Team.class)
public abstract class Team_ {

	public static volatile ListAttribute<Team, Player> players;
	public static volatile SingularAttribute<Team, String> name;

	public static final String PLAYERS = "players";
	public static final String NAME = "name";

}

