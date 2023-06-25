import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Penanggalan extends JFrame {
    private JLabel yearLabel, monthLabel, dateLabel, dayLabel, hourLabel, minuteLabel, secondLabel;
    private JLabel shortDateLabel, longDateLabel, timeLabel, dayOfYearLabel;

    public Penanggalan() {
        setTitle("Penanggalan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));
        setBounds(20, 50, 300, 200);

        yearLabel = new JLabel("Tahun :");
        monthLabel = new JLabel("Bulan :");
        dateLabel = new JLabel("Tanggal :");
        dayLabel = new JLabel("Hari :");
        hourLabel = new JLabel("Jam :");
        minuteLabel = new JLabel("Menit :");
        secondLabel = new JLabel("Detik :");
        shortDateLabel = new JLabel();
        longDateLabel = new JLabel();
        timeLabel = new JLabel();
        dayOfYearLabel = new JLabel();

        add(yearLabel);
        add(monthLabel);
        add(dateLabel);
        add(dayLabel);
        add(hourLabel);
        add(minuteLabel);
        add(secondLabel);
        add(shortDateLabel);
        add(longDateLabel);
        add(timeLabel);
        add(dayOfYearLabel);

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
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        yearLabel.setText("Tahun: " + year);
        monthLabel.setText("Bulan: " + month + " (" + getMonthName(month) + ")");
        dateLabel.setText("Tanggal: " + date);
        dayLabel.setText("Hari: " + getDayOfWeekName(dayOfWeek));
        hourLabel.setText("Jam: " + hour);
        minuteLabel.setText("Menit: " + minute);
        secondLabel.setText("Detik: " + second);

        SimpleDateFormat shortDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String shortDate = shortDateFormat.format(new Date());
        shortDateLabel.setText(shortDate);

        SimpleDateFormat longDateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String longDate = longDateFormat.format(new Date());
        longDateLabel.setText(longDate);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(new Date());
        timeLabel.setText(time);

        SimpleDateFormat dayOfYearFormat = new SimpleDateFormat("D");
        String dayOfYear = dayOfYearFormat.format(new Date());
        dayOfYearLabel.setText("Day-" + dayOfYear);
    }

    private String getMonthName(int month) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMMM");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month - 1);
        return monthFormat.format(cal.getTime());
    }

    private String getDayOfWeekName(int dayOfWeek) {
        SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        return dayOfWeekFormat.format(cal.getTime());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Penanggalan();
            }
        });
    }
}
