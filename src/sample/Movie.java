package sample;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private int yearOfRelease;
    private String[] genre;
    private static final long serialVersionUID = 0L;



    {
        genre = new String[3];
    }
    private String genre1;


    private int runningTime;

    private String productionCompany;
    private Integer budget;
    private Integer revenew;
    private int movieCount=0;
    Movie(String t,int y,String[] g,int run,String p,Integer b,Integer r)
    {
        title=t;
        yearOfRelease=y;
        genre=g;
        runningTime=run;
        productionCompany=p;
        budget=b;
        revenew=r;
        movieCount++;
        int l=g.length;

        if(l==3)
        {
            genre1=genre[0]+"  "+genre[1]+"  "+genre[2];
        }
        else if(l==2)
        {
            genre1=genre[0]+"  "+genre[1];
        }
        else if(l==1)
        {
            genre1=genre[0];
        }
    }
    public StringBuffer movieFile()
    {
        int l=genre.length;
        StringBuffer s=new StringBuffer(this.title);
        s.append(",");
        s.append(this.yearOfRelease);
        s.append(",");
        if(l==3)
        {

            s.append(this.genre[0]);
            s.append(",");
            s.append(this.genre[1]);
            s.append(",");
            s.append(this.genre[2]);
            s.append(",");


        }
        else if(l==2)
        {
            s.append(this.genre[0]);
            s.append(",");
            s.append(this.genre[1]);
            s.append(",");
            s.append(",");

        }
        else if(l==1)
        {
            s.append(this.genre[0]);
            s.append(",");
            s.append(",");
            s.append(",");

        }

        s.append(this.runningTime);
        s.append(",");
        s.append(this.productionCompany);
        s.append(",");
        s.append(this.budget);
        s.append(",");
        s.append(this.revenew);
        return s;
    }
    public String text()
    {
        String text;
        text=title+","+yearOfRelease+","+genre[0]+","+"aa"+","+"ss"+","+runningTime+","+productionCompany+","+budget+","+revenew;
        return text;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public void setRevenew(int revenew) {
        this.revenew = revenew;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public int getBudget() {
        return budget;
    }

    public int getRevenew() {
        return revenew;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public String[] getGenre() {
        return genre;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre1() {
        return genre1;
    }

    public void print()
    {
            System.out.println("Title: "+title);
            System.out.println("Year of Release: "+yearOfRelease);
            for(int j=0;j<genre.length;j++)
            {
                if(!genre[j].isEmpty())System.out.println("Genre "+(j+1)+ ": "+genre[j]);
            }
            System.out.println("Running Time: "+runningTime+" minute");
            System.out.println("Production Company: "+productionCompany);
            System.out.println("Budget: "+budget);
            System.out.println("Revenew: "+revenew);
            System.out.println();

    }
    @Override
    public String toString() {
        return "Title:   "+getTitle() + "\nRelease Year:   " + getYearOfRelease() + "\nRunning Time:  " + getRunningTime()+"\nGenre:  "+getGenre1()+"\nProduction Company: "+getProductionCompany()+"\nBudget:    "+getBudget()+"\nRevenue:  "+getRevenew();
    }

}
