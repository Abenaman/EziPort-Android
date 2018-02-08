package NonActivity.Classes;

/**
 * Created by Mahir Gulzar on 2/8/2018.
 */

public class RequestDataModel {

    String title;
    String weight;
    String to;
    String state;

    public RequestDataModel(String title, String weight, String to, String state) {
        this.title = title;
        this.weight = weight;
        this.to = to;
        this.state = state;
    }

    public String getTo() {
        return to;
    }

    public String getTitle() {

        return title;
    }

    public String getWeight() {
        return weight;
    }

    public String getState() {
        return state;
    }
}
