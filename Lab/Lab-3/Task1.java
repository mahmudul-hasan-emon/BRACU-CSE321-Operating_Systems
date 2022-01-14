class Task1 extends Thread{
  public Task1 (String name){
    super (name);
    
  } 
  @Override
  public void run(){
    System.out.println();
    if ("add".equals(getName())){
      Scanner sc=new Scanner(System.in);
      System.out.println("Please enter inputs for addition");
      int num1=sc.nextInt();
      int num2=sc.nextInt();
      int summ=num1+num2;
      System.out.println("The summ is "+ summ);
    }
    else if("sub".equals(getName())){
      Scanner sc=new Scanner(System.in);
      System.out.println("Please enter inputs for substraction:");
      int num1=sc.nextInt();
      int num2=sc.nextInt();
      int differ=num1-num2;
      System.out.println("The difference is "+ differ);
    }
    else if("mul".equals(getname())){
      Scanner sc=new Scanner(System.in);
      System.out.println("Please enter inputs for multiplication:");
      int num1=sc.nextInt();
      int num2=sc.nextInt();
      int prod=num1*num2;
      System.out.println("The product is "+ prod);
    }
    else if("div".equals(getname())){
      Scanner sc=new Scanner(System.in);
      System.out.println("Please enter inputs for division:");
      int num1=sc.nextInt();
      int num2=sc.nextInt();
      int div=num1/num2;
      System.out.println("Thedivision is "+ div);
    }
    else
      System.out.println("No valid operation");
    
  }
}



