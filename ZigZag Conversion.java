public String convert(String s, int numRows) {
	if(numRows <= 1)	return s;
	StringBuilder[] sb = new StringBuilder[numRows];
	for(int i = 0; i < sb.length; ++i){
		sb[i] = new StringBuilder("");
	}
	int flag = 1;		// set flag to increament or decrement 
	int index = 0;
	for(int i = 0; i < s.length(); ++i){
		sb[index].append(s.charAt(i));
		// increament from head to tail
		if(index == 0)	flag = 1;
		// decrement from tail to head 
		if(index == numRows - 1)	flag = -1;
		index += flag;
	}
	String result = "";
	for(int i = 0; i < numRows; ++i){
		result += sb[i];
	}
	return result.toString();
}