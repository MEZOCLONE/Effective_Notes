package eu.giovannidefranceso.effectivenotes.model;

import org.parceler.Parcel;

/**
 * Created by jibbo on 16/12/15.
 */
@Parcel
public class ParcelableProfile {
    public String name;

    public ParcelableProfile() {}

    public ParcelableProfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Profile toProfile(){
        return toProfile(this);
    }
    public static Profile toProfile(ParcelableProfile profile){
        return new Profile(profile.name);
    }
}
