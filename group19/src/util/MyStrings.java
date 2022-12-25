package util;
import java.lang.reflect.Array;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MyStrings {
	
	/**
	 * this method is used to count how many chars equaling ch variable in a string
	 * 
	 * @param str
	 * @param ch
	 * @return
	 */
	public static int countChar(String str, char ch, boolean isIgnoreCase) {
		int count=0;
		
		// Nếu bỏ qua kiểu chữ hoa - thường 
		if(isIgnoreCase) {
			str = str.toLowerCase();
			ch = Character.toLowerCase(ch);
		}
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==ch) {
				count++;
			}
		}
		
		return count;
	}
	
	
	/**
	 * this method is used to format a string to "abc cdf"
	 * @param str
	 * @return
	 */
	public static String formatString (String str) {
		char[] chs = {
			'`','~','!','@','#'	,
			'$', '%','^','&','*',
			'(', ')','-','=','+'	,
			'/', '?','<','>','{',
			'}', '[',']',':',';'	,
			'\\', '"','|','\''	
		};
		
		// loại bỏ kí tự đặc biệt
		for(char ch: chs) {
			str = str.replace(ch, ' ');
		}
		// loại bỏ dấu ' ' thừa
		str = str.trim();
		
		while(str.indexOf("  ")!=-1) {
			str = str.replace("  "," ");
		}
		
		// chuẩn hóa dấu trong câu
		str = str.replace(" . ",". ");
		str = str.replace(" , ", ", ");
		
		
		return str;
	}
	
	public static int countWord(String str) {
				
//		// =str = str.trim().replaceAll(" +", " ");
//		
//		String[] s = str.split(" ");
//		
////		for(int i=0;i<str.length()-1;i++) {
////			if(str.charAt(i)==' ' && str.charAt(i+1)!=' ') {
////				count++;
////			}
////		}
//		
//		return s.length;
		
		str = MyStrings.formatString(str);
		
		return  str=="" ? 0 :  MyStrings.countChar(str, ' ', false)+1;
	}
	
	
	/**
	 * this method is used to count how many similar chars in a string
	 * @param str
	 * @param isIgnoreCase
	 * @return
	 */
	public static ArrayList<String> frequencyChar(String str, boolean isIgnoreCase){
		
		if(isIgnoreCase) {
			str = str.toLowerCase();		
		}
		
		// lấy danh sách các ký tự khác nhau 
		String chs= "";
		String tmp= str.trim();
		
		char ch;
		
		for(int i=0;i<tmp.length();i++) {
			ch = tmp.charAt(i);
			if(ch!=' ') {
				chs+=ch;
				tmp = tmp.replace(ch, ' ');
			}
		}
		
		// đếm số lần xuất hiện 
		ArrayList<String> fres = new ArrayList<>();
		int count;
		for(int i=0;i<chs.length();i++) {
			ch = chs.charAt(i);
			count = MyStrings.countChar(str, ch, isIgnoreCase);
			
			fres.add("["+ch+", "+count+"]");
		}
		return fres;
	
	}
	
	// làm phần chuyển chuỗi tiếng việt thành chuỗi thường
	
	public static String getWords(String str, byte nWords) {
		// chuan hoa
		str = MyStrings.formatString(str);
		
		// cach 1
		String result="";
		int i=0;
		while(MyStrings.countWord(result)!=nWords+1) {
			result += str.charAt(i);
			i++;
		}
		result = str.substring(0, i-2);
		
		// cach 2
//		int i;
//		int count = 0; // dem vi tri dau cach
//		for(i=0;i<str.length();i++)){
//			if(str.charAt(i)==' ') {
//				count++;
//			}
//			if(count>=nWords) {
//				break;
//			}
//		}
//		
//		if(i<str.length()) {
//			return str.substring(0, i);
//		}else {
//			return str;
//		}
				
		// cach 3
		//int i;
//		int count = 0; // dem vi tri dau cach
//		for(i=0;i<str.length();i++)){
//			if(str.charAt(i)==' ' && (++count>=nWords) {
//				break;
//			}
//			
//		}
//		
//		if(i<str.length()) {
//			return str.substring(0, i);
//		}else {
//			return str;
//		}	
		
		return result+"...";
		
	}
	
	// BTVN
	
	/**
	 * This method is used to get how many a word appears in string
	 * @param str
	 * @return
	 */
	public static ArrayList<String> tanSoTu(String str, Boolean isIgnoreCase){
		ArrayList<String> list= new ArrayList<>();
		if(isIgnoreCase)
			str= str.toLowerCase();
		
		str = MyStrings.formatString(str);
		String[] tmp = str.split("\\s");
		Arrays.sort(tmp);

		int count=1;
		for(int i=0;i<tmp.length-1;i++) {
			if(tmp[i].equals(tmp[i+1])) {
				count++;
			}else {
				list.add(tmp[i]+" : "+count);
				count=1;
			}
		}
		list.add(tmp[tmp.length-1]+" : "+count);
		
		return list;
	}
	
	public static String formatUpper(String str) {

		str = MyStrings.formatString(str);
		str = str.toLowerCase();
		
		// cach 1
		StringBuilder stringBuilder = new StringBuilder(str);
		
		char tmp=Character.toUpperCase(str.charAt(0));
		stringBuilder.setCharAt(0, tmp);
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)==' ') {
				tmp=Character.toUpperCase(str.charAt(i+1));
				stringBuilder.setCharAt(i+1, tmp);
			}
		}
		return stringBuilder.toString();
		
		// cach 2
		
		
	}
	
	/**
	 * this method is used to compare 2 strings
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String compareString(String str1, String str2) {
		String result="";
		
		return result;
	}
	
	/**
	 * this method is used to make bold words
	 * @param str
	 * @return
	 */
	public static String boldWords(String str, String inputString) {
		String result = str;
		if(str.contains(inputString)) {
			result=result.replaceAll(inputString, inputString.toUpperCase());
		}
		return result;
	}
	
	/**
	 * this method is used to convert a Vietnamese string to a normal string
	 * @param str
	 * @return
	 */
	public static String convertVietnameseString(String str) {
		String result=Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(result).replaceAll("");
	}
	
	/**
	 * HashMap to count words appearing in a String
	 * @param str
	 * @param ch_split
	 * @return
	 */
	public static HashMap<String, Integer> getStatistic(String str, String ch_split){
		// Lay mang tu - tu chuoi str
		String[] tmp_words = str.split(ch_split);
		
		HashMap<String, Integer> words = new HashMap<>();
		
		// Duyet mang va luu tru + thong ke so luong
		for(String word:tmp_words) {
			if(!"".equalsIgnoreCase(word.trim())){
				word = word.toLowerCase();
				if(words.containsKey(word)) {
					words.replace(word, words.get(word)+1);
				}else {
					words.put(word, 1);
				}
			}
		}
		return words;
	}
	public static void printStatistic(HashMap<String,Integer> words) {
		for(Map.Entry<String, Integer> entry : words.entrySet()) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
	}

	public static void main(String[] args) {

		//String str = "Hello Everybody";
		
		//System.out.println(MyStrings.getWords("Ngo Trieu Vi 2020 2020 Ngo Trieu Vi", (byte) 5));
		
		//System.out.println(frequencyChar("abc bcaaa", false));
		//System.out.println(MyStrings.countWord("  Ngo Trieu   Vi  2020  "));
		//System.out.println("Co tat ca: "+MyStrings.countChar(str, 'e', true));
		
		//System.out.println(MyStrings.tanSoTu("Ngo ngo Ngo", false));

		//System.out.println(MyStrings.formatUpper(" vi  NgO VIIII  "));
		//System.out.println(MyStrings.boldWords("Ngo Trieu Vi 2020 vi Vi Vi vi", "Vi"));
		//System.out.println(MyStrings.convertVietnameseString("Ngô Triệu Vi"));
		
		String sample = "@@adc@@@@brk@@adc@oip@oip@brk@adc@@adc@qwe";
		MyStrings.printStatistic(MyStrings.getStatistic(sample, "@"));
	}

}
