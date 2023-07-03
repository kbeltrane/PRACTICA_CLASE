package com.example.practica_clase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JSON con las URL de las portadas de las revistas
        String json = "[\n" +
                "  {\n" +
                "    \"journal_id\": \"3\",\n" +
                "    \"portada\": \"https://revistas.uteq.edu.ec/public/journals/3/journalThumbnail_es_ES.jpg\",\n" +
                "    \"abbreviation\": \"csye\",\n" +
                "    \"description\": \"<p><strong>Ciencias Sociales y Económicas</strong>, es una revista académica de distribución nacional e internacional editada semestralmente (junio y diciembre) por la Universidad Técnica Estatal de Quevedo, enfocada a la publicación de artículos originales e inéditos, escritos en español, inglés y portugués, que han sido entregados por sus autores para su reproducción .El contenido científico es responsabilidad exclusiva de los propios investigadores, con bases en el arbitraje técnico (modalidad del doble ciego), garantizando la confidencialidad y anonimato de autores y árbitros de acuerdo a las normas editoriales.</p>\\n<p><strong>La revista Ciencias Sociales y Económicas </strong>está dirigida a la comunidad académica nacional e internacional, cuyo propósito es cumplir con el rol institucional, económico y pedagógico de promoción y desarrollo del conocimiento en el área de las Ciencias Sociales y Económicas , vista desde una perspectiva amplia y multidisciplinaria. El objetivo de la Revista es contribuir a la academia a través de investigaciones resultantes de procesos de análisis, reflexión y producción crítica sobre la condición contemporánea.</p>\\n<p>Una vez que hayan pasado todo el proceso, los ar´tículos científicos se publicarán de manera completamente gratuita.</p>\\n<p>El objetivo de la revista es difundir los resultados de investigación de acuerdo a las sub áreas del conocimiento UNESCO: Ciencias Jurídicas (5605 y 5699), Ciencias Económicas (5304), Ciencias Pedagógicas (5801, 5802 y5899), Ciencias sociológicas (6303), Ciencias Psicológicas (6107), Ciencias de la Comunicación Social (6308) , Historia ( 5502) , Educación y Trabajo Social (6310).</p>\\n<p>La revista tiene su<strong> ISSN 2588 - 0594</strong> para la publicación Electrónica y el <strong>ISSN 2588 - 0586</strong> en su presentación impresa.</p>\",\n" +
                "    \"journalThumbnail\": \"{\\\"name\\\":\\\"unnamed.png\\\",\\\"uploadName\\\":\\\"journalThumbnail_es_ES.png\\\",\\\"width\\\":1011,\\\"height\\\":1046,\\\"dateUploaded\\\":\\\"2023-04-12 21:22:18\\\",\\\"altText\\\":\\\"\\\"}\",\n" +
                "    \"name\": \"Ciencias Sociales y Económicas\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"journal_id\": \"2\",\n" +
                "    \"portada\": \"https://revistas.uteq.edu.ec/public/journals/2/journalThumbnail_es_ES.jpg\",\n" +
                "    \"abbreviation\": \"cyt\",\n" +
                "    \"description\": \"<p>Ciencia y Tecnología es una revista científica publicada y editada semestralmente, por la <strong>Universidad Técnica Estatal de Quevedo, </strong>abierta a investigadores, docentes y profesionales ecuatorianos y extranjeros. Todos los artículos, sin excepción, son sometidos a arbitraje a través de pares evaluadores nacionales o internacionales de reconocido prestigio, por su experiencia en el ámbito de la publicación científica a evaluar, el mismo que está documentado por los artículos publicados en revistas de renombre internacional. Los evaluadores no son miembros del Comité Editorial ni de la entidad o institución editora. Las contribuciones deben ser originales e inéditas y que no hayan sido enviadas a otra revista para su publicación.</p>\\n<p>La revista tiene su <strong>ISSN 1390-4043</strong> para la publicación Electrónica y el <strong>ISSN 1390-4051</strong> en su presentación impresa.</p>\",\n" +
                "    \"journalThumbnail\": \"{\\\"name\\\":\\\"LOGO REVISTA CYT.png\\\",\\\"uploadName\\\":\\\"journalThumbnail_es_ES.png\\\",\\\"width\\\":440,\\\"height\\\":372,\\\"dateUploaded\\\":\\\"2020-06-15 19:15:39\\\",\\\"altText\\\":\\\"\\\"}\",\n" +
                "    \"name\": \"Ciencia y Tecnología\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"journal_id\": \"1\",\n" +
                "    \"portada\": \"https://revistas.uteq.edu.ec/public/journals/1/journalThumbnail_es_ES.jpg\",\n" +
                "    \"abbreviation\": \"InGenio\",\n" +
                "    \"description\": \"<p><strong>Ingenio </strong><em>e</em>s una revista editada por la <a title=\\\"Universidad Técnica Estatal de Quevedo\\\" href=\\\"https://www.uteq.edu.ec/\\\" target=\\\"_blank\\\" rel=\\\"noopener\\\">Universidad Técnica Estatal de Quevedo</a>. Todo el material enviado a la revista para su publicación y aceptado por el Comité Editorial, en atención a su calidad y relevancia, está sujeto a revisión por pares especialistas en los campos de conocimiento correspondientes.<strong><br /></strong></p>\\n<p><strong>Ingenio </strong>es una revista científica dedicada a la publicación semestral de artículos de resultados de investigaciones originales en español e inglés. Cubre una variedad de temas relacionados con varias áreas de conocimiento de Ciencias de la Ingeniería. Los trabajos se publican durante los meses de enero y julio.</p>\\n<p><strong>El envío de manuscritos a la revista está abierto todo el año.</strong></p>\",\n" +
                "    \"journalThumbnail\": \"[]\",\n" +
                "    \"name\": \"Revista InGenio\"\n" +
                "  }\n" +
                "]";


        // Obtener el LinearLayout donde se mostrarán las imágenes
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        try {
            JSONArray jsonArray = new JSONArray(json);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String imageUrl = jsonObject.getString("portada");

                // Crear un ImageView y agregarlo al LinearLayout
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(layoutParams);
                linearLayout.addView(imageView);

                // Cargar la imagen utilizando Glide
                RequestOptions requestOptions = new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL); // Cachear la imagen para un rendimiento óptimo

                Glide.with(this)
                        .load(imageUrl)
                        .apply(requestOptions)
                        .into(imageView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}