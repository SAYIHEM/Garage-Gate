public class GarageDoor {

    private Motor motor;
    private DoorState currentState;


    public GarageDoor(){

    }

    public GarageDoor(Motor newMotor, DoorState currentState) throws NullPointerException{

        if (newMotor == null){
            throw new NullPointerException("Motor cannot be NULL!");
        }

        if (currentState == null){
            throw new NullPointerException("currentState cannot be NULL!");
        }

        this.motor = newMotor;
        this.currentState = currentState;
    }

    public void openDoor() throws IllegalStateException{

        if (this.currentState.equals(new Open()) || this.currentState.equals(new Opening())){
            throw new IllegalStateException("State have to be 'Closing' or 'Closed'!");
        }

        this.setState(new Opening());
        this.motor.upwards();
    }

    public void stopper() throws IllegalStateException{

        if (this.currentState.equals(new Closed()) || this.currentState.equals(new Open())){
            throw new IllegalStateException("Door has to be in state 'opening' or 'closing'!");
        }

        if (this.currentState.equals(new Opening())){

            this.motor.stop();
            this.setState(new Open());
        }
        else if (this.currentState.equals(new Closing())){

            this.motor.stop();
            this.setState(new Closed());
        }
    }

    public void closeDoor() throws IllegalStateException{

        if (this.currentState.equals(new Closed()) || this.currentState.equals(new Closing())){
            throw new IllegalStateException("State have to be 'Opening' or 'Open'!");
        }

        this.setState(new Closing());
        this.motor.downwards();
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
    private class Open extends DoorState {

        public Open(){

        }

        public void closeDoor(){

        }
    }

    private class Opening extends DoorState {

        public Opening(){

        }

        public void openDoor(){

        }

        public void stopper(){

        }
    }

    private class Closed extends DoorState {

        public Closed(){

        }

        public void openDoor(){

        }

    }

    private class Closing extends DoorState {

        public Closing(){

        }

        public void closeDoor(){

        }

        public void stopper(){

        }
    }
}
