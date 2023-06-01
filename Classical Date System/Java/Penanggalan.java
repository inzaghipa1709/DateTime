import java.util.*;
import java.text.*;

public class Penanggalan {
    public static void main(String[] args){
        int Leap, Tahun, Bulan, Tanggal;
        int Harmun;
        int Jam, Menit, Detik;
        float Persen, DateCal;

        Date month = new Date();
        SimpleDateFormat mn = new SimpleDateFormat("MMMMM");
        Date day = new Date();
        SimpleDateFormat dy = new SimpleDateFormat("EEEEE");

        Calendar cal = Calendar.getInstance();

        Tahun = cal.get(Calendar.YEAR);
        Bulan = cal.get(Calendar.MONTH)+1;
        Tanggal = cal.get(Calendar.DATE);
        Jam = cal.get(Calendar.HOUR);
        Menit = cal.get(Calendar.MINUTE);
        Detik = cal.get(Calendar.SECOND);

        System.out.println("Tahun   : " + Tahun);
        System.out.println("Bulan   : " + Bulan+" ("+mn.format(month)+")");
        System.out.println("Tanggal : " + Tanggal);
        System.out.println("Hari    : " + dy.format(day));
        System.out.println("Jam     : " + Jam);
        System.out.println("Menit   : " + Menit);
        System.out.println("Detik   : " + Detik);
        System.out.println();
        
        String shortPattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(shortPattern);
        String shortDate = simpleDateFormat.format(new Date());
        System.out.println(shortDate);
        
        String longPattern = "EEEEE, dd MMMMM yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(longPattern);
        String longDate = dateFormat.format(new Date());
        System.out.println(longDate);
        
        String pattern = "HH:mm:ss";
        SimpleDateFormat timeFormat = new SimpleDateFormat(pattern);
        String time = timeFormat.format(new Date());
        System.out.println(time);

        //Date harke = new Date();
        //String format = dateFormat.format(harke);
        //System.out.printf("Day-%Tj\n", harke, harke);

        String dayYear = "D";
        SimpleDateFormat dayinayear = new SimpleDateFormat(dayYear);
        String harke = dayinayear.format(new Date());
        System.out.println("Day-"+harke);
    }
}
