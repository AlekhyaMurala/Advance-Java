import java.util.function.BiFunction;

class Bifunction implements BiFunction<String,String,Boolean>
{
	
	public Boolean apply(String t,String u)
	{
		return t.equals(u);
	}
}
public class Bifunctionaldemo {

	public static void main(String[] args) {
		
		BiFunction<String,String,Boolean> bi=new Bifunction();
		
		System.out.println(bi.apply("sachin","rahul"));
		
		//lamda expression approach
		
		BiFunction<String,String,Boolean> bi1=(t,u) ->
		{
			return t.equals(u);
		};
		System.out.println(bi1.apply("Sathya", "Sathya"));
		
	}

}
