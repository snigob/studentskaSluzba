package example;

public enum Rok {
	JANUARSKI, FEBRUARSKI, APRILSKI, JUNSKI, JULSKI, SEPTEMBARSKI, OKTOBARSKI;

    private static Rok[] vals = values();
    public Rok next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }


}
