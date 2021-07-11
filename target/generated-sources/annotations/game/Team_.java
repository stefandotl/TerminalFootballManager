package game;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Team.class)
public abstract class Team_ {

	public static volatile SingularAttribute<Team, TeamScore> teamsScore;
	public static volatile SingularAttribute<Team, String> name;
	public static volatile SingularAttribute<Team, Integer> teamStrength;

	public static final String TEAMS_SCORE = "teamsScore";
	public static final String NAME = "name";
	public static final String TEAM_STRENGTH = "teamStrength";

}

