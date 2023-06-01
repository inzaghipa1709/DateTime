dt = Time.new

thn = dt.year
bln = dt.month
bul = dt.strftime("%B")
tgl = dt.day
har = dt.wday
hari = dt.strftime("%A")
harke = dt.yday
waktu = dt.strftime("%H:%M:%S")
jam = dt.hour
mnt = dt.min
dtk = dt.sec 

if thn % 400 == 0
    leap=366
elsif thn % 100 == 0
    leap=365
elsif thn % 4 == 0
    leap=366
else
    leap=365
end

dateCal = (harke-1)+(jam.to_f/24)+(mnt.to_f/1440)+(dtk.to_f/86400)
persen = 100*dateCal/leap
harmun = 1+leap-harke
permun = 100-persen

if hari == "Sunday"
    har = 7
end

puts "Tahun                    : #{thn}"
puts "Bulan                    : #{bln} (#{bul})"
puts "Tanggal                  : #{tgl}"
puts "Hari                     : #{har} (#{hari})"
puts "Hari ke (dalam Setahun)  : #{harke}"
puts "Sisa Hari (Tahun depan)  : #{harmun}"
puts "Persentase dalam Setahun : #{persen.round(6)}%"
puts "Persentase Hitung Mundur : #{permun.round(6)}%"
puts "Jam                      : #{jam}"
puts "Menit                    : #{mnt}"
puts "Detik                    : #{dtk}"

puts
puts "#{hari}, #{tgl} #{bul} #{thn}"
puts "Day-#{harke} (#{persen.round(4)}%)"
puts waktu