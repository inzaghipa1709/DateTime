import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Penanggalan extends JFrame {
    private JLabel yearLabel, monthLabel, dateLabel, dayLabel, dayOfYearLabel, daysLeftLabel;
    private JLabel percentageLabel, reversePercentageLabel, hourLabel, minuteLabel, secondLabel;
    private JLabel longDateLabel, shortDateLabel, dayOfYearPercentLabel, timeLabel;

    public Penanggalan() {
        setTitle("Penanggalan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));
        setBounds(20, 50, 500, 300);

        yearLabel = new JLabel("Tahun:");
        monthLabel = new JLabel("Bulan:");
        dateLabel = new JLabel("Tanggal:");
        dayLabel = new JLabel("Hari:");
        dayOfYearLabel = new JLabel("Hari ke (dalam Setahun):");
        daysLeftLabel = new JLabel("Sisa Hari (Tahun depan):");
        percentageLabel = new JLabel("Persentase dalam Setahun:");
        reversePercentageLabel = new JLabel("Persentase Hitung Mundur:");
        hourLabel = new JLabel("Jam:");
        minuteLabel = new JLabel("Menit:");
        secondLabel = new JLabel("Detik:");
        longDateLabel = new JLabel();
        shortDateLabel = new JLabel();
        dayOfYearPercentLabel = new JLabel();
        timeLabel = new JLabel();

        add(yearLabel);
        add(monthLabel);
        add(dateLabel);
        add(dayLabel);
        add(dayOfYearLabel);
        add(daysLeftLabel);
        add(percentageLabel);
        add(reversePercentageLabel);
        add(hourLabel);
        add(minuteLabel);
        add(secondLabel);
        add(longDateLabel);
        add(shortDateLabel);
        add(dayOfYearPercentLabel);
        add(timeLabel);

        updateDateTime(); // Initial update

        Timer timer = new Timer(1000, e -> {
            updateDateTime(); // Update every second
        });
        timer.start();

        setVisible(true);
    }

    private void updateDateTime() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);

        double hour = cal.get(Calendar.HOUR_OF_DAY);
        double minute = cal.get(Calendar.MINUTE);
        double second = cal.get(Calendar.SECOND);

        yearLabel.setText("Tahun: " + year);
        monthLabel.setText("Bulan: " + month + " (" + getMonthName(month) + ")");
        dateLabel.setText("Tanggal: " + date);
        dayLabel.setText("Hari: " + getDayOfWeekName(dayOfWeek));
        dayOfYearLabel.setText("Hari ke (dalam Setahun): " + dayOfYear);

        int daysLeft = getDaysLeft(year, dayOfYear);
        daysLeftLabel.setText("Sisa Hari (Tahun depan): " + daysLeft);

        hourLabel.setText("Jam: " + (int)hour);
        minuteLabel.setText("Menit: " + (int)minute);
        secondLabel.setText("Detik: " + (int)second);

        double percentOfYear = (dayOfYear - 1) + (hour / 24) + (minute / 1440) + (second / 86400);
        double percentage = (percentOfYear / 365) * 100;
        double reversePercentage = 100 - percentage;

        DecimalFormat df = new DecimalFormat("#.######");
        percentageLabel.setText("Persentase dalam Setahun: " + df.format(percentage) + "%");
        reversePercentageLabel.setText("Persentase Hitung Mundur: " + df.format(reversePercentage) + "%");

        SimpleDateFormat longDateFormat = new SimpleDateFormat("EEEE, dd MMMMM yyyy");
        SimpleDateFormat shortDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        longDateLabel.setText(longDateFormat.format(new Date()));
        shortDateLabel.setText(shortDateFormat.format(new Date()));
        dayOfYearPercentLabel.setText("Day-" + dayOfYear + " (" + df.format(percentage) + "%)");
        timeLabel.setText(timeFormat.format(new Date()));
    }

    private String getMonthName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    private String getDayOfWeekName(int dayOfWeek) {
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return dayNames[dayOfWeek - 1];
    }

    private int getDaysLeft(int year, int dayOfYear) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year + 1);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        int daysInYear = cal.get(Calendar.DAY_OF_YEAR);
        return daysInYear - dayOfYear;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Penanggalan();
        });
    }
}