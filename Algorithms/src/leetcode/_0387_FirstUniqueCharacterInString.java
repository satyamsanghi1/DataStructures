package leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class _0387_FirstUniqueCharacterInString {
	
	public static void main(String[] args) {
		
		
		//String s="mmestrsbrlktgkorlcnihdfwopqcgwsmehcvhahqlpvakkxmfuprbrehquexugctesjgaxcvhoswemaamknuddvlaoniwvopunbfxhdsgocngkqwxuakptxsogwnktnauabdsibwgivlhciwgrisehtfkuvxrahhmssxsbejamccwvhwbduekibduisfttvdmntsxuouebcbflwaqifrroinnjoirvpnuxfkcheglbmbtmntlrkijiajlijyjgudebqrbdjpdcbbaxtpkgujkatriwkbvwvqelthwitiovbbevanwpkemuovsakjlfbjuuocqfkqcktbhonendvkxfetlbaunljqnwteguxhbipksscvieustdknrifesxvuvxhectkwrbotdbooiiqeiwdtgmaackmvgafdltcmmdavtdkrdarjxfflbgcbfupuwjdqjmqbrhugdhogtuwawsqhswdwsnvahkblmolwinlqjgrdxdacgtvwrekplmobhcanmjecrvntpadcohwnibujgiaexdmiakqejmtfmgqftfvccobddtmpbrewhqvtjdatdqhpjbpqxvpecjadwloicaxubmjfcsqxkvqjapqerhahoimwtxkmrnqxgpjtdssswdxsjgepdejdwdfdjboeoiigwbnxukdtxbuluoktuurqcrkkppvpbjgjkruifjosobgssbdhupjpsluehbvnthmiqigpoqjajrojbvgulvbxojcaqjxxcehmrwvkhxemcsliktubrnijolfosnkexzjeodwmigawhegfgtmoorousbmonhomtwkiwxmkknfpsxxcevxdkpualdarkfvqvdbjqbnodtcgcsvptjvbnqkfxiiwxifhmhpvwdjhubqdgojsnovxpmpuirvgvhwjkqepxdrvoaopatsfjoivrsmumgphmmbxwxxudsvjpfnqxjbpgxnurtjvfhflvvnaqmiorqmcbdurdqfbwcnljieibdasoluepximluxadrehmihsaohkxhiukepcjoldvqxhqqvduwvucigkmneknqdbxatfeomwboewjkxmotopfjtjknmkrvopiidtjdxumlirudmtqiqbvlgqsposvmixmuishmmgmncqcdngcvcqcoggndcdihkanmcevcklsmtudjkpervgvkmmbbkuculdcxiinfrlgsleqxcnwoqdeopqhrlfkumplolpgnkwbojqplwrisufidaupkihsguujbkai";
		String s="loveleetcode";
		firstUniqChar(s);
	}
	 public static int firstUniqChar(String s) {
	   
		 int a[]=new int[26];
		 
		 System.out.println();
		 for(char c:s.toCharArray())
		 {
			 a[c-97]++;
			// System.out.println(c-97);
		 }
		 for(int i:a)
			 System.out.print(i+" ");
		 
		System.out.println();
		 for(char c:s.toCharArray())
		 {
			 if(a[c-97]==1)
			 {
				 System.out.println("ans "+c);
				 break;
			 }
		 }
	
		 return -1;
	    }

}

