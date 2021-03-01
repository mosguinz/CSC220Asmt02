/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Card.java
 * @author: Duc Ta
 * @author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public class Card {

    //
    // Instance Data Fields
    //
    private final int artSize = 0;
    // Please change artSize, if needed, to get an identical output
    private final String artFont = "";
    // Please change artFont, if needed, to get an identical output

    public void printCards(String[][] cards, Student student) {
        SFGiantsCardGenerator generator = new SFGiantsCardGenerator();
        final String firstName = student.getFirstName();
        final String email = student.getEmail();
        final String officialSong = Language.getOfficialSong();

        for (int i = 0; i < cards.length; i++) {
            final String recipient = cards[i][0];
            final char artSymbol = cards[i][1].charAt(0);
            final String message = cards[i][2];

            System.out.println();
            try {
                generator.generateSFGiantsCard(recipient, message, firstName, email,
                        artSymbol, artSize, artFont);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
