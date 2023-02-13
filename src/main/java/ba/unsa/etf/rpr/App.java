package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.HostManager;
import ba.unsa.etf.rpr.business.PropertyManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
            }}
            else if ((cl.hasOption(addProperty.getOpt()))) {
                try {

                    Property property = new Property();
                    PropertyManager manager = new PropertyManager();
                    property.setHostId(Integer.parseInt(cl.getArgList().get(0)));
                    List<Host> lh = DaoFactory.HostDao().getAll();
                    boolean t = true;
                    for(Host h:lh) {
                        if (property.getHostId()==h.getId()){
                            t=false; break;
                        }
                    }
                    if(t) {
                        property.setPropertyName(cl.getArgList().get(1));
                        property.setPropertyType(cl.getArgList().get(2));
                        property.setCapacity(Integer.parseInt(cl.getArgList().get(3)));
                        property.setBathrooms(Integer.parseInt(cl.getArgList().get(4)));
                        property.setKitchens(Integer.parseInt(cl.getArgList().get(5)));
                        property.setLocation(cl.getArgList().get(6));
                        property.setAcH(Boolean.parseBoolean(cl.getArgList().get(7)));
                        property.setPrice(Double.parseDouble((cl.getArgList().get(8))));
                        manager.add(property);
                        System.out.println("Successfully added property!");
                    }

                } catch (Exception e) {
                    System.out.println("There is no host in the list with this id! Try again.");
                    System.exit(1);
                }

        }           else if(cl.hasOption(updateProperty.getOpt())){
            try {
                PropertyManager manager = new PropertyManager();
                System.out.println("Input in");
                List<Property> list = manager.getAll();
                List<Integer> ids = new ArrayList<>();
                for(int i = 0; i < list.size(); i++){
                    Property p= list.get(i);
                    ids.add(p.getId());
                }
                if(ids.contains(Integer.valueOf(cl.getArgList().get(0)))) {
                    Property property = new Property();
                    property.setId(Integer.parseInt(cl.getArgList().get(0)));
                    property.setPropertyName(cl.getArgList().get(1));
                    property.setPropertyType(cl.getArgList().get(2));
                    property.setCapacity(Integer.parseInt(cl.getArgList().get(3)));
                    property.setBathrooms(Integer.parseInt(cl.getArgList().get(4)));
                    property.setKitchens(Integer.parseInt(cl.getArgList().get(5)));
                    property.setLocation(cl.getArgList().get(6));
                    property.setAcH(Boolean.parseBoolean(cl.getArgList().get(7)));
                    property.setPrice(Double.parseDouble((cl.getArgList().get(8))));
                    manager.update(property);
                    System.out.println("Successfully updated property!");
                }
                else{
                    System.out.println("The given property doesnt exist in the database!");
                }
            }
            catch(Exception e){
                System.out.println("Incorrect");
            }
        }     else if(cl.hasOption(deleteProperty.getOpt())){
            try {
                PropertyManager manager = new PropertyManager();
                System.out.println("Input in");
                List<Property> list = manager.getAll();
                List<Integer> ids = new ArrayList<>();
                for(int i = 0; i < list.size(); i++){
                    Property p= list.get(i);
                    ids.add(p.getId());
                }
                if(ids.contains(Integer.valueOf(cl.getArgList().get(0)))) {
                    Property property = new Property();
                    property.setId(Integer.parseInt(cl.getArgList().get(0)));
                    manager.delete(property);
                    System.out.println("Successfully deleted property!");
                }
                else{
                    System.out.println("The given property doesnt exist in the database!");
                }
            }
            catch(Exception e){
                System.out.println("Incorrect");
            }
        }        else{
            printFormattedOptions(options);
            System.exit(-1);
        }

    }
}
