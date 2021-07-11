package game;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TeamScore.class)
public abstract class TeamScore_ {

	public static volatile SingularAttribute<TeamScore, Integer> gamesPlayed;
	public static volatile SingularAttribute<TeamScore, Integer> goalsConceded;
	public static volatile SingularAttribute<TeamScore, String> name;
	public static volatile SingularAttribute<TeamScore, Integer> goalsScored;
	public static volatile SingularAttribute<TeamScore, Integer> points;

	public static final String GAMES_PLAYED = "gamesPlayed";
	public static final String GOALS_CONCEDED = "goalsConceded";
	public static final String NAME = "name";
	public static final String GOALS_SCORED = "goalsScored";
	public static final String POINTS = "points";

}

