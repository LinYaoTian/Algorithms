package list;

import adt.IList;

/**
 * 单链表
 * 平均时间复杂度：查找O(n)、插入O(1)
 * 优点：元素数量不受限，插入删除效率高。
 * 缺点：不支持随机查找查找效率低，每个节点需存储一个指针，空间利用率略低于顺序表。
 *
 */
public class LinkList implements IList {
	
	private Node head;//头指针
	private Node preNode;//当前节点的前一个节点的指针
	private int size;//链表长度
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkList list = new LinkList();
	    for (int i = 0; i < 10; i++) {
	        int temp = ((int) (Math.random() * 100)) % 100;
	        list.insert(i, temp);
	        System.out.print(temp + " ");
	    }
	    list.delete(4);
	    System.out.println("\n------删除第五个元素之后-------");
	    for (int i = 0; i < list.size(); i++) {
	       System.out.print(list.get(i) + " ");
       }
	    System.out.println("\n------在index=0添加666之后-------");
	    list.insert(0, 666);
	    for (int i = 0; i < list.size(); i++) {
		       System.out.print(list.get(i) + " ");
	       }
	}
	
	/**
	 * 初始化一个空的单链表
	 */
	public LinkList() {
		// TODO Auto-generated constructor stub
		head = preNode  = new Node(null);
		size = 0;
	}
	
	/**
	 * 定位函数，实现定位到当前操作对象的前一个节点，
	 * 也就是让当前节点对象定位到要操作节点的前一个节点；
	 * 比如我们要在a2这个节点之前进行插入操作，
	 * 那就先要把当前节点对象定位到a1这个节点，然后修改a1节点的指针域。
	 * @param index
	 */
	public void locatePreNode(int index)throws Exception{
		if (index < 0 || index > size) {
			throw new Exception("参数错误！");
		}
		preNode = head;
		int j = 0;//循环变量
		while(preNode != null && j < index){
			preNode = preNode.getNext();
			j++;
		}
	}
	

	@Override
	public void insert(int index, Object obj) throws Exception {
		if (index > size || index < 0) {
			throw new Exception("参数错误！");
		}
		//让 prePointer 定位到要操作节点的前一个节点
		locatePreNode(index);
		Node node = new Node(obj, preNode.getNext());
		preNode.setNext(node);
		size++;
	}

	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("单链表为空，无法删除元素！");
		}else if (index < 0 || index > size -1) {
			throw new Exception("参数错误！");
		} 
		locatePreNode(index);
		Node nextP = preNode.getNext().getNext();
		preNode.setNext(nextP);
		size--;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Object get(int index) throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("单链表为空，不能获取元素！");
		}else if (index < 0 || index > size -1) {
			throw new Exception("参数非法！");
		} 
		locatePreNode(index);
		return preNode.getNext().getData();
	}
	
	public boolean contains(Object object){
		if (object == null || isEmpty()) {
			return false;
		}
		Node p = head.getNext();
		while (p != null) {
			if (p.getData().equals(object)) {
				return true;
			}
			p = p.getNext();
		}
		return false;
	}
	
	private class Node {
		
		private Object data;//数据域
		private Node next;//指针域
		
		/**
		 * 头节点构造方法
		 */
		public Node(Node head) {
			// TODO Auto-generated constructor stub
			this.next = head;
		}
		
		/**
		 * 非头节点构造方法
		 * @param data
		 * @param next
		 */
		public Node(Object data,Node next) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.next = next;
		}
		
		/**
		 * 获取当前节点的指针域
		 * @return
		 */
		public Node getNext() {
			return next;
		}
		
		/**
		 * 获取当前节点的数据域
		 * @return
		 */
		public Object getData() {
			return data;
		}

		/**
		 * 设置当前节点的数据域
		 * @param data
		 */
		@SuppressWarnings("unused")
		public void setData(Object data) {
			this.data = data;
		}

		/**
		 * 设置当前节点的指针域
		 * @param next
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return data.toString();
		}
		
	}


}
