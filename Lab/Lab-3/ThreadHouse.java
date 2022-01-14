public class ThreadHouse {
  public static void main (String[]args){
    Task2 Stark = new Task2 ("House Stark");
    Task2 Targaryen = new Task2 ("House Targaryen");
    Task2 Lannister = new Task2 ("House Lannister");
    Task2 Bolton = new Task2 ("House Bolton");
    Task2 Tyrell = new Task2 ("House Tyrell");
    
    Stark.setPriority(Thread.MAX_PRIORITY);
    Bolton.setPriority(Thread.MIN_PRIORITY);
    
    Stark.run();
    Targaryen.run();
    Lannister.run();
    Bolton.run();
    
    Stark.start();
    Tyrell.start();
    Lannister.start();
    Bolton.start();
    
    if(Stark.isAlive()){
      System.out.println("Not Today!");
    }
    if( !Bolton.isAlive()){
      System.out.println("You know nothing!");
    }
  }
}

