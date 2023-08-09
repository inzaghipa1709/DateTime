import tkinter as tk
import datetime

def update_time():
    current_time = datetime.datetime.now()

    year = str(current_time.year)
    month = str(current_time.month)
    month_name = current_time.strftime("%B")
    day = current_time.strftime("%w")
    day_name = current_time.strftime("%A")
    day_of_year = current_time.strftime("%j")
    hour = current_time.strftime("%H")
    minute = current_time.strftime("%M")
    second = current_time.strftime("%S")

    if day_name == "Sunday":
        day = "7"

    year_label.config(text="Tahun : " + year)
    month_label.config(text="Bulan : " + month + " (" + month_name + ")")
    date_label.config(text="Tanggal : " + day)
    day_label.config(text="Hari : " + day_name)
    day_of_year_label.config(text="Hari ke (dalam Setahun) : " + day_of_year)
    hour_label.config(text="Jam : " + hour)
    minute_label.config(text="Menit : " + minute)
    second_label.config(text="Detik : " + second)

    root.after(1000, update_time)

root = tk.Tk()
root.title("Penanggalan")
root.geometry("320x200")
root.resizable(False, False)

frame = tk.Frame(root, padx=20)
frame.pack(fill=tk.BOTH)

year_label = tk.Label(frame, text="Tahun: ")
year_label.pack(anchor=tk.W)
month_label = tk.Label(frame, text="Bulan: ")
month_label.pack(anchor=tk.W)
date_label = tk.Label(frame, text="Tanggal: ")
date_label.pack(anchor=tk.W)
day_label = tk.Label(frame, text="Hari: ")
day_label.pack(anchor=tk.W)
day_of_year_label = tk.Label(frame, text="Hari ke (dalam Setahun): ")
day_of_year_label.pack(anchor=tk.W)
hour_label = tk.Label(frame, text="Jam: ")
hour_label.pack(anchor=tk.W)
minute_label = tk.Label(frame, text="Menit: ")
minute_label.pack(anchor=tk.W)
second_label = tk.Label(frame, text="Detik: ")
second_label.pack(anchor=tk.W)

update_time()

root.mainloop()
