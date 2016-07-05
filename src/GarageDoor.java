public class GarageDoor {

    static private Motor motor = new Motor();
    static private DoorState currentState = new Closed();


    public GarageDoor(){

    }

    public void openDoor() {

        this.currentState.openDoor();
    }

    public void stopper() {

        this.currentState.stopper();
    }

    public void closeDoor(){

        this.currentState.closeDoor();
    }

    public Motor getMotor(){

        return this.motor;
    }

    private void setState(DoorState ds) throws NullPointerException{

        if (ds == null){
            throw new NullPointerException("DoorState cannot be NULL!");
        }

        this.currentState = ds;
    }

    // INNER CLASSES //
    static abstract class DoorState {

        public void openDoor(){

            if (currentState.getClass().equals(new Open().getClass()) ||
                currentState.getClass().equals(new Opening().getClass())){

                throw new IllegalStateException("Illegal State!");
            }
        }

        public void closeDoor() throws IllegalStateException{

            if (currentState.getClass().equals(new Closed().getClass()) ||
                currentState.getClass().equals(new Closing().getClass())){

                throw new IllegalStateException("Illegal State!");
            }
        }

        public void stopper() throws IllegalStateException{

            if (currentState.getClass().equals(new Open().getClass()) ||
                currentState.getClass().equals(new Closed().getClass())){

                throw new IllegalStateException("Illegal State!");
            }
        }
    }

    static class Open extends DoorState {

        public Open(){

        }

        public void closeDoor() {

            currentState = new Closing();
            motor.downwards();
        }
    }

    static class Opening extends DoorState {

        public Opening(){

        }

        public void closeDoor(){

            currentState = new Closing();
            motor.downwards();
        }

        public void stopper(){

            motor.stop();
            currentState = new Open();
        }
    }

    static class Closed extends DoorState {

        public Closed(){

        }

        public void openDoor(){

            currentState = new Opening();
            motor.upwards();
        }
    }

    static class Closing extends DoorState {

        public Closing(){

        }

        public void openDoor(){

            currentState = new Opening();
            motor.upwards();
        }

        public void stopper(){

            motor.stop();
            currentState = new Closed();

        }
    }
}
