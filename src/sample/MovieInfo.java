package sample;

import java.io.Serializable;
import java.util.*;

public class MovieInfo implements Serializable
{
    private static final long serialVersionUID = 0L;
    public static List<Movie>movieList=new ArrayList<Movie>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
    public void print()
    {
        for(int i=0;i<movieList.size();i++)
        {
            movieList.get(i).print();
        }
    }
    public static Movie searchbyTitle(String title)
    {
        Movie m;
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getTitle().equalsIgnoreCase(title))
            {
                m=movieList.get(i);
                return m;
            }
        }
        return null;
    }
    public static List<Movie> searchByReleaseYear(int year)
    {
        List<Movie>m=new ArrayList<Movie>();
        int count=0;
        for(int i=0;i<movieList.size();i++)
        {
            count++;
            if(movieList.get(i).getYearOfRelease()==year)
            {
                m.add(movieList.get(i));
            }

        }
        if(count==0) return null;
        else return m;

    }
    public  List<Movie> searchByGenre(String s)
    {
        int count=0;
        List<Movie>m=new ArrayList<Movie>();
        for(int i=0;i<movieList.size();i++)
        {
            for(int j=0;j<movieList.get(i).getGenre().length;j++)
            {
                if(movieList.get(i).getGenre()[j].equalsIgnoreCase(s))
                {
                    count++;
                    m.add(movieList.get(i));
                }
            }
        }
        if(count==0) return null;
        else return m;

    }
    public static List<Movie> searchByProductionCompany(String s)
    {
        int count=0;
        List<Movie>m=new ArrayList<Movie>();
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getProductionCompany().equalsIgnoreCase(s))
            {
                count++;
                m.add(movieList.get(i));
            }
        }
        if(count==0) return null;
        else         return m;


    }
    public static List<Movie> searchByRunningTime(int low,int high)
    {
        int count=0;
        List<Movie>m=new ArrayList<Movie>();
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getRunningTime()>=low && movieList.get(i).getRunningTime()<=high)
            {
                count++;
                System.out.print(count+".");
                System.out.println();
                m.add(movieList.get(i));
            }
        }
        if(count==0) return null;
        else return m;
    }
    public List<Movie> topTenMovies()
    {
        int count=0;
        List<Movie>m=new ArrayList<Movie>();
        ArrayList<Integer>budget=new ArrayList<>();
        ArrayList<Integer>revenew=new ArrayList<>();
        ArrayList<Integer>profit=new ArrayList<>();
        for(int i=0;i<movieList.size();i++)
        {
            budget.add(movieList.get(i).getBudget());
            revenew.add(movieList.get(i).getRevenew());
        }
        for(int i=0;i<budget.size();i++)
        {
            profit.add(revenew.get(i)-budget.get(i));
        }
        Collections.sort(profit);
        Collections.reverse(profit);
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<movieList.size();j++)
            {
                if(profit.get(i)==(movieList.get(j).getRevenew()-movieList.get(j).getBudget()))
                {
                    count++;
                    m.add(movieList.get(j));
                }
            }
        }
        return m;
    }
    public static List<Movie> mostRecentMovies(String s)
    {
        int countmovie=0;
        List<Movie>m=new ArrayList<Movie>();
        ArrayList<Integer>year = new ArrayList<>();
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getProductionCompany().equalsIgnoreCase(s))
            {
                year.add(movieList.get(i).getYearOfRelease());
            }
        }
        Collections.sort(year);
        Collections.reverse(year);


            for(int j=0;j<movieList.size();j++)
            {
                if(movieList.get(j).getProductionCompany().equalsIgnoreCase(s) && movieList.get(j).getYearOfRelease()==year.get(0))
                {
                    countmovie++;
                    m.add(movieList.get(j));
                }
            }

        if(countmovie==0) return null;
        else  return m;
    }
    public static List<Movie> moviesWithMaximumRevenew(String s)
    {
        int countmovie=0;
        List<Movie>m=new ArrayList<Movie>();
        ArrayList<Integer>revenew=new ArrayList<Integer>();
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getProductionCompany().equalsIgnoreCase(s))
            {
                revenew.add(movieList.get(i).getRevenew());
            }
        }
        Collections.sort(revenew);
        Collections.reverse(revenew);

            for(int j=0;j<movieList.size();j++)
            {
                if(movieList.get(j).getProductionCompany().equalsIgnoreCase(s) && movieList.get(j).getRevenew()==revenew.get(0))
                {
                    countmovie++;
                    m.add(movieList.get(j));
                }
            }

        if(countmovie==0) return null;
        else return m;

    }
    public static long  totalProfit(String s)
    {
        long sum=0;
        int count=0;
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getProductionCompany().equalsIgnoreCase(s))
            {
                count++;
                int x=movieList.get(i).getRevenew()-movieList.get(i).getBudget();
                sum+=x;

            }
        }
        if(count>0) return sum;
        else return 0;
    }
    public List<ProductionCompany> companyAndProducedMovieNumber()
    {
        List<ProductionCompany>productionCompanies=new ArrayList<ProductionCompany>();
        int count=1;
        int check=0;
        int countmovie=0;
        for(int i=0;i<movieList.size();i++)
        {
            check=0;
            count=1;
           for(int j=0;j<movieList.size();j++)
           {
               if(i==j) continue;
               else if(movieList.get(i).getProductionCompany().equalsIgnoreCase(movieList.get(j).getProductionCompany()))
               {
                   count++;
               }
           }
           for(int k=0;k<productionCompanies.size();k++)
           {
               if(movieList.get(i).getProductionCompany().equalsIgnoreCase(productionCompanies.get(k).getProductionCompany()))
               {
                   check=1;
                   break;
               }
           }
           if(check==0)
           {
               ProductionCompany p=new ProductionCompany();
               p.setProductionCompany(movieList.get(i).getProductionCompany());
               p.setMovieNumber(count);
               productionCompanies.add(p);
           }

        }
        return productionCompanies;

    }
    public static boolean checkClone(String s)
    {

        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getTitle().equalsIgnoreCase(s))
            {
                return true;
            }

        }
        return false;
    }
    public static void addMovie()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a title:");
        String title = sc.nextLine();
        if(checkClone(title))
        {
            System.out.println("This movie is already in the list");
            return;
        }
        System.out.println("Enter Release year:");
        int year=Integer.parseInt(sc.nextLine());
        System.out.println("Enter a Genre[upto 3]: ");
        String genre=sc.nextLine();
        String[] splited=new String[3];
         splited=genre.split(",");
        String[] gen = splited;
        System.out.println("Enter a running time:");
        int run=Integer.parseInt(sc.nextLine());
        System.out.println("Enter the production company:");
        String product=sc.nextLine();
        System.out.println("Enter Budget: ");
        Integer budget=sc.nextInt();
        System.out.println("Enter Revenew: ");
        Integer revenew=sc.nextInt();
        Movie movie=new Movie(title,year,gen,run,product,budget,revenew);
        movieList.add(movie);
        System.out.println("Movie Added Succesfully");


    }

}
