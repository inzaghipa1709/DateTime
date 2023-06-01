using System;

public class Time {
    int Leap;
    int Tahun;
    int Bulan;
    int Tanggal;
    int Harke;
    int Harmun;
    double Jam;
    double Menit;
    double Detik;
    double Persen;
    double Permun;
    double DateCal;

    public void DisplayDateAndTime() {
        Console.WriteLine($"Tahun                    : {Tahun}");
        Console.WriteLine($"Bulan                    : {Bulan} ("+DateTime.Now.ToString("MMMM")+")");
        Console.WriteLine($"Tanggal                  : {Tanggal}");
        Console.WriteLine($"Hari                     : "+DateTime.Now.ToString("dddd"));
        Console.WriteLine($"Hari ke (dalam Setahun)  : {Harke}");
        Console.WriteLine($"Sisa Hari (Tahun depan)  : {Harmun}");
        Console.WriteLine($"Persentase dalam Setahun : "+Math.Round(Persen, 6)+"%");
        Console.WriteLine($"Persentase Hitung Mundur : "+Math.Round(Permun, 6)+"%");
        Console.WriteLine($"Jam                      : {Jam}");
        Console.WriteLine($"Menit                    : {Menit}");
        Console.WriteLine($"Detik                    : {Detik}");
    }

    public void DisplayCurrentTime() {
        Console.WriteLine(DateTime.Now.ToString("dddd, dd MMMM yyyy"));
        Console.WriteLine(DateTime.Now.ToString("HH:mm:ss"));
        System.Console.WriteLine("{0}:{1}:{2}", Jam, Menit, Detik);
        Console.WriteLine($"Day-{Harke} ("+Math.Round(Persen, 4)+"%)");
    }

    public Time(System.DateTime dt) {
        Tahun = dt.Year;
        Bulan = dt.Month;
        Tanggal = dt.Day;
        Jam = dt.Hour;
        Menit = dt.Minute;
        Detik = dt.Second;
        
        if (Tahun % 400 == 0){
          Leap = 366;
        }
        else if (Tahun % 100 == 0){
          Leap = 365;
        }
        else if (Tahun % 4 == 0){
          Leap = 366;
        }
        else {
          Leap = 365;
        }
        
        Harke = int.Parse(dt.DayOfYear.ToString());
        Harmun = 1+Leap-Harke;
        
        DateCal = (Harke-1)+(Jam/24)+(Menit/1440)+(Detik/86400);
        Persen = (double)(100*DateCal/Leap);
        Permun = 100-Persen;
    }
}

public class Penanggalan {
    static void Main(string[] args) {
        System.DateTime currentTime = System.DateTime.Now;
        Time waktu = new Time(currentTime);
        waktu.DisplayDateAndTime();
        Console.WriteLine("");
        waktu.DisplayCurrentTime();
    }
}