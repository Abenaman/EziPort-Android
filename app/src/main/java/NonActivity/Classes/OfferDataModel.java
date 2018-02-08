package NonActivity.Classes;

/**
 * Created by Mahir Gulzar on 2/8/2018.
 */

public class OfferDataModel {

    String title;
    String weight;
    String action;

    public OfferDataModel(String title, String weight) {
        this.title = title;
        this.weight = weight;
    }


    public String getTitle() {

        return title;
    }

    public String getWeight() {
        return weight;
    }

}
