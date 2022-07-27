package aluraStickers;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		
		// fazer uma conexão HTTP e buscar os top 250 filmes
		// String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
		//String url = "https://api.mocki.io/v2/549a5d8b"; // usando endereço alternativo
		// ContentExtractor extractor = new ImdbContentExtractor();
		
		//String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        //ContentExtractor extractor = new NasaContentExtractor();
		
		String url = "http://localhost:8080/languages";
		ContentExtractor extractor = new ImdbContentExtractor();
		
		var http = new Client();
		String json = http.getData(url);
		
		// extrair só os dados que interessam (titulo, poster, classificação)
		
		List<Content> contents = extractor.extractContent(json);
        
        // exibir e manipular os dados 
        var generator = new StickerGenerator();
        
        for (int i = 0; i < 3; i++) {

            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getImageUrl()).openStream();
            String fileName = content.getTile() + ".png";

            generator.create(inputStream, fileName);

            System.out.println(content.getTile());
            System.out.println();
        }
        
	}
}
