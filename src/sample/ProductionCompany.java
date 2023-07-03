package sample;

import java.io.Serializable;

public class ProductionCompany implements Serializable {

    private static final long serialVersionUID = 0L;
    private String productionCompany;
    private int movieNumber;

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }
    public void print()
    {
            System.out.println("Production Company Name: "+productionCompany);
            System.out.println("Number of Movie: "+movieNumber);
            System.out.println();

    }
}
