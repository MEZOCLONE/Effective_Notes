package eu.giovannidefranceso.effectivenotes.model;

import org.parceler.Parcel;

/**
 * Created by jibbo on 16/12/15.
 */
@Parcel
public class ParcelableNote {
    public long id;
    public String content;
    public ParcelableProfile profile;
    public String color;
    public String type;

    public ParcelableNote() {
    }

    public ParcelableNote(long id, String content, ParcelableProfile profile, String color, String type) {
        this.id = id;
        this.content = content;
        this.profile = profile;
        this.color = color;
        this.type = type;
    }

}
