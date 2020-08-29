import java.util.*;

public class LinkFilter {
    /**
     * Konstanten
     */
    private static final String LINK_ANFANG         = "<a href=";
    private static final String LINK_MITTE          = ">";
    private static final String LINK_ENDE           = "</a>";
    private static final String BESCHREIBUNG        = "^.*<a href=.*>.*</a>.*$";

    /**
     * Eingabe Attribut
     */
    private Scanner in;

    /**
     * Standardkonstruktor
     */
    public LinkFilter() {
        in = new Scanner(System.in);
    }

    /**
     * Diese Methode filtert Hyperlinks aus HTML-Dateien und gibt sie aus
     */
    public void run() {
        String eineZeile;
        String urlString;
        String titelString;
        int hrefIndex;
        int urlAnfang;
        int urlEnde;
        int titelAnfang;
        int titelEnde;

        while((eineZeile = in.nextLine()) != null) {
            if(eineZeile.matches(BESCHREIBUNG)) {
                if((hrefIndex = eineZeile.indexOf(LINK_ANFANG)) != -1) {
                    urlAnfang = hrefIndex + 9;
                    urlEnde = eineZeile.indexOf(">", urlAnfang) - 1;
                    urlString = eineZeile.substring(urlAnfang, urlEnde);
                    urlString = urlString.trim();

                    titelAnfang = urlEnde + 2;
                    titelEnde = eineZeile.indexOf(">", titelAnfang);
                    titelString = eineZeile.substring(titelAnfang, titelEnde);
                    titelString = titelString.trim();

                    System.out.println(titelString + "\n" + urlString);
                }
            }
        }
    }

    /**
     * Mainmethode
     * 
     * @param args
     */
    public static void main(String[] args) {
        LinkFilter linkfilter = new LinkFilter();
        linkfilter.run();
    }
}