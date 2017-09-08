package myforum;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TreeSet方法调用了compareTo方法自然排序来比较两个对象的大小 返回值为整数类型 x.compareTo(y)
		// 返回值为0 说明x=y 返回值>0 说明x>y 返回值<0 说明x<y
		//使用自然排序是，只能想TreeSet容器中添加相同类型的对象
		Set set = new TreeSet();
		set.add((new String("spring")));
		set.add("123");
		set.add((new String("autumn")));
		set.add((new String("winter")));
		System.out.println(set);
	}
}
