
package project_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Report {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Report::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Sort Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new BorderLayout());
        JButton openButton = new JButton("Open CSV File");
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(openButton, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        openButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                List<SortData> dataList = readCSV(selectedFile);
                if (dataList != null) {
                    populateTable(table, dataList);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private static List<SortData> readCSV(File file) {
        List<SortData> dataList = new ArrayList<>();
        Map<Integer, SortData> dataMap = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine(); // Skip the header line
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                int dataSize = Integer.parseInt(line[0]);
                double avgComparisons = Double.parseDouble(line[1]);
                double avgTime = Double.parseDouble(line[2]);

                dataMap.putIfAbsent(dataSize, new SortData(dataSize));
                SortData data = dataMap.get(dataSize);
                data.addComparison(avgComparisons);
                data.addTime(avgTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataList.addAll(dataMap.values());
        return dataList;
    }

    private static void populateTable(JTable table, List<SortData> dataList) {
        String[] columnNames = {"Data Size", "Avg Comparisons", "Coeff of Var Comparisons", "Avg Time", "Coeff of Var Time"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (SortData data : dataList) {
            double avgComparisons = data.getAvgComparisons();
            double avgTime = data.getAvgTime();
            double coeffOfVarComparisons = computeCoefficientOfVariance(data.getComparisons());
            double coeffOfVarTime = computeCoefficientOfVariance(data.getTimes());

            model.addRow(new Object[]{data.getDataSize(), avgComparisons, coeffOfVarComparisons, avgTime, coeffOfVarTime});
        }

        table.setModel(model);
    }

    private static double computeCoefficientOfVariance(List<Double> values) {
        double mean = values.stream().mapToDouble(val -> val).average().orElse(0.0);
        double stdDev = Math.sqrt(values.stream().mapToDouble(val -> Math.pow(val - mean, 2)).sum() / values.size());
        return (stdDev / mean) * 100;
    }
}


class SortData {
    private final int dataSize;
    private final List<Double> comparisons;
    private final List<Double> times;

    public SortData(int dataSize) {
        this.dataSize = dataSize;
        this.comparisons = new ArrayList<>();
        this.times = new ArrayList<>();
    }

    public int getDataSize() {
        return dataSize;
    }

    public void addComparison(double comparison) {
        comparisons.add(comparison);
    }

    public void addTime(double time) {
        times.add(time);
    }

    public double getAvgComparisons() {
        return comparisons.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double getAvgTime() {
        return times.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public List<Double> getComparisons() {
        return comparisons;
    }

    public List<Double> getTimes() {
        return times;
    }
}
