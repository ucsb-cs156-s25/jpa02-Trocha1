package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_bool() {
        Team test_team = team;
        assertTrue(team.equals(test_team), "True, test_team should point to the same object as team");
        test_team = null;
        assertFalse(team.equals(test_team), "False, test_team is not an instance of team");
        test_team = new Team("new-team");
        assertFalse(team.equals(test_team), "False, test_team is another Team with name new-team");
        test_team.setName("test-team");
        assertTrue(team.equals(test_team), "True, test_team has same values as Team");
        test_team.addMember("Tristan");
        assertFalse(team.equals(test_team), "False, test_team does not have the same values as Team");
    }

    @Test
    public void hashCode_returns_correct_int_value() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
