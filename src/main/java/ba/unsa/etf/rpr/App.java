package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.HostManager;
import ba.unsa.etf.rpr.domain.Host;
import org.apache.commons.cli.*;

import java.io.PrintWriter;

public class App
{
    private static final Option addHost = new Option("h","add-host",false, "Adding new host to projekat database");
    private static final Option addProperty = new Option("p","add-property",false, "Adding new property to projekat database");
    private static final Option deleteProperty = new Option("delP", "get-host",false, "Deleting a property from  projekat database");
    private static final Option updateProperty= new Option("updP", "get-property",false, "Updating a property from  projekat database");

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


    public static void main( String[] args ) throws Exception {
        Options options = addOptions();

        CommandLineParser commandLineParser = new DefaultParser();

        CommandLine cl = commandLineParser.parse(options, args);

//        while(true) {
        if ((cl.hasOption(addHost.getOpt()))) {
            try {

                Host host = new Host();
                HostManager manager = new HostManager();
                host.setName(cl.getArgList().get(0));
                host.setNumber(cl.getArgList().get(1));
                host.setEmail(cl.getArgList().get(2));
                manager.add(host);
                System.out.println("Successfully added host!");

            } catch (Exception e) {
                System.out.println("There is no host in the list! Try again.");
                System.exit(1);
            }



        }
    }
}
