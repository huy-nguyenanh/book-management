package DTO;

public class Author {

    private String authorID;
    private String authorName;

    public Author() {
    }

    public Author(String authorID, String authorName) {
        this.authorID = authorID;
        this.authorName = authorName;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorID(String authorID) {
        if (authorID != null) {
            this.authorID = authorID;
        }
    }

    public void setAuthorName(String authorName) {
        if (authorName != null) {
            this.authorName = authorName;
        }
    }

    @Override
    public String toString() {
        return "Author ID: " + authorID + " - " + "Author Name: " + authorName + "\n";
    }
}
