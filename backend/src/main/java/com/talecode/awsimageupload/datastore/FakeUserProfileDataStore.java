package com.talecode.awsimageupload.datastore;

import com.talecode.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILE = new ArrayList<>();

    static {
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(), "bojackhorseman", null));
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(), "toddchavez", null));
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(), "princesscarolyn", null));
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(), "mrpeanutbutter", null));

    }

}
