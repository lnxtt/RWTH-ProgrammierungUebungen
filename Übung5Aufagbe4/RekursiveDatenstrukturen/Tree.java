public class Tree
{
    private int label;

    private TreeList children;

    public Tree(int inputLabel, TreeList inputChildren){
        this.label = inputLabel;
        this.children = inputChildren;
    }

    //a)
    public int getLabel(){
        return label; 
    }

    public void setLabel(int label){
        this.label = label;
    }

    public TreeList getChildren(){
        return children;
    }

    public void setChildren(TreeList children){
        this.children = children;
    }
    //b)

    public String toString(){
        String result = this.getLabel() + "->[";
        if(this.getChildren() != null){
            result += this.getChildren().toString();
        }
        return result + "]";
    }

    //c)

    public int branchingDegree(){
        if(this.getChildren().getHead()==null){
            return 0;
        }
        return this.getChildren().branchingDegree();
    }

    //d)

    public boolean contains(int toSearch){
        if(this.getLabel() == toSearch ||(this.getChildren() != null && this.getChildren().contains(toSearch) )){
            return true;
        }
        return false;
    }

    //e)

    public static Tree buildTree(int value, Tree... children){
        TreeList treelist;
        if (children.length == 0) return new Tree(value, new TreeList());
        else {
            treelist = TreeList.buildTree(children);
        }
        Tree tree = new Tree(value, treelist);
        return tree;
    }
    /**
     * Method for trying out some of the implemented commands.
     * @param args input strings from the console
     */

    public static void main(String[] args){
        Tree[] trees = {buildTree(1,buildTree(2),buildTree(3),buildTree(4)), buildTree(-1) , buildTree(4,buildTree(1,buildTree(1,buildTree(1,buildTree(1),buildTree(1),buildTree(1)),buildTree(1),buildTree(1))),buildTree(2),buildTree(2,buildTree(2))),
                buildTree(72, buildTree(27), buildTree(11), buildTree(54,buildTree(89,buildTree(10),buildTree(20),buildTree(42))), buildTree(23)),
                buildTree(54,buildTree(89,buildTree(10),buildTree(20),buildTree(42)))};

        for(Tree tree:trees){
            if(tree != null){
                String test = "";
                test = test + tree.toString() + "\n";
                test = test + "Branching Degree: " + tree.branchingDegree() + "\n";
                test = test + "2 contained: " + tree.contains(2) + "\n";
                test = test + "42 contained: " + tree.contains(42) + "\n";
                test = test + "1 contained: " + tree.contains(1) + "\n";
                SimpleIO.output(test);
            }
        }

    }

}
