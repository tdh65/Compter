import java.time.DayOfWeek;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestTemps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime currentTime = LocalDateTime.now(); 
		affiche("Date et heure courante : " + currentTime);
		
		LocalDate date1 = currentTime.toLocalDate(); 
		affiche("Date courante : " + date1) ;
		
		Month mois = date1.getMonth() ; 
		int jour = currentTime.getDayOfMonth() ;
		int heure = currentTime.getHour(); 
		affiche ("mois : " + mois + " jour : " + jour + " heure : " + heure );
		affiche("Avoir le 25 decembre 2023");
		LocalDateTime date2 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
		affiche("Date modifiee " + date2) ;
		affiche("Une autre facon LocaldateTime.of(..)");
		LocalDateTime date3 = LocalDateTime.of(2023, Month.DECEMBER, 25, 0, 0) ;
		affiche("date 3 : " + date3 );
		affiche("On peut même parser une date depuis un String " ) ;
	    LocalTime parsed = LocalTime.parse("20:15:30");
	    affiche("date parsee " + parsed ) ;
	    LocalDate ldd = LocalDate.parse("1156-03-15" ) ;
	    affiche("Parse date toepochday : " + ldd.toEpochDay() ) ;
		affiche("DateTimeManipulation ");
		LocalDateTime ldt = LocalDateTime.of(2018,  Month.DECEMBER, 25 , 13 ,37,06) ;
		affiche ("Date de reference : " + ldt );
		affiche ("Utilisation de l'objet ChronoUnit pour changer l'objet : ");
		affiche("+1 semaine " + ldt.plus(1 , ChronoUnit.WEEKS)) ;
		affiche("+2 mois " + ldt.plus(2 , ChronoUnit.MONTHS)) ;
		affiche("+3 ans " + ldt.plus(3 , ChronoUnit.YEARS)) ;
		affiche("+4 heures " + ldt.plus(4 , ChronoUnit.HOURS)) ;
		affiche("-5 secondes " + ldt.minus(-5 , ChronoUnit.SECONDS)) ;
		affiche("-38 minute " + ldt.minusMinutes(38)) ;
		
		affiche("Period et Duration test") ;
		LocalDateTime ldt2 = ldt.plus(3, ChronoUnit.YEARS); 
		LocalDateTime ldt3 = ldt.minusMinutes(1337) ;
		 
		
		Period p = Period.between(ldt.toLocalDate(), ldt2.toLocalDate()) ;
		Duration d = Duration.between(ldt.toLocalTime(), ldt3.toLocalTime());
		affiche("Periiode p : "  + p );
		affiche("Duree d " + d.getSeconds() );
		affiche("Ecart en jours : " + ChronoUnit.DAYS.between(ldt, ldt2));
		affiche("Temporal adjuster : classe pratique pour calculer sur les dates"); 
		LocalDate ldd0 = LocalDate.of(2018, Month.APRIL, 28);
		
		affiche ("le prochain samedi ");
		affiche((ldd0.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).toString()));
		affiche ("le 3 mardi du mois suivant ");
		LocalDate ldd2 = ldd0.plusMonths(1);
		LocalDate troisiemeMardi = ldd2.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
				.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
				.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		affiche("troisemen mardi " + troisiemeMardi ) ;
		
		affiche("ZoneId et ZoneDateTime");
		Map<String, String > maps = ZoneId.SHORT_IDS ;
		maps.values().stream().forEach(
				(x)-> {System.out.println(x + " ... " + ZoneId.of(x).getRules());}
				);
		affiche("\nConnaitre son fuseau horaire\n" + ZoneId.systemDefault()) ;
		affiche("Regle a appliquer au heures " + ZoneId.systemDefault().getRules() ) ;
		affiche("code qui parse une date heure et donne sa valeur en fonction d un fuseau horaire");
		LocalDateTime ldt5 = LocalDateTime.parse("2018-01-01T01:33:30") ;
		List<ZoneId> lzi = Arrays.asList(ZoneId.of("Europe/Paris" ),
				ZoneId.of("Asia/Tokyo") ,
				ZoneId.of("America/Anchorage")
				);
		lzi.stream().forEach((x) ->{System.out.println(x + ": \t" + ldt5.atZone(x).toInstant());} 
				
				); 

	}
	public static  void affiche(String data) {
		System.out.println(data);
	}

}
