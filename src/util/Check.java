package util;

public class Check {
	public static int Hash(String Str)
	{
		int hash = 0xabcd;
		for (int i = 0; i < Str.toCharArray().length; i++)
		{
			hash ^= Str.toCharArray()[i];
		}
		return hash & 0xffff;
	}
	
	public static int[] Xform(int hash)
	{
		int [] ret = new int[16];
		for (int i = 0; i < 16; i++)
			{ret[i] = (hash%2 == 0 ? -1 : 1);hash /= 2;}
		return ret;
	}
	
	public static int Xform(int[] array)
	{
		int ret = 0;
		for (int i = 0; i < 16; i++)
			{ret *= 2;ret += array[i];}
		return ret;
	}
	
	public static int SimHash(String Str)
	{
		int [] array = new int[16];
		for (int i = 0; i < Str.split("→").length; i++)
		{
			if (Str.split("→")[i].length() > 1)
				for (int j = 0; j < 16; j++)
					array[j] += Check.Xform(Check.Hash(Str.split("→")[i]))[j];
		}
		for (int i = 0; i < 16; i++)
			array[i] = (array[i] > 0 ? 1 : 0);
		return Xform(array);
	}
	
	public static int Hamming(int sim1, int sim2)
	{
		String HamStr = Integer.toBinaryString(sim1 ^ sim2);
		int Ham = 0;
		for (int i = 0; i < HamStr.toCharArray().length; i++)
			if (HamStr.toCharArray()[i] == '1')
				Ham++;
		return Ham;
	}
	
	public static int Checking(String Str1, String Str2)
	{
		return Check.Hamming(Check.SimHash(Str1), Check.SimHash(Str2));
	}
}
