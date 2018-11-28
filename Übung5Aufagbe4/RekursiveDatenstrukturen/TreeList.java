public class TreeList
{
    private TreeListElement head;

    public TreeList(){
        this.head = null;
    }

    public  TreeList(TreeListElement head){
        this.head = head;
    }

    //a)
    public TreeListElement getHead(){
        return head; 
    }

    public void setHead(TreeListElement head){
        this.head = head;
    }
    //b)
    public String toString(){
        String result = "";
        if(this.getHead() != null){
            result += this.getHead().toString();
        }
        return result;
    }
    //c)
    public int branchingDegree(){
        if(this.getHead() == null){
            return 0;
        }
        return head.branchingDegree();
    }
    //d)
    public boolean contains(int toSearch){
        if(this.getHead()!=null){
            return this.getHead().contains(toSearch);
        }
        return false;
    }
    //e)
    public static TreeList buildTree(Tree...children) {
        TreeList treelist = new TreeList();
        treelist.setHead(TreeListElement.buildTree(children));
        return treelist;
    }
}
