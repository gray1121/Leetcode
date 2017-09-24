// only use iterator interface in java
// https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> listIter;
    private Iterator<Integer> intIter;
    public Vector2D(List<List<Integer>> vec2d) {
        listIter = vec2d.iterator();
    }

    @Override
    public Integer next() {
        // rearrange the position of this iterator
        hasNext();
        return intIter.next();
    }

    @Override
    public boolean hasNext() {
        // List<Integer> may be null or [ ]
        // so use while loop 
        while ((intIter == null || !intIter.hasNext())  && listIter.hasNext()) {
            intIter = listIter.next().iterator();
        }
        return listIter != null && intIter != null && intIter.hasNext();    
    }
}