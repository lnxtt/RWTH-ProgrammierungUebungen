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
    /**
     * @return string of all trees, which are part of this TreeList
     */
    public String toString(){
        String result = "";
        if(this.getHead() != null){
            result += this.getHead().toString();
        }
        return result;
    }
    //c)
    /**
     * @return the branchingDegree of this TreeList
     */
    public int branchingDegree(){
        if(this.getHead() == null){
            return 0;
        }
        return head.branchingDegree();
    }
    //d)
    /**
     * search for a value in this TreeList
     * @param toSearch The value which will be searched
     * @return if the value was found or not
     */
    public boolean contains(int toSearch){
        if(this.getHead()!=null){
            return this.getHead().contains(toSearch);
        }
        return false;
    }
    //e)
    /**
     * create a new TreeList
     * @param children Trees, which will be the in this TreeList
     */
    public static TreeList buildTree(Tree...children) {
        TreeList treelist = new TreeList();
        treelist.setHead(TreeListElement.buildTree(children));
        return treelist;
    }
}
