import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StatePatternTest extends DoorStateBaseTest {
    private String methodOpenDoor = "openDoor";
    private String methodCloseDoor = "closeDoor";
    private String methodStopper = "stopper";

    @Test
    public void testDoorState() {
        assertTrue("DoorState should have a method named " + methodOpenDoor + "!",
                searchForMethod("DoorState", methodOpenDoor));
        assertTrue("DoorState should have a method named " + methodCloseDoor + "!",
                searchForMethod("DoorState", methodCloseDoor));
        assertTrue("DoorState should have a method named " + methodStopper + "!",
                searchForMethod("DoorState", methodStopper));
    }

    private boolean searchForMethod(String name, String method, Class<?>... args) {
        for (Class<?> c : GarageDoor.class.getDeclaredClasses()) {
            if (c.getSimpleName().equals(name)) {
                try {
                    c.getMethod(method, args);
                    return true;
                } catch (NoSuchMethodException ex) {
                    return false;
                }
            }
        }
        return false;
    }
}
