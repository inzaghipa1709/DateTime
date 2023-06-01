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

if hari == "Sunday"
    har = 7
end

puts "Tahun                   : #{thn}"
puts "Bulan                   : #{bln} (#{bul})"
puts "Tanggal                 : #{tgl}"
puts "Hari                    : #{har} (#{hari})"
puts "Hari ke (dalam Setahun) : #{harke}"
puts "Jam                     : #{jam}"
puts "Menit                   : #{mnt}"
puts "Detik                   : #{dtk}"

puts
puts "#{hari}, #{tgl} #{bul} #{thn}"
puts "Day-#{harke}"
puts waktu
