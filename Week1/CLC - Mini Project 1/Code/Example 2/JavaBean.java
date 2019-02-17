package part2;

public class JavaBean {

	public JavaBean(){}
	
	public String javaBeanConstructor(){
		return "Method to construct a JavaBean object";
		//Thread.currentThread().getStackTrace().toString();
	}
	private String field = "PrivateField";
	public String javaBeanGetMethod(){
		return "Method to retrieve a private field of JavaBean such as " + field;
	}
	
	public String javaBeanNamingMethod(String arguement){
		return "This method will name the bean " + arguement;
	}
	
	public String javaBeanEventCall (){
		return "This JavaBean will send a message to " + javaBeanEventResponse("inner call");
	}
	public String javaBeanEventResponse(String event){
		return "This JavaBean will react to " + event;
	}
}
