import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QLabel, QVBoxLayout, QWidget
from PyQt5.QtCore import QTimer, QTime, Qt, QDate


class Penanggalan(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Penanggalan")
        self.setGeometry(20, 50, 320, 200)
        self.setFixedSize(320, 200)  # To make it non-resizable

        central_widget = QWidget()
        self.setCentralWidget(central_widget)

        layout = QVBoxLayout(central_widget)

        self.labels = []

        self.add_label("Tahun : ")
        self.add_label("Bulan : ")
        self.add_label("Tanggal : ")
        self.add_label("Hari : ")
        self.add_label("Hari ke (dalam Setahun) : ")
        self.add_label("Jam : ")
        self.add_label("Menit : ")
        self.add_label("Detik : ")

        self.update_labels()

        self.timer = QTimer(self)
        self.timer.timeout.connect(self.update_labels)
        self.timer.start(1000)

    def add_label(self, text):
        label = QLabel(text)
        self.labels.append(label)
        layout = self.centralWidget().layout()
        layout.addWidget(label, alignment=Qt.AlignLeft)

    def update_labels(self):
        current_time = QTime.currentTime()
        current_date = QDate.currentDate()

        year = str(current_date.year())
        month = str(current_date.month())
        month_name = current_date.toString("MMMM")
        day = str(current_date.day())
        day_name = current_date.toString("dddd")
        day_of_year = str(current_date.dayOfYear())
        hour = str(current_time.hour())
        minute = str(current_time.minute())
        second = str(current_time.second())

        self.labels[0].setText("Tahun : " + year)
        self.labels[1].setText("Bulan : " + month + " (" + month_name + ")")
        self.labels[2].setText("Tanggal : " + day)
        self.labels[3].setText("Hari : " + day_name)
        self.labels[4].setText("Hari ke (dalam Setahun) : " + day_of_year)
        self.labels[5].setText("Jam : " + hour)
        self.labels[6].setText("Menit : " + minute)
        self.labels[7].setText("Detik : " + second)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    penanggalan = Penanggalan()
    penanggalan.show()
    sys.exit(app.exec_())
