package lr9.task_7;
import java.util.LinkedList;
import java.util.List;

public class llist {

    public static int LinkedListByIndex(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int current = 0;
        while (list.size() > 1) {
            int toRemove = (current + 1) % list.size();
            list.remove(toRemove); // требует прохода от начала
            current = toRemove;
        }
        return list.get(0);
    }

}
