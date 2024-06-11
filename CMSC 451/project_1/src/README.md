Created by: Antonio Scalfaro
Project 1 - Sorting Benchmarks

This is a Benchmark program to test the Merge Sort and the Heap Sort algorithms on 12 sets of varying sizes of data.
This program generates two csv files, one for each sort, and the Report program allows the user to select the files and 
generate a report in table format. To run this program, run the Benchmarks.java file first to generate the data and follow
up by running the Report.java file and select the two csv files (located in the project_1 folder) one by one to see the
reports. The Benchmark program also initiates a warm up with dummy data to get the most accurate benchmark possible for 
both sorting algorithms. All sorts are checked to ensure they are actually sorted or throw an UnsortedException. The 
sources for the Merge and Heap Sort algorithms are listed at the top of each file.