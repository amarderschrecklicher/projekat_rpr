package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.PropertyManager;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.domain.Reservations;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.util.List;

public class App
{
    private static final Option addHost = new Option("h","add-host",false, "Adding new host to projekat database");
    private static final Option addProperty = new Option("p","add-property",false, "Adding new property to projekat database");
    private static final Option deleteProperty = new Option("getH", "get-host",false, "Deleting a property from  projekat database");
    private static final Option updateProperty= new Option("getP", "get-property",false, "Updating a property from  projekat database");

    /**
     *
     * @param options
     *
     */
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar projekat.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addHost);
        options.addOption(addProperty);
        options.addOption(deleteProperty);
        options.addOption(updateProperty);

        return options;
    }

    public static Property searchThroughProperties(List<Property> listOfCategories, String categoryName) {

        Property property = null;
        property = listOfCategories.stream().filter(cat -> cat.getPropertyName().toLowerCase().equals(categoryName.toLowerCase())).findAny().get();
        return property;

    }

    public static void main( String[] args ) throws Exception {
        Options options = addOptions();

        CommandLineParser commandLineParser = new DefaultParser();

        CommandLine cl = commandLineParser.parse(options, args);

//        while(true) {
        if ((cl.hasOption(addHost.getOpt()) || cl.hasOption(addHost.getLongOpt()) )) {
            Host host = new Host();
            Reservations reservations = new Reservations();
            Property property = null;
            try {
                property = searchThroughProperties(PropertyManager.getAll(), (String) cl.getArgList().get(1));
            } catch (Exception e) {
                System.out.println("There is no host in the list! Try again.");
                System.exit(1);
            }

//                if(!category.getName().equals(cl.getArgList().get(1))){
//                    System.out.println("There is no category with passed name! Try again.");
//                    System.exit(-1);
//                }


        }
    }
}
