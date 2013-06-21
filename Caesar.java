public class Caesar 
{
	char[] char_set = {'A','B','C','D','E','F','G','H','I','J',
			'K','L','M','N','O','P','Q','R','S','T','U',
			'V','W','X','Y','Z','0','1','2','3','4','5',
			'6','7','8','9'}; 
	
	int char_shift;
	
	public Caesar(int x)
	{
		char_shift = x;
	}
	
	public void setShift(int x)
	{
		char_shift = x;
	}

	public String encrypt(String message)
	{
		String cypher_text = "";
	
		// Prepare the message for encryption
		message = message.toUpperCase();
		message = cleanString(message);

		char[] msg_array = message.toCharArray();

		for(int i=0; i < msg_array.length;i++)
		{
			int shift_index = (getCharSetIndex(msg_array[i]) + char_shift)%char_set.length;
			cypher_text = cypher_text + char_set[shift_index];
		}

		return cypher_text;
	}

	public String decrypt(String cypher_text)
	{
		String message = null;

		return message;
	}
	
	protected String cleanString(String msg)
	{
		char[] msg_array = msg.toCharArray();
		String output = "";

		for(int i=0; i < msg_array.length; i++)
		{
			if(contains(char_set, msg_array[i]))
			{
				output = output + msg_array[i];
			}
		}
		
		return output;
	}

	protected boolean contains(final char[] array, final char key)
	{
		boolean result = false;		

		for(final char c: array)
		{
			if(c == key) 
			{
				result = true;
			}
		}
		
		return result;
	}

	protected int getCharSetIndex(char find)
	{
		int index = 0;
		boolean done = false;

		while(index < char_set.length && !done)
		{
			if(find == char_set[index])
			{
				done = true;
			}
			else
			{
				index++;
			}
		}
		return index;
	}
	
	public static void main(String args[])
	{
		String message = "this is a test";		

		Caesar c = new Caesar(5);	
		System.out.println(c.encrypt(message));
	}
}