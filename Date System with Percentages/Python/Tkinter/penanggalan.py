import tkinter as tk
from datetime import datetime

class DateInfoApp:
    def __init__(self, root):
        self.root = root
        self.root.title('Penanggalan')
        self.root.geometry('350x280')  # Set window size
        
        self.result_label = tk.Label(root, justify='left')
        self.time_label = tk.Label(root, justify='left')
        
        self.result_label.pack(pady=10, padx=10, anchor='w')  # Align left
        self.time_label.pack(padx=10, anchor='w')  # Align left
        
        self.update_time()
        
    def update_time(self):
        current_datetime = datetime.now()
        thn = current_datetime.year
        bln = current_datetime.month
        bul = current_datetime.strftime('%B')
        tgl = current_datetime.day
        har = current_datetime.strftime('%w')
        hari = current_datetime.strftime('%A')
        harke = current_datetime.strftime('%j')
        waktu = current_datetime.strftime('%X')
        jam = current_datetime.strftime('%H')
        mnt = current_datetime.strftime('%M')
        dtk = current_datetime.strftime('%S')
        
        leap = 366 if (thn % 400 == 0) or (thn % 4 == 0 and thn % 100 != 0) else 365
        persen = 100 / leap * (float(harke) - 1 + (float(jam) / 24) + (float(mnt) / 1440) + (float(dtk) / 86400))
        harmun = 1 + leap - int(harke)
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
        time_text = f"{hari}, {tgl} {bul} {thn}\nDay-{harke} ({round(persen, 4)}%)\n{waktu}"
        
        self.result_label.config(text=result_text)
        self.time_label.config(text=time_text)
        
        self.root.after(1000, self.update_time)

if __name__ == '__main__':
    root = tk.Tk()
    app = DateInfoApp(root)
    root.mainloop()
