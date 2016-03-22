package nl.sijmen.training;

class AantalBytes{
	
	public static void main (String[] args) {
		long l = 12L;
		int i = 12;
		short sh = 12;
		byte b = 1;
		char c = 'c';
		double d = 12.34;
		float f = 12.45F;
		boolean bool = true;
		
		String str = "blablaba";
		
		
		System.out.println("Aantal bytes of boolean is " + aantalbytes(bool) );
		System.out.println("Aantal bytes of float is   " + aantalbytes(f) );
		System.out.println("Aantal bytes of double is  " + aantalbytes(d) );
		System.out.println("Aantal bytes of byte is    " + aantalbytes(b) );
		System.out.println("Aantal bytes of short is   " + aantalbytes(sh) );
		System.out.println("Aantal bytes of int is     " + aantalbytes(i) );
		System.out.println("Aantal bytes of long is    " + aantalbytes(l) );
		System.out.println("Aantal bytes of char is    " + aantalbytes(c) );
		try {
			System.out.println("Aantal bytes of string is " + aantalbytes(str) );
		} catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Char past in Long: " + pastin(c,l) );	
		System.out.println("Long past in Char: " + pastin(l,c) );	
		System.out.println("Int past in Float: " + pastin(i,f) );	
		System.out.println("Long past in Double: " + pastin(l,d) );	
	}

	public static int aantalbytes(boolean a) { return aantalbytesHelper((Object)a); }
	public static int aantalbytes(byte a)    { return aantalbytesHelper((Object)a); }
	public static int aantalbytes(short a)   { return aantalbytesHelper((Object)a); }
	public static int aantalbytes(int a)     { return aantalbytesHelper((Object)a); }
	public static int aantalbytes(long a)    { return aantalbytesHelper((Object)a); }
	public static int aantalbytes(float a)   { return aantalbytesHelper((Object)a); }
	public static int aantalbytes(double a)  { return aantalbytesHelper((Object)a); }
	public static int aantalbytes(char a)    { return aantalbytesHelper((Object)a); }
	public static int aantalbytes(Object a)  { 
		throw new IllegalArgumentException("aantalbytes() does not accept an object type."); 
	}
	
	private static int aantalbytesHelper(Object obj) {
		String str = obj.getClass().getName();
		switch ( str ) {
			case "java.lang.Boolean":
			case "java.lang.Byte":
				return 1;
			case "java.lang.Short":
			case "java.lang.Character":
				return 2;
			case "java.lang.Integer":
			case "java.lang.Float":
				return 4;
			case "java.lang.Double":
			case "java.lang.Long":
				return 8;
			default:
				throw new IllegalArgumentException("aantalbytes() does not accept an object type.");
		}
	}
	
	public static boolean pastin(Object a, Object b)
	{
		if (aantalbytesHelper(a) > aantalbytesHelper(b) ) { 
			return false;
		} else { 
			return true;
		}
	}

}