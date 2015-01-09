package graph;
public class LabeledEdge<V extends Comparable<V>,L> extends Triple<V,V,L> {
  public LabeledEdge() {
    super();
  }
  public LabeledEdge(V firstVertex,V secondVertex,
                     L label) {
    super(firstVertex,secondVertex,label);
  }
  public L getLabel() {
    return getThird();
  }
  public V getFirstVertex() {
    return getFirst(); 
  }
  public V getSecondVertex() {
    return getSecond();
  }
}