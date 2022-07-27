package aluraStickers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor implements ContentExtractor{

	public List<Content> extractContent(String json) {

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contentsList = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> attribute : attributesList) {
            String title = attribute.get("title");
            String imageUrl = attribute.get("image");

            var content = new Content(title, imageUrl);

            contentsList.add(content);
        }

        return contentsList;
    }
}
