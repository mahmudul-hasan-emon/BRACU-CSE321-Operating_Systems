// Do not modify this class
public class LabTask{
  public static void main(String[] args) throws InterruptedException {    
    QuestionBuffer questionBuffer = new QuestionBuffer();    
    StudentThread studentThread = new StudentThread(questionBuffer);
    TeacherThread teacherThread = new TeacherThread(questionBuffer);    
    teacherThread.start();
    studentThread.start(); 
    teacherThread.join();
    studentThread.stop();    
//TO-DO: Print the buffer pointer.    
  }
}