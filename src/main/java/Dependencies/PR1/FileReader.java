package Dependencies.PR1;

import Dependencies.PR1.Symbols.V;
import Dependencies.PR1.Symbols.VN;
import Dependencies.PR1.Symbols.VT;
import Dependencies.PR6.Production;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class FileReader {

    //Atributos.
    protected String path;

    //Constructores.
    public FileReader(String path) {
        this.path = path;
    }

    //Getter & Setter.
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //Métodos.
    /**
     * Utilizado en la Práctica 3.
     *
     * @return 
     */
    public List<String> devolverLineas() {

        List<String> lineas = new ArrayList<String>();

        try {

            FileInputStream file = new FileInputStream(this.path);
            InputStreamReader isr = new InputStreamReader(file, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.length() > 0) {
                    lineas.add(linea);
                }
            }

        } catch (IOException e) {
            try {
                throw new IOException("Error de parseo");
            } catch (IOException ex) {
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lineas;
        //}

    }

    /**
     * Utilizado en la Práctica 1.
     *
     * @param listaVN
     * @param listaVT
     * @param producciones
     * @param simbInicial
     * @throws java.io.IOException
     */
    public void analizarFichero(Collection<VN> listaVN, Collection<VT> listaVT, Collection<Production> producciones, VN simbInicial) throws IOException {

        try {

            FileInputStream file = new FileInputStream(this.path);
            InputStreamReader isr = new InputStreamReader(file, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String aux;
            String[] split;

            br.readLine(); //Línea que describe la gramática

            //Tratamos VN.
            aux = br.readLine(); //Línea de VN.
            String fragmento_VN = aux.substring(6, aux.length() - 1);
            split = fragmento_VN.split(", ");
            for (String s : split) {
                listaVN.add(new VN(s));
            }

            //Tratamos VT.
            aux = br.readLine(); //Línea de VT.
            String linea_VT = aux.substring(6, aux.length() - 1);
            split = linea_VT.split(", ");
            for (String s : split) {
                listaVT.add(new VT(s));
            }

            //Tratamos P.
            br.readLine(); //Línea de P.

            while ((aux = br.readLine()).compareTo("}") != 0) {
                if (!aux.startsWith("//") && aux.length() != 0) {
                    split = aux.split(" -> ");
                    VN antecedente = new VN(split[0]);
                    List<V> consecuentes = analizarConsecuentes(split[1], listaVN, listaVT);
                    producciones.add(new Production(antecedente, consecuentes));
                }
            }

            //Tratamos S.
            aux = br.readLine(); //Línea de S.
            String simI = aux.substring(4);
            simbInicial.setV(simI);

        } catch (IOException e) {
            throw new IOException("Error de parseo");
        }

    }

    private List<V> analizarConsecuentes(String consecuentes, Collection<VN> listaVN, Collection<VT> listaVT) {
        List<V> toReturn = new ArrayList<V>();
        String[] sp = consecuentes.split(" ");
        for (String c : sp) {
            if (esTerminal(c, listaVT)) {
                VT consecuente = new VT(c + "");
                toReturn.add(consecuente);
            } else {
                toReturn.add(new VN(c + ""));
            }
        }
        return toReturn;
    }

    private final boolean esTerminal(String simb, Collection<VT> listaVT) {
        VT v = new VT(simb);
        return listaVT.contains(v);//!(Character.isUpperCase(simb));
    }

    /**
     * Utilizado en la Práctica 10.
     *
     * @param listaVN
     * @param listaVT
     * @param producciones
     * @param simbInicial
     * @throws java.io.IOException
     */
    public void analizarFicheroPR_10(Collection<VN> listaVN, Collection<VT> listaVT, Collection<Production> producciones, VN simbInicial) throws IOException {

        try {

            FileInputStream file = new FileInputStream(this.path);
            InputStreamReader isr = new InputStreamReader(file, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String aux;
            String[] split;

            br.readLine(); //Línea que describe la gramática

            //Tratamos VN.
            aux = br.readLine(); //Línea de VN.
            String fragmento_VN = aux.substring(6, aux.length() - 1);
            split = fragmento_VN.split(", ");
            for (String s : split) {
                listaVN.add(new VN(s));
            }

            //Tratamos VT.
            aux = br.readLine(); //Línea de VT.
            String linea_VT = aux.substring(6, aux.length() - 1);
            split = linea_VT.split(", ");
            for (String s : split) {
                listaVT.add(new VT(s));
            }

            //Tratamos P.
            br.readLine(); //Línea de P.

            while ((aux = br.readLine()).compareTo("}") != 0) {
                if (!aux.startsWith("//") && aux.length() != 0) {
                    split = aux.split(" ::= ");
                    VN antecedente = new VN(split[0]);
                    List<V> consecuentes = analizarConsecuentes(split[1], listaVN, listaVT);
                    producciones.add(new Production(antecedente, consecuentes));
                }
            }

            //Tratamos S.
            aux = br.readLine(); //Línea de S.
            String simI = aux.substring(4);
            simbInicial.setV(simI);

        } catch (IOException e) {
            throw new IOException("Error de parseo");
        }

    }

    /**
     * Utilizado en la Práctica 10.
     *
     * @return List<String>
     * @throws java.io.IOException*/
    public List<String> devolverProducciones() throws IOException {
        try {

            FileInputStream file = new FileInputStream(this.path);
            InputStreamReader isr = new InputStreamReader(file, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String aux;

            br.readLine();

            //Saltamos VN.
            br.readLine(); //Línea de VN.

            //Saltamos VT.
            br.readLine(); //Línea de VT.

            //Tratamos P.
            br.readLine(); //Línea de P.

            List<String> listaProducciones = new ArrayList<String>();
            while ((aux = br.readLine()).compareTo("}") != 0) {
                listaProducciones.add(aux);
            }

            //Saltamos S.
            br.readLine(); //Línea de S.

            return listaProducciones;

        } catch (IOException e) {
            throw new IOException("Error de parseo");
        }
    }

    public String[] palabrasReservadas() throws IOException {
        try {

            FileInputStream file = new FileInputStream(this.path);
            InputStreamReader isr = new InputStreamReader(file, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String aux = br.readLine().substring(1);
            String[] split = aux.split(", ");
            return split;
        } catch (IOException e) {
            throw new IOException("Error de parseo");
        }
    }
}
