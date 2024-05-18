package week_1_disc;

import java.util.ArrayList;
import java.util.List;

public class TravelingSalesman {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] distances = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        
        int n = distances.length;
        List<Integer> cities = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            cities.add(i);
        }
        
        int result = tsp(0, cities, distances);
        System.out.println("Minimum travel cost: " + result);
    }

    private static int tsp(int start, List<Integer> cities, int[][] distances) {
        if (cities.isEmpty()) {
            return distances[start][0];
        }

        int minCost = INF;
        for (int i = 0; i < cities.size(); i++) {
            int city = cities.get(i);
            List<Integer> remainingCities = new ArrayList<>(cities);
            remainingCities.remove(i);
            int cost = distances[start][city] + tsp(city, remainingCities, distances);
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
}

