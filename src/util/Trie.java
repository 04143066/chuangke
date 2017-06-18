package util;
public class Trie {
	public static int bs = 256;
	public static byte [] path = new byte [32];
	
	private int isStr;
	private Trie [] next = new Trie[bs];
	
	public int Insert(String Str)
	{
		Trie temp = this;
		byte [] bt = Str.getBytes();
		for (int i = 0; i < bt.length; i++)
		{
			int index = 0x000000ff & bt[i];
			if (temp.next[index] == null)
			{
				temp.next[index] = new Trie();
				temp = temp.next[index];
				temp.isStr = 0;
				for (int j = 0; j < bs; j++)
				{
					temp.next[j] = null;
				}	
			}
			else
			{
				temp = temp.next[index];
			}
		}
		if (temp.isStr == 1)
			return 0;
		temp.isStr = 1;
		return 1;
	}
	
	public int Search(String Str)
	{
		Trie temp = this;
		byte [] bt = Str.getBytes();
		for (int i = 0; i < bt.length; i++)
		{
			int index = 0x000000ff & bt[i];
			if (temp.next[index] != null)
				temp = temp.next[index];
			else
				return 0;
		}
		return temp.isStr;
	}
	
	public int Delete(String Str)
	{
		Trie temp = this;
		byte [] bt = Str.getBytes();
		for (int i = 0; i < bt.length; i++)
		{
			int index = 0x000000ff & bt[i];
			if (temp.next[index] != null)
				temp = temp.next[index];
			else
				return 0;
		}
		if (temp.isStr == 0)
			return 0;
		temp.isStr = 0;
		return 1;
	}
	
	public int Fuzzys(String Str) throws Exception
	{
		Trie temp = this;
		byte [] bt = Str.getBytes();
		for (int i = 0; i < bt.length; i++)
		{
			int index = 0x000000ff & bt[i];
			if (temp.next[index] != null)
				temp = temp.next[index];
			else
				return 0;
		}
		Trie newr = temp;
		int Count = 0;
		newr.Visits(Str,Count);
		return 0;
	}
	
	public int Visits(String Str, int Count) throws Exception
	{
		if (this.isStr == 1)
		{
			String list = new String(path,0,Count,"UTF-8");
			System.out.printf("%s\n", Str + list);

		}
		for (int i = 0; i < bs; i++)
		{
			if (this.next[i] != null)
			{
				path[Count] = (byte) i;
				this.next[i].Visits(Str, Count+1);
			}
		}
		return 0;
	}
	
	public String Splits(String Str, String sp) throws Exception
	{
		int Count = 0;
		Trie temp = this;
		String Ret = "";
		byte [] bt = Str.getBytes();
		for (int i = 0; i < bt.length; )
		{
			int index = 0x000000ff & bt[i];
			String itob = Integer.toBinaryString(index);
			int n = itob.length() == 7 ? 1 : itob.indexOf("0");
			if (temp.next[index] == null && Count != 0)
			{
				this.Insert(new String(path,0,Count,"UTF-8"));
				Ret += new String(path,0,Count,"UTF-8");
				Ret += sp;	temp = this;	Count = 0;
			}
			for (int j = 0; j < n; i++, j++)
			{
				index = 0x000000ff & bt[i];
				path[Count++] = (byte) index;
				if (temp.next[index] != null)
					temp = temp.next[index];
				else
				{
					temp.next[index] = new Trie();
					temp = temp.next[index];
				}
			}
		}
		this.Insert(new String(path,0,Count,"UTF-8"));
		Ret += new String(path,0,Count,"UTF-8");
		return Ret;
	}
	
	public static void main(String [] args) throws Exception
	{
		Trie root = new Trie();
		for (int i = 0; i < bs; i++)
			root.next[i] = null;
		root.Insert("刘武");
		root.Insert("刘武");
		root.Insert("算法");
		root.Insert("刘珂");
		root.Insert("刘睿阳");
		root.Insert("学习");
		root.Insert("Liuruiyang");
		root.Insert("liurui");
		root.Insert("刘睿");
		String s1 = root.Splits("刘睿阳刘睿刘珂", "→");
		String s2 = root.Splits("刘睿阳刘珂刘武", "→");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(Check.Checking(s1, s2));
		return ;
	}
}