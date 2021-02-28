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

    private static final ResourceBundle BUNDLE = Messenger.getConfig().getLang().getBundle("Club");
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

    //
    // Constructors
    //
    public Club() {
    }

    public Club(String officialName) {
    }

    public Club(String officialName, String shortName, String established, String[] colors,
            String ballpark, int numberOfWorldSeriesTitles, int numberOfNlPennants,
            int numberOfDivisionTitles, int numberOfWildCardBerths, String[] owners,
            President president, GeneralManager generalManager, Manager manager) {
        this.officialName = officialName;
        this.shortName = shortName;
        this.established = established;
        this.colors = colors;
        this.ballpark = ballpark;
        this.numberOfWorldSeriesTitles = numberOfWorldSeriesTitles;
        this.numberOfNlPennants = numberOfNlPennants;
        this.numberOfDivisionTitles = numberOfDivisionTitles;
        this.numberOfWildCardBerths = numberOfWildCardBerths;
        this.owners = owners;
        this.president = president;
        this.generalManager = generalManager;
        this.manager = manager;
    }

    /**
     * Unused constructor from starter code. The provided constructor was broken and have since
     * fixed to ensure a successful compilation.
     */
    @Deprecated
    public Club(int yearEstablished, String[] owners, String[] colors, String officialName,
            String shortName) {
    }

    public void displayInfo() {
        String[] fields = {
                BUNDLE.getString("officialName.label"),
                BUNDLE.getString("shortName.label"),
                BUNDLE.getString("established.label"),
                BUNDLE.getString("colors.label"),
                BUNDLE.getString("ballpark.label"),
                BUNDLE.getString("numberOfWorldSeriesTitles.label"),
                BUNDLE.getString("numberOfNlPennants.label"),
                BUNDLE.getString("numberOfDivisionTitles.label"),
                BUNDLE.getString("numberOfWildCardBerths.label"),
                BUNDLE.getString("owners.label"),
                BUNDLE.getString("president.label"),
                BUNDLE.getString("generalManager.label"),
                BUNDLE.getString("manager.label")
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
                String.valueOf(owners),
                String.valueOf(president),
                String.valueOf(generalManager),
                String.valueOf(manager)
        };
        ChatSession.printTable(fields, values);
    }
}