package game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class Player {

    Team team;
    String name;
    int skill;
    int talent;
    PlayerPosition position;
    PlayerPosition additionalPosition1;
    PlayerPosition additionalPosition2;
    PlayerPosition additionalPosition3;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, PlayerPosition position) {
        this.name = name;
        this.position = position;
    }

    public Player(String name,
                  PlayerPosition position,
                  PlayerPosition additionalPosition1) {
        this.name = name;
        this.position = position;
        this.additionalPosition1 = additionalPosition1;
    }

    public Player(String name,
                  PlayerPosition position,
                  PlayerPosition additionalPosition1,
                  PlayerPosition additionalPosition2) {
        this.name = name;
        this.position = position;
        this.additionalPosition1 = additionalPosition1;
        this.additionalPosition2 = additionalPosition2;
    }

    public Player(String name,
                  PlayerPosition position,
                  PlayerPosition additionalPosition1,
                  PlayerPosition additionalPosition2,
                  PlayerPosition additionalPosition3) {
        this.name = name;
        this.position = position;
        this.additionalPosition1 = additionalPosition1;
        this.additionalPosition2 = additionalPosition2;
        this.additionalPosition3 = additionalPosition3;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }

    public boolean hasName() {
        return !name.isEmpty();
    }
}
