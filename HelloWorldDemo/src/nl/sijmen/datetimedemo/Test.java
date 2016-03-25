package nl.sijmen.datetimedemo;

import java.security.InvalidParameterException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		// NachtenTotVerjaardag.run();
		// MaartKalender.run();
		//BabyLeeftijd.run();
		KalenderMaand.run();
	}

}

class NachtenTotVerjaardag {
	static void run() {
		Scanner sc = new Scanner(System.in);

		int day = 0, month = 0;
		try {
			System.out.print("Wanneer ben je jarig?\nDag: ");
			day = Integer.valueOf(sc.next());
			System.out.print("Maand: ");
			month = Integer.valueOf(sc.next());
		} catch (InvalidParameterException e) {
			System.out.println("Not a number...");
			sc.close();
			return;
		}

		LocalDate now = LocalDate.now();
		LocalDate verjaardag = LocalDate.of(now.getYear(), month, day);

		if (verjaardag.isBefore(now)) {
			verjaardag = verjaardag.plusYears(1);
		}

		long p2 = ChronoUnit.DAYS.between(now, verjaardag);
		System.out.println("Nog  " + p2 + "  " + (p2 == 1L ? "nachtje" : "nachtjes") + " slapen!");

		sc.close();
	}
}

class MaartKalender {
	static void run() {
		LocalDate today = LocalDate.now();
		LocalDate april = LocalDate.of(1976, Month.APRIL, 1);
		LocalDate may = LocalDate.of(1976, Month.MAY, 1);

		System.out.println(toMaartTime(today));
		System.out.println(toMaartTime(april));
		System.out.println(toMaartTime(may));

		System.out.println("   1: " + toNormalTime(1));
		System.out.println("  32: " + toNormalTime(32));
		System.out.println("  62: " + toNormalTime(62));
		System.out.println("1000: " + toNormalTime(1000));
	}

	static String toMaartTime(LocalDate normalDate) {
		LocalDate maart = LocalDate.of(1976, Month.MARCH, 1);
		if (normalDate.isBefore(maart)) {
			throw new IllegalArgumentException("Date moet vanaf 1 maart 1976 zijn.");
		}

		long d = 1 + ChronoUnit.DAYS.between(maart, normalDate);

		return d + " maart 1976";
	}

	static LocalDate toNormalTime(int day) {
		return LocalDate.of(1976, Month.MARCH, 1).plusDays(day - 1);
	}
}

class BabyLeeftijd {
	static void run() {
		Scanner sc = new Scanner(System.in);

		LocalDate gebDatum;
		int day = 0, month = 0, year = 0;
		try {
			System.out.print("Geef de geboortedam?\nDag: ");
			day = Integer.valueOf(sc.next());
			System.out.print("Maand: ");
			month = Integer.valueOf(sc.next());
			System.out.print("Jaar: ");
			year = Integer.valueOf(sc.next());
			gebDatum = LocalDate.of(year, month, day);
		} catch (InvalidParameterException e) {
			System.out.println("Not a number...");
			sc.close();
			return;
		} catch (DateTimeException e) {
			System.out.println("Minimaal 1 van de 3 getallen zijn ongeldig voor een datum.");
			sc.close();
			return;
		}

		System.out.println(toLeeftijd(gebDatum));

		gebDatum = LocalDate.of(2016, Month.MARCH, 15);
		System.out.println(toLeeftijd(gebDatum));
		gebDatum = LocalDate.of(2016, Month.FEBRUARY, 15);
		System.out.println(toLeeftijd(gebDatum));
		gebDatum = LocalDate.of(2016, Month.JANUARY, 15);
		System.out.println(toLeeftijd(gebDatum));
		gebDatum = LocalDate.of(2015, Month.FEBRUARY, 15);
		System.out.println(toLeeftijd(gebDatum));
		gebDatum = LocalDate.of(2013, Month.FEBRUARY, 15);
		System.out.println(toLeeftijd(gebDatum));
		gebDatum = LocalDate.of(2006, Month.FEBRUARY, 15);
		System.out.println(toLeeftijd(gebDatum));
		gebDatum = LocalDate.of(1999, Month.FEBRUARY, 15);
		System.out.println(toLeeftijd(gebDatum));
		gebDatum = LocalDate.of(1990, Month.FEBRUARY, 15);
		System.out.println(toLeeftijd(gebDatum));

		sc.close();
	}

	static String toLeeftijd(LocalDate birth) {
		LocalDate now = LocalDate.now();

		if (birth.isAfter(now.minusMonths(1))) {
			return "Uw baby is " + ChronoUnit.DAYS.between(birth, now) + " dagen oud";
		}
		if (birth.isAfter(now.minusMonths(3))) {
			return "Uw baby is " + ChronoUnit.WEEKS.between(birth, now) + " weken oud";
		}
		if (birth.isAfter(now.minusYears(2))) {
			return "Uw dreumes is " + ChronoUnit.MONTHS.between(birth, now) + " maanden oud";
		}
		if (birth.isAfter(now.minusYears(4))) {
			Period p = Period.between(birth, now);
			return "Uw peuter is " + p.getYears() + " jaar en " + p.getMonths() + " maanden oud";
		}
		if (birth.isAfter(now.minusYears(12))) {
			Period p = Period.between(birth, now).normalized();
			boolean half = (p.getMonths() >= 6);
			return "Uw kind is " + p.getYears() + (half ? "en een half " : "") + " jaar en oud";
		}
		if (birth.isAfter(now.minusYears(18))) {
			Period p = Period.between(birth, now).normalized();
			return "Tiener:  " + p.getYears() + " jaar";
		}
		Period p = Period.between(birth, now).normalized();
		return "Volwassen: " + p.getYears() + " jaar";
	}
}

class KalenderMaand {

	static void run() {
		int month = 1;
		int year = 2016;
		
		System.out.println(buildString(month,year));
	}

	static String buildString(int month, int year) {
		StringBuilder sb = new StringBuilder();
		
		LocalDate firstDay = LocalDate.of(year, month, 1);

		String strMonth = firstDay.getMonth().toString().toLowerCase();
		sb.append( strMonth.substring(0, 1).toUpperCase() + strMonth.substring(1) + " " + firstDay.getYear());
		
		sb.append("\n Mo Tu We Th Fr Sa Su\n");
		
		DayOfWeek dow = firstDay.getDayOfWeek(); // 1 monday to 7 sunday
			
		int count = 1;
		for (int i = 1; i < dow.getValue(); i++, count++) {
			sb.append("   ");
		}
		
		while (firstDay.getMonthValue() == month) {
			sb.append(String.format("%3d", firstDay.getDayOfMonth()));
			if (count % 7 == 0) {
				sb.append("\n");
			}
			count++;
			firstDay = firstDay.plusDays(1);
		}

		return sb.toString();
	}
}
