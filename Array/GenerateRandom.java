package Array;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandom
{
	public int generateNum(int[] intList, int min, int max)
	{
		Arrays.sort(intList);
		int range = max - min + 1;
		Random rand = new Random();
		int result = rand.nextInt(range) + min;
		while (Arrays.binarySearch(intList, result) >= 0)
		{
			result = rand.nextInt(range) + min;
		}
		return result;
	}
}
