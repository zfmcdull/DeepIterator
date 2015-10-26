import java.util.List;
import java.util.ArrayList; 

class NestedNode{
    public Integer val;
    public boolean isNum;
    public List<NestedNode> myList; 
    
    public NestedNode(Integer inVal)
    {
        val = inVal;
        isNum = true;
        myList = new ArrayList<NestedNode>();
    }

    public NestedNode(List<NestedNode> inputList)
    {
        myList = inputList;
        isNum = false;
    }

    public void setIsNum(boolean isNum)
    {
        this.isNum = isNum;    
    }

    public void append(NestedNode node)
    {
        myList.add(node);
    }
}


