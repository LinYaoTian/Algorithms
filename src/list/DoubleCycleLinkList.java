package list;


/**
 * 单向循环链表：只需添加一个尾指针指向最后链表的最后一个节点，而链表的最后一个节点指向头节点
 * @author lenovo
 *
 */
public class DoubleCycleLinkList implements IList {
	
	private Node head;//头节点
	private Node preNode;//当前操作节点的前一个节点
	private int size;//链表长度
	
	public DoubleCycleLinkList() {
		// TODO Auto-generated constructor stub
		head = preNode = new Node(null);
		size = 0;
		head.next = head;
		head.prior = head;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DoubleCycleLinkList list = new DoubleCycleLinkList();
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
	    System.out.println("\n------在index=9添加666之后-------");
	    list.insert(9, 666);
	    list.insert(10, 777);
	    for (int i = 0; i < list.size(); i++) {
		       System.out.print(list.get(i) + " ");
	    }
	}
	
	
	/**
	 * 定位函数
	 * 实现定位当前操作节点的前一个节点，也就是让 preNode 指向当前操作节点的前一个节点
	 */
	public void locatePreNode(int index)throws Exception {
		if (index > size || index < -1) {
			throw new Exception("参数错误！");
		}
		preNode = head;
		int j = 0;
		while (preNode.next != head && j < index) {
			preNode = preNode.next;
			j++;
		}
	}

	@Override
	public void insert(int index, Object obj) throws Exception {
		if (index > size || index < 0) {
			throw new Exception("参数错误！");
		}
		locatePreNode(index);
		Node newNode = new Node(obj,preNode,preNode.next);
		preNode.next.prior = newNode;
		preNode.next = newNode;
		size++;
	}

	@Override
	public void delete(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("链表为空，无法删除！");
		}
		if (index < 0 || index > size - 1) {
			throw new Exception("参数错误！");
		}
		locatePreNode(index);
		Node delNode = preNode.next;
		preNode.next = delNode.next;
		delNode.next.prior = preNode;
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
		if (isEmpty()) {
			throw new Exception("链表为空，无法删除！");
		}
		if (index < 0 || index > size - 1) {
			throw new Exception("参数错误！");
		}
		locatePreNode(index);
		return preNode.next.getData();
	}
	
	private class Node{
		
		private Object data;
		private Node prior;//指向前驱节点
		private Node next;//指向后继节点
		
		public Node(Node head) {
			// 构造头节点
			prior = head;
		}
		
		public Node(Object data,Node prior,Node next) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.next = next;
			this.prior = prior;
		}
		
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public Node getPrior() {
			return prior;
		}
		public void setPrior(Node prior) {
			this.prior = prior;
		}
		public Node getNext() {
			return next;
		}
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
