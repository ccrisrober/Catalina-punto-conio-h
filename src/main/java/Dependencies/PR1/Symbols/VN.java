package Dependencies.PR1.Symbols;

/**
 * Símbolo no terminal.
 */
public class VN extends V implements Cloneable{

    //Constructores.
    public VN() {
        super();
    }

    public VN(String vn) {
        super(vn);
    }

    @Override
    public VN clone() {
        return new VN(getV());
    }

}
