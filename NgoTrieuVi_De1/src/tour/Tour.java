/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tour;

/**
 *
 * @author admin
 */
public class Tour extends Product {
    private String tour_place;
    private Double tour_time;

    public Tour() {
    }

    public Tour(String tour_place, Double tour_time) {
        this.tour_place = tour_place;
        this.tour_time = tour_time;
    }

    public Tour(String product_id, String product_name, Double product_price, Long product_total, String tour_place, Double tour_time) {
        super(product_id, product_name, product_price, product_total);
        this.tour_place = tour_place;
        this.tour_time = tour_time;
    }

    public String getTour_place() {
        return tour_place;
    }

    public void setTour_place(String tour_place) {
        this.tour_place = tour_place;
    }

    public Double getTour_time() {
        return tour_time;
    }

    public void setTour_time(Double tour_time) {
        this.tour_time = tour_time;
    }
    
    public boolean isEqual(Tour t) {
      if (!t.getProduct_id().equals(super.getProduct_id())) return false;
      if (!t.getProduct_name().equals(super.getProduct_name())) return false;
      if (!t.getProduct_price().equals(super.getProduct_price())) return false;
      if (!t.getProduct_total().equals(super.getProduct_total())) return false;
      if (!t.getTour_place().equals(tour_place)) return false;
      if (!t.getTour_time().equals(tour_time)) return false;
      return true;
    };
}
