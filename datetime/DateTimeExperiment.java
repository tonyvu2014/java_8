package datetime;
	
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Period;
import java.time.Duration;

public class DateTimeExperiment {

	public static void main(String[] args) {
	
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("Current Date Time is: " + currentDateTime);
	
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current Date is: " + currentDate);
	
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY E HH:mm");
		System.out.println("Formatted Current Date Time: " + currentDateTime.format(dateTimeFormatter));
		System.out.println("Current Year: " + currentDateTime.getYear() + ", Day Of Year: " + currentDateTime.getDayOfYear() + ", Second: " + currentDateTime.getSecond());
		
	    LocalTime noonTime = LocalTime.of(12, 0);
		System.out.println("Noon time: " + noonTime);
		
		LocalDateTime parsedDateTime = LocalDateTime.parse("2016-12-31T10:09:20");
		System.out.println("Parsed Date Time: " + parsedDateTime);
		
		LocalDate nextBirthday = LocalDate.of(currentDate.getYear()+1, Month.APRIL, 14);
	    System.out.println("Next birthday: " + nextBirthday);
		
		Duration duration = Duration.between(parsedDateTime, currentDateTime);
		System.out.println("Duration: " + duration);
		
		Period tillNextBirthday = Period.between(currentDate, nextBirthday);
		System.out.println("Time till next year's birthday: " + tillNextBirthday.getYears() + " years, " + tillNextBirthday.getMonths() + " months, " + tillNextBirthday.getDays() + " days");
		
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("Current Zone: " + currentZone);
		
		ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
		System.out.println("Current Zoned Date Time: " + currentZonedDateTime);
		
		ZonedDateTime utcDateTime = currentZonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
		System.out.println("Current UTC Date Time: " + utcDateTime);
	
	   
	}
}