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

    private static final ResourceBundle LANG_BUNDLE = Messenger.getConfig().getLang()
            .getBundle("Club");
    private static final ResourceBundle CLUB_BUNDLE = ResourceBundle
            .getBundle("assignment02PartB.resources.Club");

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
        officialName = LANG_BUNDLE.getString("officialName.label");
        shortName = LANG_BUNDLE.getString("shortName.label");
        established = LANG_BUNDLE.getString("established.label");
        colors = LANG_BUNDLE.getString("colors.label").split(",");
        ballpark = LANG_BUNDLE.getString("ballpark.label");
        numberOfWorldSeriesTitles = LANG_BUNDLE.getString("numberOfWorldSeriesTitles.label");
        numberOfNlPennants = LANG_BUNDLE.getString("numberOfNlPennants.label");
        numberOfDivisionTitles = LANG_BUNDLE.getString("numberOfDivisionTitles.label");
        numberOfWildCardBerths = LANG_BUNDLE.getString("numberOfWildCardBerths.label");
        owners = LANG_BUNDLE.getString("owners.label").split(",");
        president = new President(LANG_BUNDLE.getString("president.label"), this);
        generalManager = LANG_BUNDLE.getString("generalManager.label");
        manager = LANG_BUNDLE.getString("manager.label");
    }

    public Club(String officialName) {
    }

    public Club(String officialName, String shortName, String established, String[] colors,
            String ballpark, String numberOfWorldSeriesTitles, String numberOfNlPennants,
            String numberOfDivisionTitles, String numberOfWildCardBerths, String[] owners,
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
                LANG_BUNDLE.getString("officialName.label"),
                LANG_BUNDLE.getString("shortName.label"),
                LANG_BUNDLE.getString("established.label"),
                LANG_BUNDLE.getString("colors.label"),
                LANG_BUNDLE.getString("ballpark.label"),
                LANG_BUNDLE.getString("numberOfWorldSeriesTitles.label"),
                LANG_BUNDLE.getString("numberOfNlPennants.label"),
                LANG_BUNDLE.getString("numberOfDivisionTitles.label"),
                LANG_BUNDLE.getString("numberOfWildCardBerths.label"),
                LANG_BUNDLE.getString("owners.label"),
                LANG_BUNDLE.getString("president.label"),
                LANG_BUNDLE.getString("generalManager.label"),
                LANG_BUNDLE.getString("manager.label")
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