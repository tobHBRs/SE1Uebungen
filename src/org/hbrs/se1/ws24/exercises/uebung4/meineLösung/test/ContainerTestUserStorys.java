package org.hbrs.se1.ws24.exercises.uebung4.meineLösung.test;
import org.hbrs.se1.ws24.exercises.uebung4.meineLösung.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTestUserStorys {

    private Container<UserStory> container;
    @BeforeEach
    void init(){
        container = Container.getContainer();
    }
    @Test
    void testAddDuplicateUserStory() {
        UserStory story = new UserStory(1, "Login Feature", "0.8", "LEA", 8,3,5,4);
        try {
            container.addUserStory(story);
            container.addUserStory(story); // Versuch, eine doppelte User Story hinzuzufügen
            fail("Expected ContainerException not thrown.");
        } catch (ContainerException e) {
            assertEquals("User Story bereits vorhanden!", e.getMessage());
        }
    }
    @Test
    void testDeleteNonExistentUserStory() {
        UserStory story = new UserStory(1, "Login Feature", "0.8", "LEA", 8,3,5,4);
        try {
            container.deleteUserStory(story);
            fail("Expected ContainerException not thrown.");
        } catch (ContainerException e) {
            assertEquals("User Story nicht vorhanden!", e.getMessage());
        }
    }

    @Test
    void testDumpSortsUserStories() throws ContainerException {
        UserStory story1 = new UserStory(1, "Low priority task", "0.5", "Low priority task", 8,3,5,4);
        UserStory story2 = new UserStory(2, "High priority task", "1.0", "High priority task", 10,5,3,1);
        container.addUserStory(story1);
        container.addUserStory(story2);

        container.dump(); // Die Liste soll nach der Priorität sortiert werden
        assertEquals(story1.getPriority() < story2.getPriority(),true);
    }
}
