import java.util.*;

public class TreeNodeImpl implements TreeNode{

    public Object object;
    private TreeNode parent;
    private List<TreeNode> childList = new ArrayList<>();
    public boolean isExpended;
    public TreeNodeImpl() {
        this.isExpended = false;
    }

    public TreeNodeImpl(Object object) {
        this.isExpended = false;
        this.object = object;
    }
    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {

        if(this.getParent() == null)
            return null;
        return parent.getRoot();
    }

    @Override
    public boolean isLeaf() {

        if(childList.size() > 0)
            return false;
        return true;
    }

    @Override
    public int getChildCount() {
        return childList.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return childList.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        childList.add(child);
        childList.get(childList.size() - 1).setParent(this);
    }


    @Override
    public boolean removeChild(TreeNode child) {

        boolean statusRemove = childList.remove(child);
        if(statusRemove)
            child.setParent(null);
        return statusRemove;
    }

    @Override
    public boolean isExpanded() {

        return isExpended;
    }

    @Override
    public void setExpanded(boolean expanded) {

        if(this == null)
            return;

        this.isExpended = expanded;
        for(int i = 0; i < childList.size(); i++)
            childList.get(i).setExpanded(expanded);
    }

    @Override
    public Object getData() {
        return object;
    }

    @Override
    public void setData(Object data) {
        this.object = data;
    }

    @Override
    public String getTreePath() {

        if(this.getParent() == null)
            return this.getData().toString();
        return this.getParent().getTreePath() + "->" + this.getData().toString();
    }

    @Override
    public TreeNode findParent(Object data) {

        if(data == null) {

            if(this.getParent() == null && this.getData() != null)
                return null;

            if(this.getData() != null)
                return this.getParent().findParent(data);

            else
                return this;
        }

        if(this.getData() == null)
            return null;

        if(this.getData().equals(data))
            return this;

        if(this.getParent() == null)
            return null;

        return this.getParent().findParent(data);
    }

    @Override
    public TreeNode findChild(Object data) {

        SaveLink saveLink = new SaveLink();
        printInorder(this, data, saveLink);
        return saveLink.save;



//        if(this == null)
//            return null;
//
//        System.out.println(this.getData());
//        if(data != null && this.getData().equals(data))
//            return this;
//
//        for(int i = 0; i < childList.size(); i++) {
//            childList.get(i).findChild(data);
//        }
//
//        return null;
    }

    private void printInorder(TreeNode treeNode, Object data, SaveLink save) throws NullPointerException {

        Iterator<TreeNode> iterator = treeNode.getChildrenIterator();
        while(iterator.hasNext()){

            TreeNode saveTreeNode = iterator.next();
            printInorder(saveTreeNode, data, save);

            if(data == null && saveTreeNode.getData() == null) {
                save.save = saveTreeNode;
                return;
            }

            if (saveTreeNode.getData() != null && saveTreeNode.getData().equals(data)) {
                save.save = saveTreeNode;
                return;
            }
        }
    }

    class SaveLink {
        public TreeNode save;
    }
}
