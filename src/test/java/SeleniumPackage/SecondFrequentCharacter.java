package SeleniumPackage;

public class SecondFrequentCharacter {
	
	static final int NO_OF_CHARS = 256;
	public static void main(String[] args)
	{
	  //String to find second frequent character
	  String str = "llakshmii";
	  //DettveeeLabsAlliance
	  char res = getSecondMostFreq(str);
	  if (res != '\0')
	  System.out.println("Second most frequent char is " + res);
	  else
	  System.out.println("No second most frequent character");
	}
	static char getSecondMostFreq(String str)
	{
	  //count number of occurences of every character
	  int[] count = new int[NO_OF_CHARS];
	  int i;
	  for (i=0; i< str.length(); i++)
	  (count[str.charAt(i)])++;
	  // Traverse through the count[] and find second highest element.
	  int first = 0, second = 0;
	  for (i = 0; i < NO_OF_CHARS; i++)
	  {
	    /* If current element is smaller than
	    first then update both first and second */
	    if (count[i] > count[first])
	    {
	       second = first;
	       first = i;
	    }
	    /* If count[i] is in between first and
	    second then update second  */
	    else if (count[i] > count[second] &&
	    count[i] != count[first])
	    second = i;
	   }
	   return (char)second;
	   }

}
