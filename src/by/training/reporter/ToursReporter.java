package by.training.reporter;


import by.training.constant.FilePathConstant;
import by.training.entity.Tour;
import by.training.creator.ToursCreator;
import by.training.search.ToursSearch;
import by.training.sort.ToursSort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * The type Tours reporter.
 */
public class ToursReporter {
    /**
     * The Log.
     */
    private static Logger log = (Logger) LogManager.getLogger(ToursReporter.class.getName());
    private static File file = new File(FilePathConstant.REPORT_FILE);

    /**
     * Write.
     *
     * @param tours   the tours
     * @param message the message
     */
    public static void write(ArrayList<Tour> tours, String message) {

        try {
            file.createNewFile();
        } catch (IOException e) {
            log.error("File can not be create. ", e);
        }

        PrintWriter out = null;
        try {
            try {
                out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                log.error("Unsupported encoding file.", e);
            }
        } catch (FileNotFoundException e) {
            log.error("File can not be found. ", e);
        }

        try {
            out.print(message);
            if (tours.size() != 0) {
                out.print(tours);
            } else {
                out.print("[ Tours list not found ]");
            }
            out.print("\n\n");
        } finally {
            out.close();
        }
    }

    /**
     * Delete file.
     */
    private void deleteFile() {
        file.delete();
    }

    /**
     * Create report.
     */
    public void createReport() {
        log.info("Start create report");
        HashSet<Tour> tours = new HashSet<Tour>();
        ToursCreator toursCreator = new ToursCreator();
        toursCreator.fillTourList(tours);
        deleteFile();
        ToursReporter.write(ToursSort.sortByDurationDescending(tours), "Sorting tours by duration descending");
        ToursReporter.write(ToursSort.sortByDurationAscending(tours), "Sorting tours by duration ascending");
        ToursReporter.write(ToursSort.sortByCostDescending(tours), "Sorting tours by cost descending");
        ToursReporter.write(ToursSort.sortByCostAscending(tours), "Sorting tours by cost ascending");

        ToursReporter.write(ToursSearch.searchByTransport(tours, "Bus"), "Search tours by bus transport");
        ToursReporter.write(ToursSearch.searchByTransport(tours, "Car"), "Search tours by car transport");
        ToursReporter.write(ToursSearch.searchByDuration(tours, 10), "Search tours by 10 day duration");
        ToursReporter.write(ToursSearch.searchByDuration(tours, 17), "Search tours by 17 day duration");
        ToursReporter.write(ToursSearch.searchByMealPlan(tours, "Modified American Plan"), "Search tours by MAP meal plan");
        ToursReporter.write(ToursSearch.searchByMealPlan(tours, "full"), "Search tours by full meal plan");
        log.info("Report was created successfully.");
    }
}
