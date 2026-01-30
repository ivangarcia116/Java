package Actividad1;
// Iván García González
// Modificación desde GitHub

public class esPalindromo {
	public static boolean validPalindrome(String s) {
	       for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
	           if (s.charAt(i) != s.charAt(j)) {
	               return false;
	           }
	       }
	       return true;
	   }

	   public static void main(String[] args) {
	       String s1 = "level";
	       String s2 = "cold";
	       String s3 = "Madam";
	       String s4 = "Now, sir, a war is won!";
	       boolean b1 = validPalindrome(s1);
	       boolean b2 = validPalindrome(s2);
	       boolean b3 = validPalindrome(s3);
	       boolean b4 = validPalindrome(s4);
	       System.out.println("is " + s1 + " a palindrome? " + b1);
	       System.out.println("is " + s2 + " a palindrome? " + b2);
	       System.out.println("is " + s3 + " a palindrome? " + b3);
	       System.out.println("is " + s4 + " a palindrome? " + b4);


	   }
}
