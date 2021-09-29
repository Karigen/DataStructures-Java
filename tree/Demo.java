package tree;

/*
 * 二叉排序树（类似二分）
 * 每个节点的左子节点比当前节点小，右子节点比当前节点大
 */

import java.util.ArrayList;

public class Demo {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
	//以ArrayList为例，看看底层是怎样进行数组扩容
	@SuppressWarnings("rawtypes")
	//ArrayList维护了数组 transient Object[] elementData;
	
	/*
	 * ArrayList底层仍然是进行数组扩展
	 * 
	 * private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData,
                                           newCapacity(minCapacity));
    }
	 * 
	 *  private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
            ? newCapacity
            : hugeCapacity(minCapacity);
    }
	 */
	ArrayList arrayList=new ArrayList();
    }

}
