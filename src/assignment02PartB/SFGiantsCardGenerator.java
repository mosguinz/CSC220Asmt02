/*
 * ****************************************************************
 * ASCII Art Generator in Java.
 * Prints a given text as an ASCII text art on the console.
 * This initial code is licensed under - CC Attribution CC BY 4.0.
 * @author QuickProgrammingTips.com
 * @author Duc Ta
 * ****************************************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: SFGiantsCardGenerator.java
 * @author: Duc Ta
 * @author: Kullathon Sitthisarnwattanachai
 * *****************************************************************
 */

//
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
//

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferedImage;

public final class SFGiantsCardGenerator {
    //
    // Static Data Fields
    //
    public static final int ART_SIZE_XSMALL = 8;
    public static final int ART_SIZE_SMALL = 12;
    public static final int ART_SIZE_MEDIUM = 18;
    public static final int ART_SIZE_LARGE = 24;
    public static final int ART_SIZE_HUGE = 32;
    private static final char DEFAULT_ART_SYMBOL = '*';

    public enum ASCIIArtFont {
        ART_FONT_ARIAL("Arial"), ART_FONT_CONSOLAS("Consolas"), ART_FONT_COURIER("Courier"),
        ART_FONT_COURIER_NEW("Courier New"), ART_FONT_DIALOG("Dialog"), ART_FONT_DIALOG_INPUT("DialogInput"),
        ART_FONT_FIXEDSYS("Fixedsys"), ART_FONT_IBM_Plex_Mono("IBM Plex Mono"), ART_FONT_LETTER_GOTHIC("Letter Gothic"),
        ART_FONT_LUCIDA_CONSOLE("Lucida Console"), ART_FONT_MONOFUR("Monofur"), ART_FONT_MONOSPACED("Monospaced"),
        ART_FONT_PRO_FONT("Pro Font"), ART_FONT_SANS_SERIF("SansSerif"), ART_FONT_SERIF("Serif"),
        ART_FONT_SOURCE_CODE_PRO("Source Code Pro"), ART_FONT_SFSU("Courier");

        private String font;
        private ASCIIArtFont(String value) {
            this.font = value;
        }
        public String getFont() {
            return font;
        }
        public void setFontArtFrontSFSU(String font) {
            ASCIIArtFont.ART_FONT_SFSU.font = font;
        }
    }

    //
    // Constructors
    //
    public SFGiantsCardGenerator() {}


    //
    // Instance Methods
    //
    public static int getArtSizeXsmall() {
        return SFGiantsCardGenerator.ART_SIZE_XSMALL;
    }
    public static int getArtSizeSmall() {
        return SFGiantsCardGenerator.ART_SIZE_SMALL;
    }
    public static int getArtSizeMedium() {
        return SFGiantsCardGenerator.ART_SIZE_MEDIUM;
    }
    public static int getArtSizeLarge() {
        return SFGiantsCardGenerator.ART_SIZE_LARGE;
    }
    public static int getArtSizeHuge() {
        return SFGiantsCardGenerator.ART_SIZE_HUGE;
    }
    public static char getDefaultArtSymbol() {
        return SFGiantsCardGenerator.DEFAULT_ART_SYMBOL;
    }

    //
    // Additional Instance Methods
    //
    // Prints ASCII art for the specified text. For size, you can use predefined
    // sizes or a custom size. Usage -
    // printTextArt("Hi",30,ASCIIArtFont.ART_FONT_SERIF,"@");
    private void printTextArt(String artText, int textHeight, ASCIIArtFont fontType, char artSymbol) throws Exception {
        String fontName = fontType.getFont();
        int imageWidth = findImageWidth(textHeight, artText, fontName);

        BufferedImage image = new BufferedImage(imageWidth, textHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Font font = new Font(fontName, Font.BOLD, textHeight);
        g.setFont(font);

        Graphics2D graphics = (Graphics2D) g;
        graphics.drawString(artText, 0, getBaselinePosition(g, font));

        for (int y = 0; y < textHeight; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < imageWidth; x++) {
                sb.append(image.getRGB(x, y) == Color.WHITE.getRGB() ? artSymbol : " ");
            }
            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            // SF Giants
            System.out.printf("%-8s %-80s %-8s %n", "SF", sb, "SF");
        }
    }

    // Convenience method for printing ascii text art. Font default - Dialog,
    // Art symbol default -
    private void printTextArt(String artText, int textHeight) throws Exception {
        printTextArt(artText, textHeight, ASCIIArtFont.ART_FONT_DIALOG, DEFAULT_ART_SYMBOL);
    }

    //  Using the Current font and current art text find the width of the full image
    private int findImageWidth(int textHeight, String artText, String fontName) {
        BufferedImage im = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics g = im.getGraphics();
        g.setFont(new Font(fontName, Font.BOLD, textHeight));
        return g.getFontMetrics().stringWidth(artText);
    }

    // Find where the text baseline should be drawn so that the characters are within image
    private int getBaselinePosition(Graphics g, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int y = metrics.getAscent() - metrics.getDescent();
        return y;
    }

    // Find where the text baseline should be drawn so that the characters are within image
    public void generateSFGiantsCard(String recipient, String message, String senderFirstName, String senderEmail, char artSymbol, int artSize, String artFont) throws Exception {
        // SF Giants Thank You
        artSize = (artSize < 8) ? SFGiantsCardGenerator.ART_SIZE_SMALL : artSize;
        artFont = (artFont.isEmpty()) ? "Courier" : artFont;
        ASCIIArtFont.ART_FONT_SFSU.setFontArtFrontSFSU(artFont);

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-18s", "SF GIANTS - - - - ");
        }
        System.out.printf("%-5s %n", "SF");
        System.out.printf("%-8s %-80s %-8s %n", "SF", "", "SF");
        this.printTextArt("Thank you <3", artSize, ASCIIArtFont.ART_FONT_SFSU, artSymbol);
        System.out.printf("%-8s %-80s %-8s %n", "SF", "", "SF");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-18s", "SF GIANTS - - - - ");
        }
        System.out.printf("%-5s %n", "SF");
        System.out.printf("%-8s %-80s %-8s %n", "SF", "", "SF");
        System.out.printf("%-8s %-80s %-5s %n", "SF", recipient + ",", "SF");
        System.out.printf("%-8s %-5s %-74s %-5s %n", "SF", "", message, "SF");
        System.out.printf("%-8s %-80s %-5s %n", "SF", "Love,", "SF");
        System.out.printf("%-8s %-80s %-5s %n", "SF", senderFirstName, "SF");
        System.out.printf("%-8s %-80s %-8s %n", "SF", "", "SF");
        System.out.printf("%-8s %78s %-1s %-5s %n", "SF", senderEmail + " / " + Language.getOfficialSong(), "", "SF");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-18s", "SF GIANTS - - - - ");
        }
        System.out.printf("%-5s %n", "SF");
    }
}
