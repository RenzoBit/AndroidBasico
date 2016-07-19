package pe.edu.tecsup.androidsesion2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hrodp on 05/06/2016.
 */
public class AmpliableGroup {

    public String titulo;
    public final List<String> children = new ArrayList<>();

    public AmpliableGroup(String titulo) {
        this.titulo = titulo;
    }
}
