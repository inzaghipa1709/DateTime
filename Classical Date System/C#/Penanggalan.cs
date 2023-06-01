using System;

public class Time {
    int Tahun;
    int Bulan;
    int Tanggal;
    int Harke;
    int Jam;
    int Menit;
    int Detik;

    public void DisplayDateAndTime() {
        Console.WriteLine($"Tahun \t\t\t\t\t: {Tahun}");
        Console.Write($"Bulan \t\t\t\t\t: {Bulan} ");
        Console.WriteLine("("+DateTime.Now.ToString("MMMM")+")");
        Console.WriteLine($"Tanggal \t\t\t\t: {Tanggal} ");
        Console.WriteLine($"Hari \t\t\t\t\t: "+DateTime.Now.ToString("dddd"));
        Console.WriteLine($"Hari ke (dalam Setahun) : {Harke} ");
        Console.WriteLine($"Jam \t\t\t\t\t: {Jam}");
        Console.WriteLine($"Menit \t\t\t\t\t: {Menit} ");
        Console.WriteLine($"Detik \t\t\t\t\t: {Detik} ");
    }

    public void DisplayCurrentTime() {
        Console.WriteLine(DateTime.Now.ToString("dddd, dd MMMM yyyy"));
        Console.WriteLine(DateTime.Now.ToString("HH:mm:ss"));
        System.Console.WriteLine("{0}:{1}:{2}", Jam, Menit, Detik);
        Console.WriteLine($"Day-{Harke}");
    }

    public Time(System.DateTime dt) {
        Tahun = dt.Year;
        Bulan = dt.Month;
        Tanggal = dt.Day;
        Jam = dt.Hour;
        Menit = dt.Minute;
        Detik = dt.Second;
        
        Harke = int.Parse(dt.DayOfYear.ToString());
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
