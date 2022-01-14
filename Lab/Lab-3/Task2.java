class Task2 extends Thread{
  public Task2 (String name){
    super (name);
  }
  @override
  public void run(){
    System.out.println("The house is "+getName());
    if("House Stark".equals(getName())){
      try{
        sleep(1000);
      }
      catch (InterruptedException ex){
        Logger.getLogger(MyHouse.class.getName());
      }
      else if("House Lannister".equals(getName()))
      {
        try
        {
          sleep(2000);
        }
        catch (InterruptedException ex)
        {
          Logger.getLogger(MyHouse.class.getName());
        }
      }
      else
      {
        try
        {
          sleep(3000);
        }
        catch (InterruptedException ex){
          Logger.getLogger(MyHouse.class.getName());
        }
      }
    }
  }
}
