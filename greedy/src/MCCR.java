import java.util.*;

public class MCCR {
        public static int MCCR(EdgeWeightedGraph G) {
            int total = 0;

            //Initialization
            IndexPQ indexPQ = new IndexPQ(G.numberOfV());
            HashSet<Integer> inqueue = new HashSet<>();
            HashMap<Integer, Integer> parents = new HashMap<>();

            Iterator<Integer> vertices = G.vertices.iterator();
            int firstv = vertices.next();

            //Pick start point, and assign 0 as its key value
            indexPQ.insert(firstv, 0);
            parents.put(firstv, -1);
            inqueue.add(firstv);

            for (Iterator<Integer> it = vertices; it.hasNext(); ) {
                int i = it.next();
                //assign each Node's key to be infinite number
                indexPQ.insert(i, 100000);
                inqueue.add(i);
            }
            
            while(!indexPQ.isEmpty()){
                int u = indexPQ.delMin();
                inqueue.remove(u);
                for(Edge e: G.edges(u)){
                    int vertex = e.other(u);
                    if(inqueue.contains(vertex) && e.weight() < (int)(indexPQ.keys[vertex])){
                        parents.put(vertex, u);
                        indexPQ.changeKey(vertex, e.weight());
                    }
                }
            }

            for (int parent:parents.keySet()) {
                for(Edge e: G.edges(parent)){
                    if(e.other(parent) == parents.get(parent)){
                        total = total + e.weight();
                    }
                }
            }
            return total;
        }
    }

