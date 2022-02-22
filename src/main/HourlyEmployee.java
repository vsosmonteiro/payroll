package main;

import java.util.ArrayList;
public class HourlyEmployee extends Employee {

   protected ArrayList <Integer>timecard=new ArrayList<>();
    protected int Hourtime;

    public HourlyEmployee(String name, String address, int type, int id, int fired
            ,int sindicate,int Hourtime) {
        super(name, address, type, id, fired,sindicate);
        this.Hourtime=Hourtime;
    }

    public void setHourtime(int hourtime) {
        Hourtime = hourtime;
    }

    public int getHourtime() {
        return Hourtime;
    }

    public void setTimecard(int time) {
        this.timecard.add(time);
    }

    public ArrayList<Integer> getTimecard() {
        return timecard;
    }
}

