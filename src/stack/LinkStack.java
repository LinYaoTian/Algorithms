package stack;

import adt.IStack;

public class LinkStack implements IStack {
	
	private Node head;
	private int size;
	
	 public static void main(String[] args) throws Exception {
	        //SequenceStack stack = new SequenceStack(10);
	        LinkStack stack = new LinkStack();
	        int temp;
	        for (int i = 0; i < 10; i++) {
	            temp = i;
	            stack.push(temp);
	        }
	        //遍历输出
	        while (!stack.isEmpty()) {
	            System.out.println(stack.pop());
	        }
	    }
	
	public LinkStack() {
		// TODO Auto-generated constructor stub
		size = 0;
		head = null;
	}

	@Override
	public void push(Object object) throws Exception {
		// TODO Auto-generated method stub
		Node node = new Node(object,head);
		head = node;
		size++;
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new Exception("栈为空，无法弹出元素！");
		}
		Node node = head;
		head = node.getNext();
		size--;
		return node;
	}

	@Override
	public Object getTop() throws Exception {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new Exception("栈为空，无法弹出元素！");
		}
		return head.getData();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}
	
	public class Node{
		
		private Object data;
		private Node next;
		
		public Node(Object data,Node next) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.next = next;
		}
		
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
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
			if (data != null) {
				return data.toString();
			}else {
				return "data is null";
			}
		}
		
		
	}

}
