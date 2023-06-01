import datetime

x = datetime.datetime.now()

thn = x.year
bln = x.month
bul = x.strftime("%B")
tgl = x.strftime("%d")
har = x.strftime("%w")
hari = x.strftime("%A")
harke = x.strftime("%j")
waktu = x.strftime("%X")
jam = x.strftime("%H")
mnt = x.strftime("%M")
dtk = x.strftime("%S")

if hari == "Sunday":
    har = 7

print("Tahun                   : "+str(thn))
print("Bulan                   : "+str(bln)+" ("+str(bul)+")")
print("Tanggal                 : "+str(tgl))
print("Hari                    : "+str(har)+" ("+str(hari)+")")
print("Hari ke (dalam Setahun) : "+str(harke))
print("Jam                     : "+str(jam))
print("Menit                   : "+str(mnt))
print("Detik                   : "+str(dtk))

print()
print(str(hari)+", "+str(tgl)+" "+str(bul)+" "+str(thn))
print("Day-"+str(harke))
print(str(waktu))
