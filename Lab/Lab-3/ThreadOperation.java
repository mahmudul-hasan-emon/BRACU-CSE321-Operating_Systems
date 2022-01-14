public class ThreadOperation {
    public void main(String[] args) {
  
        Task1 addition=new Task1("add");
        Task1 substraction=new Task1("sub");
        Task1 multiplication=new Task1("mul");
        Task1 division=new Task1("div");
        Task1 other=new Task1("oth");
        
        addition.run();
        substraction.run();
        multiplication.run();
        division.run();
        other.run();
    }
}