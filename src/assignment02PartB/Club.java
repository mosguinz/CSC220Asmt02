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
            .getBundle("assignment02PartB.resources.ClubInfo");

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
     * Sole constructor to instantiate a {@link Club}. Club information are from the {@link
     * #CLUB_BUNDLE} resource bundle.
     */
    public Club() {
        officialName = CLUB_BUNDLE.getString("officialName");
        shortName = CLUB_BUNDLE.getString("shortName");
        established = CLUB_BUNDLE.getString("established");
        colors = CLUB_BUNDLE.getString("colors").split(",");
        ballpark = CLUB_BUNDLE.getString("ballpark");
        numberOfWorldSeriesTitles = CLUB_BUNDLE.getString("numberOfWorldSeriesTitles");
        numberOfNlPennants = CLUB_BUNDLE.getString("numberOfNlPennants");
        numberOfDivisionTitles = CLUB_BUNDLE.getString("numberOfDivisionTitles");
        numberOfWildCardBerths = CLUB_BUNDLE.getString("numberOfWildCardBerths");
        owners = CLUB_BUNDLE.getString("owners").split(",");
        president = new President(
                CLUB_BUNDLE.getString("president.firstName"),
                CLUB_BUNDLE.getString("president.lastName"),
                this
        );
        generalManager = new GeneralManager(
                CLUB_BUNDLE.getString("generalManager.firstName"),
                CLUB_BUNDLE.getString("generalManager.lastName"),
                this
        );
        manager = new Manager(
                CLUB_BUNDLE.getString("manager.firstName"),
                CLUB_BUNDLE.getString("manager.lastName"),
                this
        );
    }

    /**
     * Unused constructor from starter code. The provided constructor was broken and have since
     * fixed to ensure a successful compilation.
     */
    @Deprecated
    public Club(int yearEstablished, String[] owners, String[] colors, String officialName,
            String shortName) {
    }

    /**
     * Display information about the club.
     */
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
                String.join(", ", owners),
                president.toString(),
                generalManager.toString(),
                manager.toString()
        };
        ChatSession.printTable(fields, values);
    }
}
