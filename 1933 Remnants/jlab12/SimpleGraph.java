/**
 This is a class derived and adapted from the textbook: DirectedGraph.java
 A class that implements the ADT directed graph.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 4.0
 */
import java.util.*;
import java.util.Map.Entry;

public class SimpleGraph<T> implements GraphInterface<T> {
    private HashMap<T,  VertexInterface<T>> vertices;
    private int edgeCount;

    public SimpleGraph() {
        vertices = new HashMap<T, VertexInterface<T>>();
        edgeCount = 0;
    }

    @Override
    public boolean addVertex(T vertexLabel) {
        return null == vertices.put(vertexLabel, new Vertex<>(vertexLabel));
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
            result = beginVertex.connect(endVertex, edgeWeight);

        if (result)
            edgeCount++;

        return result;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        return addEdge(begin, end, 0);
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        boolean found = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
        {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    found = true;
            } // end while
        } // end if

        return found;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public int getNumberOfVertices() {
        return vertices.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edgeCount;
    }

    @Override
    public void clear() {
        vertices.clear();
        edgeCount = 0;
    }

    @Override
    public VertexInterface<T> getVertex(T label) {
        return vertices.get(label);
    }

    private class VertexIterator implements Iterator<VertexInterface<T>> {
        private Iterator<Map.Entry<T, VertexInterface<T>>> verticeIterator;

        private VertexIterator() {
            verticeIterator = vertices.entrySet().iterator();
        } // end default constructor

        public boolean hasNext() {
            return verticeIterator.hasNext();
        } // end hasNext

        public  VertexInterface<T> next() {
            return verticeIterator.hasNext() ? vertices.get(verticeIterator.next().getValue().getLabel()) : null;
        } // end next
    }

    public VertexIterator getVertexIterator() {
        return new VertexIterator();
    }


    private void setAllVerticesUnvisited() { 
        Iterator<VertexInterface<T>> it = this.getVertexIterator();
        while (it.hasNext()) {
            VertexInterface<T> vi = it.next();
	    vi.unvisit();
	}
    }

    public Queue<VertexInterface<T>> _getBreadthFirstTraversal(T origin) {
        Queue<VertexInterface<T>> q = new LinkedList<VertexInterface<T>>();
        Queue<VertexInterface<T>> q2 = new LinkedList<VertexInterface<T>>();
        
        Iterator<VertexInterface<T>> ittr = getVertex(origin).getNeighborIterator();
        while(ittr.hasNext()) {
            VertexInterface<T> t = ittr.next();
            if(t.isVisited()) continue;
            t.visit();
            q.add(t);
            q2.add(t);
        }
        for(VertexInterface<T> ns : q) {
            Iterator<VertexInterface<T>> tr = _getBreadthFirstTraversal(ns.getLabel()).iterator();
            while(tr.hasNext()) {
                q2.add(tr.next());
            }
        }
        return q2;
    }
    
    @Override
    public Queue<VertexInterface<T>> getBreadthFirstTraversal(T origin) {
        setAllVerticesUnvisited();
        Queue<VertexInterface<T>> r = _getBreadthFirstTraversal(origin);
        setAllVerticesUnvisited();
        return r;
    }

    
    public Queue<VertexInterface<T>> _getDepthFirstTraversal(T origin) {
        Queue<VertexInterface<T>> q = new LinkedList<VertexInterface<T>>();
        Queue<VertexInterface<T>> q2 = new LinkedList<VertexInterface<T>>();
        
        Iterator<VertexInterface<T>> ittr = getVertex(origin).getNeighborIterator();
        while(ittr.hasNext()) {
            VertexInterface<T> t = ittr.next();
            if(t.isVisited()) continue;
            t.visit();
            q.add(t);
        }
        for(VertexInterface<T> ns : q) {
            Iterator<VertexInterface<T>> tr = _getDepthFirstTraversal(ns.getLabel()).iterator();
            q2.add(ns);
            while(tr.hasNext()) {
                q2.add(tr.next());
            }
        }
        return q2;
    }
    
    @Override
    public Queue<VertexInterface<T>> getDepthFirstTraversal(T origin) {
        setAllVerticesUnvisited();
        Queue<VertexInterface<T>> r = _getDepthFirstTraversal(origin);
        setAllVerticesUnvisited();
        return r;
    }

    public Map<T, Integer> measureDegrees() {
        Map<T, Integer> deg = new HashMap<T, Integer>();
        Iterator<Entry<T, VertexInterface<T>>> verts = vertices.entrySet().iterator();
        while(verts.hasNext()) {
            int i = 0;
            Entry<T, VertexInterface<T>> el = verts.next();
            Iterator<VertexInterface<T>> a = el.getValue().getNeighborIterator();
            while(a.hasNext()) {
                a.next();
                i++;
            }
            deg.put(el.getKey(), i);
        }
        return deg;
    }

    public static void main(String[] args) {
        GraphInterface<Integer> simpleGraph = new SimpleGraph();
        for (int i = 0; i < 10; i++)
            simpleGraph.addVertex(i);
        simpleGraph.addEdge(1, 6, 1.0);
        simpleGraph.addEdge(6, 1, 1.0);
        simpleGraph.addEdge(1, 9, 2.0);
        simpleGraph.addEdge(9, 1, 2.0);
        simpleGraph.addEdge(9, 7, 3.0);
        simpleGraph.addEdge(7, 9, 3.0);
        simpleGraph.addEdge(9, 8, 4.0);
        simpleGraph.addEdge(8, 9, 4.0);
        simpleGraph.addEdge(6, 5, 5.0);
        simpleGraph.addEdge(5, 6, 5.0);
        simpleGraph.addEdge(6, 4, 6.0);
        simpleGraph.addEdge(4, 6, 6.0);
        simpleGraph.addEdge(6, 2, 7.0);
        simpleGraph.addEdge(2, 6, 7.0);
        simpleGraph.addEdge(6, 3);
        simpleGraph.addEdge(3, 6);
        System.out.println(simpleGraph.getBreadthFirstTraversal(1));
        System.out.println(simpleGraph.getBreadthFirstTraversal(7));
        System.out.println(simpleGraph.getDepthFirstTraversal(1));
        System.out.println(simpleGraph.getDepthFirstTraversal(7));
        System.out.println(simpleGraph.measureDegrees());
    }
}
