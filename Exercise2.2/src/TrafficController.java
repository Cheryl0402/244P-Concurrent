public class TrafficController {
    private Boolean hasCar;

    TrafficController(){
        hasCar = false;
    }

    public synchronized void enterLeft(){
        // while there is no car, enter the bridge and set the condition to true.
        // while there is car, hasCar is true, then need to wait.
//        try{
//            while(hasCar){
//                Thread.sleep(5000);
//            }
//            hasCar = true;
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }

        try{
            while(hasCar){
                wait();
            }
            hasCar = true;

        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    public synchronized void enterRight(){
        // while there is no car, enter the bridge and set the condition to true.
        // while there is car, hasCar is true, then need to wait.
//        try{
//            while(hasCar){
//               Thread.sleep(5000);
//            }
//            hasCar = true;
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }


        try{
            while(hasCar){
                wait();
            }
            hasCar = true;

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public synchronized void leaveLeft() {
        //if left, set the condition to false, hasCar becomes false, other cars can enter the bridge
        hasCar = false;
        notify();
    }
    public synchronized void leaveRight() {
        //if left, set the condition to false, hasCar becomes false, other cars can enter the bridge
        hasCar = false;
        notify();
    }

}