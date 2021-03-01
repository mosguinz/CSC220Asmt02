/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Club.java
 * @author: Duc Ta
 * @author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ResourceBundle;

public class Club {

    private String officialName;
    private String shortName;
    private String established;
    private String[] colors;
    private String ballpark;
    private String numberOfWorldSeriesTitles;
    private String numberOfNlPennants;
    private String numberOfDivisionTitles;
    private String numberOfWildCardBerths;
    private String[] owners;
    private President president;
    private GeneralManager generalManager;
    private Manager manager;

    /**
     * Sole constructor to instantiate a {@link Club}. Loads the club information from the resource
     * bundle.
     */
    public Club() {
        final ResourceBundle bundle = ResourceBundle
                .getBundle("assignment02PartB.resources.ClubInfo");
        officialName = bundle.getString("officialName");
        shortName = bundle.getString("shortName");
        established = bundle.getString("established");
        colors = bundle.getString("colors").split(",");
        ballpark = bundle.getString("ballpark");
        numberOfWorldSeriesTitles = bundle.getString("numberOfWorldSeriesTitles");
        numberOfNlPennants = bundle.getString("numberOfNlPennants");
        numberOfDivisionTitles = bundle.getString("numberOfDivisionTitles");
        numberOfWildCardBerths = bundle.getString("numberOfWildCardBerths");
        owners = bundle.getString("owners").split(",");
        president = new President(
                bundle.getString("president.firstName"),
                bundle.getString("president.lastName"),
                this
        );
        generalManager = new GeneralManager(
                bundle.getString("generalManager.firstName"),
                bundle.getString("generalManager.lastName"),
                this
        );
        manager = new Manager(
                bundle.getString("manager.firstName"),
                bundle.getString("manager.lastName"),
                this
        );
    }

    /**
     * Unused constructor from starter code.
     *
     * @deprecated The provided constructor was broken and have edited in order to allow
     *         compilation. Preserved in accordance with the requirements listed in the assignment
     *         specification.
     */
    @Deprecated
    public Club(int yearEstablished, String[] owners, String[] colors, String officialName,
            String shortName) {
    }

    public String getOfficialName() {
        return officialName;
    }

    public String getShortName() {
        return shortName;
    }

    /**
     * Display information about the club.
     */
    public void displayInfo() {
        final ResourceBundle bundle = Messenger.getConfig().getLang().getBundle("Club");
        String[] fields = {
                bundle.getString("officialName.label"),
                bundle.getString("shortName.label"),
                bundle.getString("established.label"),
                bundle.getString("colors.label"),
                bundle.getString("ballpark.label"),
                bundle.getString("numberOfWorldSeriesTitles.label"),
                bundle.getString("numberOfNlPennants.label"),
                bundle.getString("numberOfDivisionTitles.label"),
                bundle.getString("numberOfWildCardBerths.label"),
                bundle.getString("owners.label"),
                bundle.getString("president.label"),
                bundle.getString("generalManager.label"),
                bundle.getString("manager.label")
        };
        String[] values = {
                officialName,
                shortName,
                established,
                String.join(", ", colors),
                ballpark,
                numberOfWorldSeriesTitles,
                numberOfNlPennants,
                numberOfDivisionTitles,
                numberOfWildCardBerths,
                String.join(", ", owners),
                president.toString(),
                generalManager.toString(),
                manager.toString()
        };
        ChatSession.printTable(fields, values);
    }

    /**
     * Prints a dialogue message with the club's short name. Includes a newline at the end.
     *
     * @param m The message to print.
     */
    public void sayDialogue(String m) {
        System.out.printf("%s: %s%n", shortName, m);
    }

    /**
     * Prints a prompt message with the club's short name. Includes a space at the end.
     *
     * @param m The message to use as a prompt.
     */
    public void sayPrompt(String m) {
        System.out.printf("%s: %s ", shortName, m);
    }
}
