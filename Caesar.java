public class Caesar 
{
	char[] char_set = {'A','B','C','D','E','F','G','H','I','J',
			'K','L','M','N','O','P','Q','R','S','T','U',
			'V','W','X','Y','Z'}; 
	
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
		//message = cleanString(message);

		char[] msg_array = message.toCharArray();

		for(int i=0; i < msg_array.length;i++)
		{
			if(contains(char_set,msg_array[i]))
			{
				int shift_index = (getCharSetIndex(msg_array[i]) + char_shift)%char_set.length;
				cypher_text = cypher_text + char_set[shift_index];
			}
			else
			{
				cypher_text = cypher_text + msg_array[i];
			}
		}

		return cypher_text;
	}

	public String decrypt(String cypher_text)
	{
		cypher_text = cypher_text.toUpperCase();
		String message = "";
		char[] ct_array = cypher_text.toCharArray();
		
		for(int i = 0; i < ct_array.length;i++)
		{
			if(contains(char_set,ct_array[i]))
			{
				int shift_index = (getCharSetIndex(ct_array[i]) - char_shift);
				if(shift_index < 0) shift_index = shift_index + char_set.length;
				message = message + char_set[shift_index];
			}
			else
			{
				message = message + ct_array[i];
			}
		}

		message = message.toLowerCase();
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
		if(args.length == 3)
		{
			Caesar c  = new Caesar(Integer.parseInt(args[1]));
			
			if(args[0].equals("-e"))
			{
				System.out.println(c.encrypt(args[2]));
			}
			else if(args[0].equals("-d"))
			{
				System.out.println(c.decrypt(args[2]));
			}
			else
			{
				System.out.println("Test");
				System.out.println("Usage: java -jar Caesar.jar -e|-d shift message");
			}
		}
		else
		{
			System.out.println("Usage: java -jar Caesar.jar -e|-d shift message");
		}
	}
}
