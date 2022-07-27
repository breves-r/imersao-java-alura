package aluraStickers;

public class Content {

	private final String title;
    private final String imageUrl;

    public Content(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTile() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
