package list;
/**
 * 顺序存储的顺序表
 * 平均时间复杂度：查找 O(1)、插入删除 O(n)
 * 优点：支持随机访问，空间利用率高
 * 缺点：大小固定；插入和删除元素需要移动大量的数据
 */
public class SequenceList implements IList {
	
	//当前长度
	int size;
	//最大长度
	int maxSize;
	//默认长度
	final int defaltSize = 20;
	//对象数组
	Object[] listArray;
	
	public SequenceList(){
		init(defaltSize);
	}
	
	public SequenceList(int size){
		init(size);
	}
	
	private void init(int size) {
		listArray = new Object[size];
		this.size = 0;
		maxSize = size;
	}

	@Override
	public void insert(int index, Object obj) throws Exception {
		if (size == maxSize) {
			throw new Exception("顺序表已满，无法插入！");
		}else if (index < 0 || index > size) {
			throw new Exception("参数错误！");
		}
		//移动元素
		for (int i = size - 1; i >= index; i--) {
			listArray[i+1] = listArray[i];
		}
		listArray[index] = obj;
		size++;
	}

	@Override
	public void delete(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("顺序表为空，无法删除！");
		}else if (index > size) {
			throw new Exception("参数错误！");
		}
		//移动元素
		for (int i = index; i < size; i++) {
			listArray[index] = listArray[index+1];
		}
		size--;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object get(int index) throws Exception{
		if (index > size || index < 0) {
			throw new Exception("参数错误！");
		}
		return listArray[index];
	}

}
