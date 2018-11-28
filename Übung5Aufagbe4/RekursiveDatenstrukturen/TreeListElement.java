public class TreeListElement{
    private Tree value;

    private TreeListElement next;

    /**
     * @param inputValue The value of the new TreeListElement
     * @param inputNext The next elements of the TreeListElement
     */
    public TreeListElement(Tree inputValue, TreeListElement inputNext){
        this.value = inputValue;
        this.next = inputNext;
    }

    public TreeListElement(final int i, final Tree... trees){
        this.value = trees[i];
        this.next = null;
        if (i+1<trees.length){
            this.next = new TreeListElement(i+1,trees);
        }
    }

    //a)
    public Tree getValue(){
        return value;
    }

    public void setValue(Tree value){
        this.value = value;
    }

    public TreeListElement getNext(){
        return next;
    }

    public void setNext(TreeListElement next){
        this.next = next;
    }
    //b)
    public String toString(){
        String result = "";
        if(this.getValue() != null){
            result += this.getValue().toString();
        }
        if(this.getNext() != null){
            result += "," + this.getNext().toString();
        }
        return result;
    }
    //c)
    public int branchingDegree(){
        int x = iterration();
        int a;
        if(this.getNext() == null){
            a = this.getValue().branchingDegree();
        }
        else{
            a = this.getNext().branchingDegree();
        }
        if(x>a){
            return x;
        }
        return a;
    }

    private int iterration(){
        if(this.getNext() == null){
            return 1;
        }
        return this.getNext().branchingDegree() + 1;
    }
    //d)
    public boolean contains(int toSearch){
        if((this.getValue()!=null && this.getValue().contains(toSearch))||(this.getNext()!=null && this.getNext().contains(toSearch))){
            return true;
        }
        return false;
    }
    //e)
    public static TreeListElement buildTree(Tree...children) {
        TreeListElement treelistelement = null;
        if (children.length == 1) {
            treelistelement = new TreeListElement(children[0],null);   
        } else if (children.length > 1){
            treelistelement = new TreeListElement(0,children);
        }
        return treelistelement;

    }
}
