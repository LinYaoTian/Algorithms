package list;
//线性表接口
public interface IList {
	//在index上插入一个元素
	void insert(int index,Object obj)throws Exception;
	//删除元素
	void delete(int index)throws Exception;
	//获取表的长度
	int size();
	//判断线性表是否为空
	boolean isEmpty();
	//获取指定位置的元素
	Object get(int index)throws Exception;

}
