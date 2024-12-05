package lab.pkg9;

public class Profile {
    private String profilePhotoPath;
    private String coverPhotoPath;
    private String bio;

    public Profile(String bio) {
        this.profilePhotoPath = null;
        this.coverPhotoPath = null;
        this.bio = bio;
    }

    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public String getCoverPhotoPath() {
        return coverPhotoPath;
    }

    public void setCoverPhotoPath(String coverPhotoPath) {
        this.coverPhotoPath = coverPhotoPath;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
