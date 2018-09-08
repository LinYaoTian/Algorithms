package stack;

public class SequenceStack implements IStack {
	
	 private Object[] stack;//对象数组
	 private static final int DEFAULT_SIZE = 10;//默认栈大小
	 private int top;//栈顶位置
	 private int maxSize;//最大长度
	 
	 public static void main(String[] args) throws Exception {
	        SequenceStack stack = new SequenceStack(10);
	        int temp;
	        for (int i = 0; i < 10; i++) {
	            temp = i;
	            stack.push(temp);
	        }
	        stack.pop();
	        //遍历输出
	        while (!stack.isEmpty()) {
	            System.out.println(stack.pop());
	        }
	        
	    }

	 public SequenceStack() {
		 // TODO Auto-generated constructor stub
		 init(DEFAULT_SIZE);
	}
	 
	 public SequenceStack(int stackSize){
		 init(stackSize);
	 }
	 
	 public void init(int size) {
		this.maxSize = size;
		this.stack = new Object[size];
		this.top = -1;
	}
	 
	@Override
	public void push(Object object) throws Exception {
		// TODO Auto-generated method stub
		if (top == maxSize) {
			throw new Exception("栈已满，无法入栈！");
		}
		top++;
		stack[top] = object;
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		if (top == -1) {
			throw new Exception("栈为空，无法弹出元素！");
		}
		return stack[top--];
	}

	@Override
	public Object getTop() throws Exception {
		// TODO Auto-generated method stub
		if (top == maxSize) {
			throw new Exception("栈已满，无法入栈！");
		}
		return stack[top];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == -1;
	}

}
