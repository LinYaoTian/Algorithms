package list;

public class Test {

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

}
