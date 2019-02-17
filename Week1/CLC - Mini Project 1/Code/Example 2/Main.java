package part2;

public class Main {

	public static void main(String[] args) {
		JavaBean myBean = new JavaBean();
		System.out.println(myBean.javaBeanConstructor());
		System.out.println(myBean.javaBeanGetMethod());
		System.out.println(myBean.javaBeanEventCall());
		System.out.println(myBean.javaBeanNamingMethod("SomeRandomName"));
		System.out.println(myBean.javaBeanEventResponse("Super Event"));
	}

}
