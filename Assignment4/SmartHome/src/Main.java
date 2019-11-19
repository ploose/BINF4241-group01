import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        System.out.println("A");
        CleaningRobot r;
        Thread t = new Thread(r = new CleaningRobot(), "Robot Thread");
        System.out.println("B");
        t.start();

        r.setTimer(10);
        r.switchOn();

        System.out.println("C");
        System.out.println(r.checkBattery());

        while (true){
            int i;
            System.out.println("Options: s, p, r, t, i");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String userName = myObj.nextLine();  // Read user input
            if(userName.equals("s")){
                System.out.println("Started Robot");
                r.switchOn();

            }else if(userName.equals("p")){
                System.out.println("Paused Robot");
                r.switchOff();

            }else if(userName.equals("r")){
                System.out.println("__Report__");
                System.out.println("Charge: " + r.checkBattery());
                System.out.println("Progress: " + r.checkProgress());
                System.out.println("");

            }else if(userName.equals("t")){
                System.out.print("Seconds: ");
                i = myObj.nextInt();  // Read user input
                System.out.println("Set timer to "+i+"s");
                r.setTimer(i);
            }else if(userName.equals("i")){
                System.out.print("Interrupted program");
                r.interruptProgram();
            }
        }

    }
}
