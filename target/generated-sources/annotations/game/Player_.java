package game;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Player.class)
public abstract class Player_ {

	public static volatile SingularAttribute<Player, String> teamName;
	public static volatile SingularAttribute<Player, Integer> skill;
	public static volatile SingularAttribute<Player, Integer> talent;
	public static volatile SingularAttribute<Player, String> name;
	public static volatile SingularAttribute<Player, PlayerPosition> additionalPosition1;
	public static volatile SingularAttribute<Player, PlayerPosition> additionalPosition2;
	public static volatile SingularAttribute<Player, Integer> id;
	public static volatile SingularAttribute<Player, PlayerPosition> position;
	public static volatile SingularAttribute<Player, PlayerPosition> additionalPosition3;

	public static final String TEAM_NAME = "teamName";
	public static final String SKILL = "skill";
	public static final String TALENT = "talent";
	public static final String NAME = "name";
	public static final String ADDITIONAL_POSITION1 = "additionalPosition1";
	public static final String ADDITIONAL_POSITION2 = "additionalPosition2";
	public static final String ID = "id";
	public static final String POSITION = "position";
	public static final String ADDITIONAL_POSITION3 = "additionalPosition3";

}

