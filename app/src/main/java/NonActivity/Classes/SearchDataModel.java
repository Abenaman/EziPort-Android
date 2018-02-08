package NonActivity.Classes;

/**
 * Created by Mahir Gulzar on 2/8/2018.
 */

public class SearchDataModel {

    String date;
    String weight;

    public SearchDataModel(String date, String weight) {
        this.date=date;
        this.weight=weight;
    }

    public String getDate() {
        return date;
    }

    public String getWeight() {
        return weight;
    }
}
