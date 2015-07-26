package eu.giovannidefranceso.effectivenotes.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jibbo on 26/07/15.
 */
@Table(name = "Profile")
public class Profile extends Model {
    @Column(name = "name")
    public String name;

    public Profile() {}

    public Profile(String name) {
        this.name = name;
    }
}
