package ru.itis.inf304.kr1var2sem2;

public class BroadcastsTime implements Comparable <BroadcastsTime> {
    private byte hour;
    private byte minutes;

    private int allseconds;

    public int getAllseconds(){
        return allseconds;
    }

    public byte getHour(){
        return hour;
    }

    public byte getMinutes(){
        return minutes;
    }

    public boolean after(BroadcastsTime time){
        return (time.getAllseconds() - getAllseconds()) < 0;
    }

    public boolean before(BroadcastsTime time) {
        return (time.getAllseconds() - getAllseconds()) > 0;
    }

    public boolean between(BroadcastsTime time1, BroadcastsTime time2) {
        return (time2.getAllseconds() - time1.getAllseconds()) > getAllseconds();
    }

    @Override
    public int compareTo(BroadcastsTime c){
        return getAllseconds() - c.getAllseconds();
    }
}
