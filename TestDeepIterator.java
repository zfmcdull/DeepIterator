import java.util.List; 
import java.util.ArrayList; 
import java.util.Iterator; 
import java.io.IOException;

class TestDeepIterator{
    
    public static void main(String[] argv)
    {
        // Create a nexted list [1, [2,3,4], [5,6]]
        NestedNode node1 = new NestedNode(1);
        NestedNode node2 = new NestedNode(2);
        NestedNode node3 = new NestedNode(3);
        NestedNode node4 = new NestedNode(4);
        NestedNode node5 = new NestedNode(5);
        NestedNode node6 = new NestedNode(6);

        List<NestedNode> list1 = new ArrayList<NestedNode>();
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);
        NestedNode innerList1 = new NestedNode(list1);

        List<NestedNode> list2 = new ArrayList<NestedNode>();
        list2.add(node5);
        list2.add(node6);
        NestedNode innerList2 = new NestedNode(list2);

        List<NestedNode> outterList = new ArrayList<NestedNode>();
        outterList.add(node1); 
        outterList.add(innerList1); 
        outterList.add(innerList2); 
        NestedNode inputNode = new NestedNode(outterList);

        DeepIterator itr = new DeepIterator(inputNode);

        System.out.println("Iterate all elements in the nested list");

        int count = 1;
        while(itr.hasNext())
        {
            System.out.println(itr.next()); 
            // remove the second node
            if(count == 2)
            {
                itr.remove();
            }
            count++;
        }

        // Iterate the new list with second item bing removed 
        System.out.println("Iterate all elements after deleting second node");
        itr = new DeepIterator(inputNode);
        while(itr.hasNext())
        {
            System.out.println(itr.next()); 
        }
    }
}
