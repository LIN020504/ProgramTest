package Test;

import Method.Story.Environment;
import Method.Story.ObjectItems;
import Method.Story.Person;
import Method.Story.Phenomenon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StoryTest {
    @Test
    void testPersonCreation(){
        Person arthur = new Person("Arthur","positive",1);

        assertEquals("Arthur",arthur.getName());
        assertEquals("test",arthur.getState());
        assertEquals(1,arthur.getAttentionLevel());
    }

    @Test
    void testObjectCreation(){
        ObjectItems items = new ObjectItems("Test",false);
        items.use();
        assertTrue(items.isActive());
    }

    @Test
    void testPhenomenon(){
        Phenomenon phenomenon = new Phenomenon("shadow",1);

        assertEquals("shadow",phenomenon.getType());
        assertEquals(1,phenomenon.getIntensity());
    }

    @Test
    void testEnvironment(){
        Environment environment = new Environment("bad smell","buzzing");
        Phenomenon shadow = new Phenomenon("shadow",5);

        environment.addPhenomenon(shadow);
        assertEquals(1,environment.getPhenomenon().size());
    }

    @Test
    void testPerceive(){
        Person arthur = new Person("Arthur","positive",6);
        Phenomenon shadow = new Phenomenon("shadow",2);

        arthur.perceive(shadow);
        assertEquals(4,arthur.getAttentionLevel());
    }

}
