import java.util.ArrayList;
import java.util.List;

/*
* https://en.wikipedia.org/wiki/Bubble_sort
*/
public class BubbleSort {

  public List<Integer> sort(List<Integer> value) {
    List<Integer> result = new ArrayList<>(value);
    for (int j = 0; j < result.size(); j++) {
      for (int i = 0; i < result.size()-1-j; i++) {
        if (result.get(i) > result.get(i + 1)) {
          Integer tmp = result.get(i);
          result.set(i, result.get(i + 1));
          result.set(i + 1, tmp);
        }
//        System.out.println("(i:"+i+",j:"+j+"):"+result);
      }
    }
    return result;
  }
}
