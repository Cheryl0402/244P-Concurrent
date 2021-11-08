import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class main {

    static HashMap<Integer,Thread> threadMap = new HashMap<>();

    public static void main(String args[]){
        //prepare to get input from user
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String[] inputArr;
        Integer id = 0;
        do{
            System.out.println("Here are your options: ");
            System.out.println("a - Create a new thread");
            System.out.println("b - Stop a given thread (e.g. 'b 2' killes thread 2)");
            System.out.println("c - Stop all threads and exit this program");

            userInput = scanner.nextLine();
            inputArr = userInput.trim().split(" ");

            switch(inputArr[0]){
                case "a": // create a new thread and start it.
                    Thread newThread = new Thread(new myThread()); //1, create a new myThread instance
                    id++;
                    newThread.setName(id.toString());               //2, give it a name(id)
                    newThread.start();                              //3, start the new thread
                    //store id and new thread to map.
                    threadMap.put(id, newThread);
                    break;

                case "b": // kill a specific thread
                    Integer threadId = Integer.valueOf(inputArr[1]);
                    Thread t = threadMap.get(threadId);  // get the thread according to input id
                    t.interrupt();                          // kill it
                    break;

                case "c": // stop all threads
                    for(Integer i : threadMap.keySet()){   //loop through the map keys
                        Thread thread = threadMap.get(i);  // get thread by id
                        thread.interrupt();                 // kill the thread
                    }
                    break;

                default:
                    break;
            }
        }while(!inputArr[0].equals("c"));
    }
}

class myThread implements Runnable{
    @Override
    public void run(){
         try{
             while(true){
                 System.out.println("Hello World! I am thread " + Thread.currentThread().getName()
                 + ". The time is " + LocalDateTime.now());
                 Thread.sleep(2000);
             }
         }catch(InterruptedException e){
            System.out.println("Thread " + Thread.currentThread().getName() + " has been killed");
         }
    }
}
