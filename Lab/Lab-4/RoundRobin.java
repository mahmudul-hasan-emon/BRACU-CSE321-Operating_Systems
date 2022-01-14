import java.util.Scanner;
public class RoundRobin {
  public static void findWaitingTime(int waitingTime[], int n, int burstTime[], int quant, int completeTime[], int arrivalTime[]) {
    int rem[] = new int[n];
    for (int i = 0; i < waitingTime.length; i++) {
      rem[i] = burstTime[i];
    }
    int t = 0;
    int arrival = 0;
    while (true) {
      boolean done = true;
      for (int i = 0; i < n; i++) {
        if (rem[i] > 0) {
          done = false;
          if (rem[i] > quant && arrivalTime[i] <= arrival) {
            t += quant;
            rem[i] -= quant;
            arrival++;
          } else {
            if (arrivalTime[i] <= arrival) {
              arrival++;
              t += rem[i];
              rem[i] = 0;
              completeTime[i] = t;
            }
          }
        }
      }
      if (done == true) {
        break;
      }
    }
  }
  public static void findTurnArroundTime(int waitingTime[], int n, int burstTime[], int turnArroundTime[], int completeTime[], int arrivalTime[]) {
    for (int i = 0; i < n; i++) {
      turnArroundTime[i] = completeTime[i] - arrivalTime[i];
      waitingTime[i] = turnArroundTime[i] - burstTime[i];
    }
  }
  public static void find(int n, int burstTime[], int quant, int arrivalTime[]) {
    int waitingTime[] = new int[n];
    int turnArroundTime[] = new int[n];
    int completeTime[] = new int[n];
    findWaitingTime(waitingTime, n, burstTime, quant, completeTime, arrivalTime);
    findTurnArroundTime(waitingTime, n, burstTime, turnArroundTime, completeTime, arrivalTime);
    int totalWaitingTime = 0, totalTurnArroundTime = 0;
    for (int i = 0; i < n; i++) {
      totalWaitingTime = totalWaitingTime + waitingTime[i];
      totalTurnArroundTime = totalTurnArroundTime + turnArroundTime[i];
      System.out.println("Enter P" + (i+1) + " Completion Time: " + completeTime[i] + " Turnaround Time: " + turnArroundTime[i] + " Waiting Time: " + waitingTime[i]);
    }
    System.out.println();
    System.out.println("Average Turnaround Time: " + (float) totalTurnArroundTime / n);
    System.out.println("Average Waiting Time: " + (float) totalWaitingTime / n);
  }
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of process: ");
    int n = sc.nextInt();
    System.out.println();
    int arrivalTime[] = new int[n];
    int burstTime[] = new int[n];
    for (int i = 0; i < n; i++) {
      System.out.print("Enter  P" + (i + 1) + "'s arrival time: ");
      arrivalTime[i] = sc.nextInt();
      System.out.println();
      System.out.print("Enter P" + (i + 1) + "'s burst time: ");
      burstTime[i] = sc.nextInt();
      System.out.println();
    }
    int quant = 4;
    find(n, burstTime, quant, arrivalTime);
  }
}
