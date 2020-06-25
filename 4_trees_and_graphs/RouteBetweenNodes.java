import java.util.LinkedList;
import java.util.Queue;


public class RouteBetweenNodes<Item> {

    public boolean isThereRouteBFS(Vertex<Item> s, Vertex<Item> t) {
        Queue<Vertex<Item>> q = new LinkedList<Vertex<Item>>();
        q.add(s);
        s.visited = true;

        while (!q.isEmpty()) {
            Vertex<Item> r = q.remove();
            for (Vertex<Item> v : r.neighbors) {
                if (v.visited == false) {
                    if (v == t) return true;
                    v.visited = true;
                    q.add(v);
                }
            }
        }
        return false;
    }
}