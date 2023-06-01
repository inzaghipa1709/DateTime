#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int main(){
    int thn, bln, tgl, har;
    int harke;
    int jam, mnt, dtk;

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

    char bufDayInYear[32];
    struct tm *ts5;
    size_t last5;
    time_t daYr = time(NULL);
    ts5   = localtime(&daYr);
    last5 = strftime(bufDayInYear, 32, "%j", ts5);

    time_t now;
    time(&now);
    struct tm *local_time = localtime(&now);
    
    thn = 1900 + local_time->tm_year;
    bln = 1 + local_time->tm_mon;
    tgl = local_time->tm_mday;
    har = local_time->tm_wday;
    jam = local_time->tm_hour;
    mnt = local_time->tm_min;
    dtk = local_time->tm_sec;
  

    printf("Tahun                   : %d\n", thn);
    printf("Bulan                   : %d (%s)\n", bln, bufMon);
    printf("Tanggal                 : %d\n", tgl);
    printf("Hari                    : %d (%s)\n", har, bufDay);
    printf("Hari ke (dalam Setahun) : %s\n", bufDayInYear);
    printf("Jam                     : %d\n", jam);
    printf("Menit                   : %d\n", mnt);
    printf("Detik                   : %d\n", dtk);


    printf("\n");
    printf("%s, %02d %s %d\n", bufDay, tgl, bufMon, thn);
    //printf("%s\n", bufDate);
    printf("Day-%s\n", bufDayInYear);
    printf("%s", bufTime);
    
    return 0;
}
