package ru.itis.inf304.kr1var2sem2;

public class Program implements Comparable<Program> {
    private String channelName;
    private BroadcastsTime time;
    private String broadcastName;

    public Program(String channelName, BroadcastsTime time, String broadcastName) {
        this.channelName = channelName;
        this.time = time;
        this.broadcastName = broadcastName;
    }

    public String getChannelName(String channelName) {
        return channelName;
    }

    public BroadcastsTime getTime(){
        return time;
    }

    public String getBroadcastName(String broadcastName){
        return broadcastName;
    }

    public void setChannelName(String channelName){
        this.channelName = channelName;
    }

    public void setTime(BroadcastsTime time) {
        this.time = time;
    }

    public void setBroadcastName(String broadcastName) {
        this.broadcastName = broadcastName;
    }

    @Override
    public int compareTo(Program c) {
        return getTime().getAllseconds() - c.getTime().getAllseconds();
    }

    @Override
    public String toString() {
        return "Программа{" + "название канала = " + channelName + "время = " + time + "название передачи" + broadcastName;
    }
}
