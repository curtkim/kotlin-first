//https://codechacha.com/ko/java-covariance-and-contravariance/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generic_variance {
  public static void main(String[] args) {
    Double d = 0.1;
    assert( d instanceof Number);
    invariance();
    //covariance();
    //contravariance();
    //contravariance2();
    //both();
  }

  static void invariance(){
    List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
    //List<Number> numbers = doubles; // compile error
  }

  static void covariance() {
    List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
    List<? extends Number> numbers = doubles;

    Number number = numbers.get(0);
    System.out.println(number);
    //numbers.add(1.1); // compile error
  }

  static void contravariance() {
    List<Number> numbers = Arrays.asList(1.1, 2, 3L);
    List<? super Double> list = numbers;

    //Double number = list.get(0); // compile error
    list.add(new Double(4));
  }

  static void contravariance2() {
    List<Object> numbers = new ArrayList<Object>();
    List<? super Double> list = numbers;
    numbers.add(new Double(4.4));

    System.out.println(list);
  }


  static void both(){
    List<Integer> myInts = Arrays.asList(1,2,3,4);
    List<Double> myDoubles = Arrays.asList(3.14, 6.28);
    List<Object> myObjs = new ArrayList<Object>();

    copy(myInts, myObjs);
    copy(myDoubles, myObjs);
    for (Object obj : myObjs) {
      System.out.println(obj);
    }
  }

  static void copy(List<? extends Number> source, List<? super Number> destiny) {
    for(Number number : source) {
      destiny.add(number);
    }
  }

}
