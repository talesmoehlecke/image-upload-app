package com.talecode.awsimageupload.profile;

import java.util.Objects;
import java.util.UUID;

public class UserProfile {
    private UUID id;
    private String usermame;
    private String imageLink; //S3 key

    public UserProfile(UUID id, String usermame, String imageLink) {
        this.id = id;
        this.usermame = usermame;
        this.imageLink = imageLink;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsermame() {
        return usermame;
    }

    public void setUsermame(String usermame) {
        this.usermame = usermame;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(usermame, that.usermame) &&
                Objects.equals(imageLink, that.imageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usermame, imageLink);
    }
}
