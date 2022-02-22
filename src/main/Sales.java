package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sales {
    protected int id;
    protected ArrayList<Double> salesvalue= new ArrayList<>();
    protected ArrayList<LocalDate> salesday= new ArrayList<>();

   public Sales(int id)
   {
       this.id=id;
   }

    public void setSalesday(LocalDate day) {

        salesday.add(day);
    }

    public void setSalesvalue(Double value) {
        salesvalue.add(value);
    }

    public int getId() {
        return id;
    }

    public ArrayList<LocalDate> getSalesday() {
        return salesday;
    }

    public ArrayList<Double> getSalesvalue() {
        return salesvalue;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
    public Integer SearchSales(ArrayList Saleslist,int id)
    {
        for (int i=0;i<Saleslist.size();i++)
        {
            if(Saleslist.get(i).hashCode()==id)
            {

                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "main.Sales{" +
                "id=" + id +
                ", salesvalue=" + salesvalue.get(0) +
                ", salesday=" + salesday.get(0) +
                '}';
    }
}

