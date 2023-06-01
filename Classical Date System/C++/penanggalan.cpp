#include <iostream>
#include <iomanip>
#include <ctime>
using namespace std;

const string currentMonth() {
    time_t nowMn = time(0);
    struct tm tstruct;
    char buf[80];
    tstruct = *localtime(&nowMn);
    strftime(buf, sizeof(buf), "%B", &tstruct);
    return buf;
}

const string currentDay() {
    time_t nowDy = time(0);
    struct tm tstruct;
    char buf[80];
    tstruct = *localtime(&nowDy);
    strftime(buf, sizeof(buf), "%A", &tstruct);
    return buf;
}

const string currentDate() {
    time_t nowDt = time(0);
    struct tm tstruct;
    char buf[80];
    tstruct = *localtime(&nowDt);
    strftime(buf, sizeof(buf), "%A, %d %B %G", &tstruct);
    return buf;
}

const string currentTime() {
    time_t nowTm = time(0);
    struct tm tstruct;
    char buf[80];
    tstruct = *localtime(&nowTm);
    strftime(buf, sizeof(buf), "%H:%M:%S", &tstruct);
    return buf;
}

const string dayInAYear() {
    time_t daYr = time(0);
    struct tm tstruct;
    char buf[80];
    tstruct = *localtime(&daYr);
    strftime(buf, sizeof(buf), "%j", &tstruct);
    return buf;
}


int main() {
    int thn, bln, tgl, har;
    int harke;
    int jam, mnt, dtk;
    string bul, hari, waktu, tanggal;
    float persen;

    time_t ttime = time(0);
    tm *local_time = localtime(&ttime);

    thn = 1900 + local_time->tm_year;
    bln = 1 + local_time->tm_mon;
    bul = currentMonth();
    tgl = local_time->tm_mday;
    har = local_time->tm_wday;
    hari = currentDay();
    harke = stoi(dayInAYear());
    tanggal = currentDate();
    waktu = currentTime();
    jam = local_time->tm_hour;
    mnt = local_time->tm_min;
    dtk = local_time->tm_sec;

    if (hari == "Sunday"){
        har = 7;
    }


    cout<<"Tahun                   : "<<thn<<endl;
    cout<<"Bulan                   : "<<bln<<" ("<<bul<<")"<<endl;
    cout<<"Tanggal                 : "<<tgl<<endl;
    cout<<"Hari                    : "<<har<<" ("<<hari<<")"<<endl;
    cout<<"Hari ke (dalam Setahun) : "<<harke<<endl;
    cout<<"Jam                     : "<<jam<<endl;
    cout<<"Menit                   : "<<mnt<<endl;
    cout<<"Detik                   : "<<dtk<<endl;

    cout<<endl;
    //cout<<tanggal<<endl;
    cout<<hari<<", "<<tgl<<" "<<bul<<" "<<thn<<endl;
    cout<<"Day-"<<harke<<endl;
    cout<<waktu<<endl;

    return 0;
}