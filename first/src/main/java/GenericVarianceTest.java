import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericVarianceTest {

  public static boolean isTimeUnique(List<? extends TimePoint> list){
    Set<Long> set = new HashSet<>();
    for(TimePoint pt : list){
      if(set.contains(pt.getTime()))
        return false;
      set.add(pt.getTime());
    }
    return true;
  }

  public static void main(String[] args) {
    List<Position> positions = Arrays.asList(
        new Position(1, 1, 1),
        new Position(2, 2, 2),
        new Position(3, 3, 3)
    );
    assert isTimeUnique(positions);

    List<CompositePoint> pts = Arrays.asList(
        new CompositePoint(1, 1),
        new CompositePoint(2, 2),
        new CompositePoint(3, 3)
    );
    assert isTimeUnique(pts);

    List<TimePoint> mixed = Arrays.asList(
        new Position(1, 1, 1),
        new Position(2, 2, 2),
        new CompositePoint(3, 3)
    );
    assert isTimeUnique(mixed);
  }
}



interface TimePoint{
  long getTime();
}

class Position implements TimePoint{
  public long time;

  public double x;
  public double y;

  public Position(long time, double x, double y) {
    this.time = time;
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Position{" +
        "time=" + time +
        ", x=" + x +
        ", y=" + y +
        '}';
  }

  @Override
  public long getTime() {
    return 0;
  }
}

class CompositePoint implements TimePoint{
  public long time;

  public long linkId;

  public CompositePoint(long time, long linkId) {
    this.time = time;
    this.linkId = linkId;
  }

  @Override
  public long getTime() {
    return 0;
  }

  @Override
  public String toString() {
    return "CompositePoint{" +
        "time=" + time +
        ", linkId=" + linkId +
        '}';
  }
}