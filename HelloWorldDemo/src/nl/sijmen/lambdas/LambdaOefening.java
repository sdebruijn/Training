package nl.sijmen.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaOefening {


	/**
	 * Deze functie hoef je niet te begrijpen!
	 * @param data  een ArrayList van een willekeurig type 
	 * @param p     een lambda-expressie die een parameter van datzelfde type neemt en een boolean teruggeeft
	 * @return		een nieuwe List terug waarin alleen de data zit waarvoor je predicaat true is.
	 */
	public static <T> List<T> filter(ArrayList<T> data, Predicate<T> p){
		return data.stream().filter(p).collect(Collectors.toList());
	}

	
	/**
	 * Deze functie hoef je niet te begrijpen!
	 * @param data  een ArrayList van een willekeurig type
	 * @param p     een lambda-expressie die een parameter van datzelfde type neemt en ook zo'n type teruggeeft
	 * @return		we voeren de lamba uit voor ieder element van data en geven het resultaat terug 
	 */
	public static <T,U> List<U> map(ArrayList<T> data, Function<T, U> f){
		return data.stream().map(f).collect(Collectors.toList());
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> arrInt = new ArrayList<>();
		for(int x = 0; x < 100; ++x){
			arrInt.add(x);
		}
		ArrayList<String> list = new ArrayList<String>();
		list.add("one"); list.add("two");list.add("three");list.add("four");list.add("five");
		list.add("six");list.add("seven");list.add("eight");list.add("nine");
		list.add("ten");list.add("eleven");list.add("twelve");list.add("thirteen");
		list.add("fourteen");list.add("fifteen");list.add("sixteen");
		list.add("seventeen");list.add("eighteen");list.add("nineteen");list.add("twenty");
		
		ArrayList<String> fileList = new ArrayList<String>();
		fileList.add("one.java"); fileList.add("two.class");fileList.add("three.txt");fileList.add("four.java");fileList.add("five.java");
		
		
		System.out.println("Veelvouden van 3 of 5");
		System.out.println(filter(arrInt, i -> ((i%3)==0||(i%5)==0) ) );
		
		
		System.out.println("\nStrings lengte 5");
		System.out.println(filter(list,  i ->  i.length() == 5) );
		
		System.out.println("\nStrings .java");
		System.out.println(filter(fileList, i -> i.endsWith(".java") ) );
		
		System.out.println("\nwortel");
		System.out.println(map(arrInt, i -> Math.sqrt(i) ) );
		
		System.out.println("\nreverse strings");
		System.out.println(map(fileList, 
				i -> (new StringBuilder(i)).reverse().toString() 
				));
		
		
		
	}

}
