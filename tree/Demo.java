package tree;

/*
 * ���������������ƶ��֣�
 * ÿ���ڵ�����ӽڵ�ȵ�ǰ�ڵ�С�����ӽڵ�ȵ�ǰ�ڵ��
 */

import java.util.ArrayList;

public class Demo {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
	//��ArrayListΪ���������ײ�������������������
	@SuppressWarnings("rawtypes")
	//ArrayListά�������� transient Object[] elementData;
	
	/*
	 * ArrayList�ײ���Ȼ�ǽ���������չ
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
