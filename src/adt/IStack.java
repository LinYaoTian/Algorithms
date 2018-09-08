package adt;

public interface IStack {
	//入栈
	public void push(Object object) throws Exception;
	//出栈
	public Object pop() throws Exception;
	//获取栈顶元素
	public Object getTop() throws Exception;
	//判断栈是否为空
	public boolean isEmpty();
}
