import java.util.function.BiFunction;

class Anagramfunction implements BiFunction<String,String,Boolean>
{

	@Override
	public Boolean apply(String t, String u) 
	{

		return t.equals(u);
	}
	
}
public class Anagrambifunction 
{

	public static void main(String[] args) 
	{
		
		String s1="army";
		String s2="mary";
		
		int l1=s1.length();
		int l2=s2.length();
		
		if(l1==l2)
		{
			System.out.println("Anagram is possible");
			
			char ch1[]=s1.toCharArray();
			char ch2[]=s2.toCharArray();
			
			for(int i=0;i<ch1.length;i++)
			{
				for(int j=i+1;j<ch1.length;j++)
				{
					if(ch1[i]<ch1[j]) 
					{
						char temp=ch1[i];
						ch1[i]=ch2[j];
						ch2[j]=temp;
						
					}
					
					if(ch2[i]<ch2[j])
					{
						char temp=ch2[i];
						ch2[i]=ch2[j];
						ch2[j]=temp;
					}
				}
			}
			
			for(int i=0;i<ch1.length;i++)
			{
				if(ch1[i]!=ch2[i])
				{
					int flag=1;
					break;
				}
			}
			
			int flag = 0;
			if(flag==0)
				System.out.println("Anagram");
			else
				System.out.println("Not an Anagram");
		}
		else
			System.out.println("Anagram is not Possible");
		
		
		
	}

}

