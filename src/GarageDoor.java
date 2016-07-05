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

    public void openDoor(){

    }

    public void stopper(){

    }

    public void closeDoor(){

    }

    public Motor getMotor(){

        return null;
    }

    private void setState(DoorState ds){

    }
}
