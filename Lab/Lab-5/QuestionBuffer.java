import java.util.ArrayList;
import java.util.List;
class QuestionBuffer {  
  public int pointer = -1;  
  private List<String> registers = new ArrayList<>();  
  public synchronized String readQuestionFromReg() throws InterruptedException {    
    if (pointer == -1) wait();
    String temp = registers.get(pointer);
    pointer--;
    registers.remove(temp);    
    return temp;
  } 
  public synchronized void writeQuestionToReg(String value) throws InterruptedException {   
    registers.add(value);
    pointer++;
    if(pointer == 0) notifyAll(); 
  }
}
// Do not modify this class
class TeacherThread extends Thread { 
  private String[] values = {    
    "What is your name?",
    "What is your student ID?",
    "Please mention your course title,theory section and lab section.",
    "Have you received your first dose of covid-19 vaccine?",
    "Have you received your second dose of covid-19 vaccine?",
    "Are you prepared for offline classes in the upcoming semester?",
    "Write a few lines to describe yourself.",
  };  
  QuestionBuffer questionBuffer;  
  public TeacherThread(QuestionBuffer questionBuffer) {
    this.questionBuffer = questionBuffer;
  }  
  @Override
  public void run() {
    for (int i = 0 ; i < values.length ; i++) {
      try {
        questionBuffer.writeQuestionToReg(values[i]);
        sleep((int)(Math.random() * 1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
// Do not modify this class
class StudentThread extends Thread {  
  QuestionBuffer questionBuffer; 
  public StudentThread(QuestionBuffer questionBuffer) {
    this.questionBuffer = questionBuffer;
  }  
  @Override
  public void run() {
    try {
      while (true) {
        System.out.println(Thread.currentThread().getName() + " prints: " + questionBuffer.readQuestionFromReg());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

