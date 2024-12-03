package lab.pkg9;

public class ProfileManager {
    public void updateProfilePhoto(User user, String newPhotoPath) {
        user.getProfile().setProfilePhotoPath(newPhotoPath);
    }

    public void updateCoverPhoto(User user, String newCoverPhotoPath) {
        user.getProfile().setCoverPhotoPath(newCoverPhotoPath);
    }

    public void updateBio(User user, String newBio) {
        user.getProfile().setBio(newBio);
    }

    public void updatePassword(User user, String newHashedPassword) {
        user.setHashedPassword(newHashedPassword);
    }
}
