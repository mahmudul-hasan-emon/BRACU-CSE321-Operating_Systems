import java.util.*;
public class SJF {
  public static void main (String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.println ("Enter no of process: ");
    int n= sc.nextInt();
    int pid[] = new int[n]; 
    int arrivalTime[] = new int[n]; 
    int burstTime[] = new int[n];
    int completeTime[] = new int[n]; 
    int turnArroundTime[] = new int[n];
    int waitingTime[] = new int[n];  
    int fg[] = new int[n];  
    int k[]= new int[n];  
    int i, st=0, totalTime=0;
    float averageWaitingTime=0, averageTurnarroundTime=0; 
    for (i=0;i<n;i++)
    {
      pid[i]= i+1;
      System.out.println ("Enter P" +(i+1)+ " arrival time:");
      arrivalTime[i]= sc.nextInt();
      System.out.println("Enter P" +(i+1)+ " burst time:");
      burstTime[i]= sc.nextInt();
      k[i]= burstTime[i];
      fg[i]= 0;
    }    
    while(true){
      int min=99,c=n;
      if (totalTime==n)
        break;    
      for ( i=0;i<n;i++)
      {
        if ((arrivalTime[i]<=st) && (fg[i]==0) && (burstTime[i]<min))
        {
          min=burstTime[i];
          c=i;
        }
      }   
      if (c==n)
        st++;
      else
      {
        burstTime[c]--;
        st++;
        if (burstTime[c]==0)
        {
          completeTime[c]= st;
          fg[c]=1;
          totalTime++;
        }
      }
    } 
    for(i=0;i<n;i++)
    {
      turnArroundTime[i] = completeTime[i] - arrivalTime[i];
      waitingTime[i] = turnArroundTime[i] - k[i];
      averageWaitingTime+= waitingTime[i];
      averageTurnarroundTime+= turnArroundTime[i];
    }  
    System.out.println("pid  arrivalTime  burstTime  completeTIme turnArroundTime waitingTime");
    for(i=0;i<n;i++)
    {
      System.out.println(pid[i] +"\t"+ arrivalTime[i]+"\t"+ k[i] +"\t"+ completeTime[i] +"\t"+ turnArroundTime[i] +"\t"+ waitingTime[i]);
    }    
    System.out.println("\naverage turn around time is "+ (float)(averageTurnarroundTime/n));
    System.out.println("average waiting time is "+ (float)(averageWaitingTime/n));
    sc.close();
  }
}
