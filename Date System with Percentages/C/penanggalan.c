#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int main(){
    int leap, thn, bln, tgl, har;
    int harke, harmun;
    int jam, mnt, dtk;
    double dateCal, persen, permun;

    char bufMon[32];
    struct tm *ts1;
    size_t last1;
    time_t nowMn = time(NULL);
    ts1   = localtime(&nowMn);
    last1 = strftime(bufMon, 32, "%B", ts1);
    bufMon[last1] = '\0';

    char bufDay[32];
    struct tm *ts2;
    size_t last2;
    time_t nowDy = time(NULL);
    ts2   = localtime(&nowDy);
    last2 = strftime(bufDay, 32, "%A", ts2);
    bufDay[last2] = '\0';

    char bufDate[32];
    struct tm *ts3;
    size_t last3;
    time_t nowDt = time(NULL);
    ts3   = localtime(&nowDt);
    last3 = strftime(bufDate, 32, "%A, %d %B %G", ts3);

    char bufTime[32];
    struct tm *ts4;
    size_t last4;
    time_t nowTm = time(NULL);
    ts4   = localtime(&nowTm);
    last4 = strftime(bufTime, 32, "%H:%M:%S", ts4);
    bufTime[last4] = '\0';

    time_t now;
    time(&now);
    struct tm *local_time = localtime(&now);
    
    thn = 1900 + local_time->tm_year;
    bln = 1 + local_time->tm_mon;
    tgl = local_time->tm_mday;
    har = local_time->tm_wday;
    harke = 1 + local_time->tm_yday;
    jam = local_time->tm_hour;
    mnt = local_time->tm_min;
    dtk = local_time->tm_sec;
  
    if (thn % 400 == 0){
        leap = 366;
    }
    else if (thn % 100 == 0){
        leap = 365;
    }
    else if (thn % 4 == 0){
        leap = 366;
    }
    else {
        leap = 365;
    }
  
    dateCal = (harke-1)+((double)jam/24)+((double)mnt/1440)+((double)dtk/86400);
    persen = (double)(100*dateCal/leap);
    harmun = 1+leap-harke;
    permun = 100-persen;


    printf("Tahun                    : %d\n", thn);
    printf("Bulan                    : %d (%s)\n", bln, bufMon);
    printf("Tanggal                  : %d\n", tgl);
    printf("Hari                     : %d (%s)\n", har, bufDay);
    printf("Hari ke (dalam Setahun)  : %d\n", harke);
    printf("Sisa Hari (Tahun depan)  : %d\n", harmun);
    printf("Persentase dalam Setahun : %f%\n", persen);
    printf("Persentase Hitung Mundur : %f%\n", permun);
    printf("Jam                      : %d\n", jam);
    printf("Menit                    : %d\n", mnt);
    printf("Detik                    : %d\n", dtk);


    printf("\n");
    printf("%s, %02d %s %d\n", bufDay, tgl, bufMon, thn);
    printf("Day-%d (%.4f%)\n", harke, persen);
    printf("%s", bufTime);
    
    return 0;
}