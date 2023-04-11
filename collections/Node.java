public class Node<T> {
    private T data;

    public void Show() {System.out.println("data: " + data);}
    public Node(T data) {this.data = data;}
    public void SetNode(T data) {this.data = data;}
    public T GetNode() {return this.data;}
}
