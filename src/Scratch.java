/**
 * Created by adityajoshee on 13/04/16.
 */
public class Scratch {

  public static void main(String args[]){
    func1();

  }

  static void func1(){
    Carry carry = new Carry();
    int i=0;
    func2(i,carry);
    System.out.print(i+" "+carry);
  }

  static void func2(int i, Carry c){
    if(i>10){
      return;
    }
    i++;
    func2(i,c);
    c.value = c.value+ 1;
    System.out.println(">"+i+" "+c.value);
  }

  static class Carry{
    public int value = 0;
  }


}
