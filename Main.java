package ru.itis.inf304.kr1var2sem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{

        Scanner scanner = new Scanner(new File("C:/javaprojects/firstyear/2 chapter/2) class/kr1var2sem2/src/main/java/ru/itis/inf304/kr1var2sem2/schedule.txt"));
        List<String> list = new ArrayList<String>();

        while (scanner.hasNext()){
            String v = scanner.nextLine();
            list.add(v);
        }
        List<String> times = new ArrayList<>();
        for (String i : list) {
            if (i.charAt(0) <= '9' && i.charAt(0) >= '0') times.add(i);
        }

        System.out.println(times + "\n");

        Set<String> channels = new HashSet<>();
        for (String i : list) {
            if (i.charAt(0) == '#') channels.add(i);
        }
        Map<String, List<Program>> channelsAndPrograms = new LinkedHashMap<>();

        String channel = null;
        for (String i : times) {
            List<Program> programs = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (channels.contains(list.get(j))) channel = list.get(j);
                if (list.get(j).equals(i)) programs.add(new Program(channel, new BroadcastsTime(i), list.get(j+1)));
            }

            List<Program> programs1 = new ArrayList<>(programs);
            channelsAndPrograms.put(i, programs1);
            programs.clear();
        }

        System.out.println(channelsAndPrograms + "\n");

        List<Program> programsAll = new ArrayList<>();
        channel = null;
        for (int i = 0; i < list.size(); i++) {
            if (channels.contains(list.get(i))) {
                channel = list.get(i);
                continue;
            }
            if (times.contains(list.get(i))) {
                programsAll.add(new Program(channel, new BroadcastsTime(list.get(i)), list.get(i+1)));
                i++;
            }
        }

        System.out.println(programsAll);
        System.out.println(nameProgram("Наше всё"),programsAll);
        System.out.println(correctchannelRightNow(new BroadcastsTime("13:10"), "#Карусель"));
        System.out.println(channelNow(new BroadcastsTime("11:30")));
        System.out.println(betweenTime(new BroadcastsTime("11:30"), new BroadcastsTime("19:46"),programsAll));
    }

    public static List<Program> channelNow(BroadcastsTime time, List<Program> programs){
        List<Program> findPrograms = new ArrayList<>();
        for (Program program: programs) {
            if (program.getTime().getAllseconds() == time.getAllseconds()){
                findPrograms.add(program);
            }
        } return findPrograms;
    }


    
    public static List<Program> nameProgram(String str,List<Program> allPrograms){
        List<Program> foundedPrograms = new ArrayList<>();
        for (Program program: allPrograms) {
            if (program.getBroadcastName().startsWith(str)){
                foundedPrograms.add(program);
            }
        }
        return foundedPrograms;
    }


    public static List<Program> correctchannelRightNow(BroadcastsTime time, String str, Map<BroadcastsTime, List<Program>> allPrograms){
        List<Program> findPrograms = allPrograms.get(str);
        List<Program> sendPrograms = new ArrayList<>();

        for (Program program: findPrograms) {
            if (program.getTime().getAllseconds() == time.getAllseconds()){
                sendPrograms.add(program);
            }
        }
    }



    public static List<Program> betweenTime(BroadcastsTime time1, BroadcastsTime time2,List<Program> programs){
        List<Program> foundedPrograms = new ArrayList<>();
        for (Program program: programs) {
            if (program.getTime().between(time1, time2)){
                foundedPrograms.add(program);
            }
        }
        return foundedPrograms;
    }


}