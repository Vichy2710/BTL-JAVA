/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tour;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author admin
 */
public class XManager {
    final List<Tour> tour = new LinkedList<>();
    TourManager m = new TourManager() {
        @Override
        public boolean addTour(Tour t) {
            tour.add(t);
            return true;
        }

        @Override
        public boolean editTour(Tour t) {
            for (int i = 0; i < tour.size(); i++) {
                if (tour.get(i).getProduct_id().equals(t.getProduct_id())) {
                    tour.set(i, t);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean delTour(Tour t) {
            int pos = -1;
            for (int i = 0; i < tour.size(); i++) {
                if (tour.get(i).isEqual(t)) {
                    pos = i;
                }
            }
            if (pos != -1) {
                tour.remove(pos);
                return true;
            }
            return false;
        }

        @Override
        public List<Tour> searchTourByName(String name) {
            List<Tour> listTour = new LinkedList<>();
            for (Tour i : tour) {
                if (i.getProduct_name().equals(name)) {
                    listTour.add(i);
                }
            }
            return listTour;
        }

        @Override
        public List<Tour> searchTourByPrice(Double price) {
            List<Tour> listTour = new LinkedList<>();
            for (Tour i : tour) {
                if (i.getProduct_price().equals(price)) {
                    listTour.add(i);
                }
            }
            return listTour;
        }

        @Override
        public List<Tour> searchTourByTime(Double time) {
            List<Tour> listTour = new LinkedList<>();
            for (Tour i : tour) {
                if (i.getTour_time().equals(time)) {
                    listTour.add(i);
                }
            }
            return listTour;
        }

        @Override
        public List<Tour> sortedTour(Double price) {
            List<Tour> listTour = new LinkedList<>();
            for (Tour i : tour) {
                listTour.add(i);
            }
            for (int i = 0; i < listTour.size() - 1; i++) {
                for (int j = i + 1; j < listTour.size(); j++) {
                    if (listTour.get(i).getProduct_price() > listTour.get(j).getProduct_price()) {
                        Tour temp = listTour.get(i);
                        listTour.set(i, listTour.get(j));
                        listTour.set(j, temp);
                    }
                }
            }
            return listTour;
        }
    };
}
