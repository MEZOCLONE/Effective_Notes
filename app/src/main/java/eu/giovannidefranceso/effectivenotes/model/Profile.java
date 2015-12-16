package eu.giovannidefranceso.effectivenotes.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jibbo on 26/07/15.
 */

@Table(name = "Profile")
public class Profile extends Model {
    @Column(name = "name", unique = true)
    public String name;

    public Profile() {}


    public ParcelableProfile toParcelableProfile(){
        return Profile.toParcelableProfile(this);
    }

    public static ParcelableProfile toParcelableProfile(Profile profile) {
        return new ParcelableProfile(profile.name);
    }

    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
