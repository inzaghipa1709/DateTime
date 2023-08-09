import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QLabel, QVBoxLayout, QWidget
from PyQt5.QtCore import QTimer, QDateTime


class DateInfoApp(QMainWindow):
    def __init__(self):
        super().__init__()
        self.init_ui()

    def init_ui(self):
        self.setWindowTitle("Date and Time Information")
        self.setGeometry(100, 100, 400, 200)

        self.result_label = QLabel(self)
        self.time_label = QLabel(self)

        layout = QVBoxLayout()
        layout.addWidget(self.result_label)
        layout.addWidget(self.time_label)

        container = QWidget()
        container.setLayout(layout)
        self.setCentralWidget(container)

        self.timer = QTimer(self)
        self.timer.timeout.connect(self.update_time)
        self.timer.start(1000)  # Update every 1 second

        self.update_time()

    def update_time(self):
        current_datetime = QDateTime.currentDateTime()
        thn = current_datetime.date().year()
        bln = current_datetime.date().month()
        bul = current_datetime.toString("MMMM")
        tgl = current_datetime.date().day()
        har = current_datetime.date().dayOfWeek()
        hari = current_datetime.toString("dddd")
        harke = current_datetime.date().dayOfYear()
        waktu = current_datetime.time().toString("hh:mm:ss")
        jam = current_datetime.time().hour()
        mnt = current_datetime.time().minute()
        dtk = current_datetime.time().second()

        leap = 366 if (thn % 400 == 0) or (thn % 4 == 0 and thn % 100 != 0) else 365
        persen = 100 / leap * (harke - 1 + (jam / 24) + (mnt / 1440) + (dtk / 86400))
        harmun = 1 + leap - harke
        permun = 100 - persen

        if hari == "Sunday":
            har = 7

        result_text = (
            f"Tahun                    : {thn}\n"
            f"Bulan                    : {bln} ({bul})\n"
            f"Tanggal                  : {tgl}\n"
            f"Hari                     : {har} ({hari})\n"
            f"Hari ke (dalam Setahun)  : {harke}\n"
            f"Sisa Hari (Tahun depan)  : {harmun}\n"
            f"Persentase dalam Setahun : {round(persen, 6)}%\n"
            f"Persentase Hitung Mundur : {round(permun, 6)}%\n"
            f"Jam                      : {jam}\n"
            f"Menit                    : {mnt}\n"
            f"Detik                    : {dtk}"
        )
        time_text = (
            f"{hari}, {tgl} {bul} {thn}\nDay-{harke} ({round(persen, 4)}%)\n{waktu}"
        )

        self.result_label.setText(result_text)
        self.time_label.setText(time_text)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = DateInfoApp()
    window.show()
    sys.exit(app.exec_())
