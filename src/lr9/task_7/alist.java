package lr9.task_7;

import java.util.ArrayList;
import java.util.List;

public class alist {

    public static int ArrayList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int current = 0;
        while (list.size() > 1) {
            int toRemove = (current + 1) % list.size();
            list.remove(toRemove);
            current = toRemove;
        }
        return list.get(0);
    }

}
