import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.io.IOException;
import java.util.Iterator;

class DeepIterator implements Iterator{
    NestedNode node;
    Integer item;
    boolean canRemove = false;
    Stack< Entry<NestedNode, Integer> > stk = new Stack<Entry<NestedNode,Integer>>();
   
    public DeepIterator(NestedNode node)
    {
        this.node = node;
        item = null;
        if(node.isNum)
        {
            item = node.val;
        }
        else
        {
            Entry<NestedNode,Integer> pair = new java.util.AbstractMap.SimpleEntry<>(node,0);
            stk.push(pair);
        }
        hasNext();
    }

    public boolean hasNext()
    {
       if(item != null)
           return true;
       
       while(!stk.empty())
       {
           Entry<NestedNode, Integer> currPair = stk.peek();     
           NestedNode topNode = currPair.getKey();
           Integer index = currPair.getValue();
           if(index >= topNode.myList.size())
           {
               stk.pop();
           }
           else
           {
               currPair.setValue(index+1);
               NestedNode currNode= topNode.myList.get(index);
               if(currNode.isNum)
               {
                   item = currNode.val;
                   canRemove = true;
                   return true;
               }
               else
               {
                   Entry<NestedNode,Integer> pair = new java.util.AbstractMap.SimpleEntry<>(currNode,0);
                   stk.push( pair );
               }
           }
       }
       return false;
    }

    public Integer next() 
    {
        if( hasNext())
        {
            Integer val = item;
            item = null;
            return val;
        }
        else
        {
            System.out.println("End of list");
            return -1;
        }
    }

    public void remove() 
    {
        if(canRemove){
            Entry<NestedNode, Integer> currPair = stk.peek();     
            NestedNode currNode = currPair.getKey();
            Integer idx = currPair.getValue();
            currNode.myList.remove((int)idx-1);
            currPair.setValue(idx-1);
        }
        else
        {
            System.out.println("Can't Remove");
        }
    }

    public void resetItr()
    {
        item = null;
        canRemove = false;
        while(!stk.empty())
        {
            stk.pop();
        }
        if(node.isNum)
        {
            item = node.val;
        }
        else
        {
            Entry<NestedNode,Integer> pair = new java.util.AbstractMap.SimpleEntry<>(node,0);
            stk.push(pair);
        }
        hasNext();
    }
}


