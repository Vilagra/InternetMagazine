package levenko.com.Entites;

import java.util.Date;

/**
 * Created by Vilagra on 19.04.2016.
 */
public class Order {
    private int id=0;
    Date date;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
