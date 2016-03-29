package by.training;

import by.training.reporter.ToursReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**  Описание программы.
 *    Туристические путевки. Сформировать набор предложений клиенту
 *    по выбору туристической путевки различного типа (отдых, экскурсии, ле-
 *    чение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать возмож-
 *    ность выбора транспорта, питания и числа дней. Реализовать выбор и сор-
 *    тировку путевок.
 */

/**
 * The type Runner.
 */
public class Runner {

    /**
     * The Log.
     */
    static Logger log = (Logger) LogManager.getLogger(Runner.class.getName());

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        log.info("Start main function ");

        ToursReporter report = new ToursReporter();
        report.createReport();

        log.info("Finish main function ");
    }
}
