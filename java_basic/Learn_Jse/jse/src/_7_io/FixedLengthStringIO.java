package _7_io;

import java.io.*;

public class FixedLengthStringIO {

	/** Write fixed number of chars to a DataOutput stream */
	public static void writeFixedLengthString(String s, int size, DataOutput out)
			throws IOException {
		char[] chars = new char[size];

		// str's char -> chars[]
		s.getChars(0, s.length(), chars, 0);

		// blank chars -> chars[] (rest)
		for (int i = Math.min(s.length(), size); i < chars.length; i++)
			chars[i] = ' ';
		//chars[] -> outStream
		out.writeChars(new String(chars));
	}
}
