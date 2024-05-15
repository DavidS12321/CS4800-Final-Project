public class ketchup extends Topping{
    
    public String ketchupName;

    public ketchup(String ketchupName)
    {
        super(ketchupName);
    }

    public String displayItem()
    {
        return this.ketchupName;
    }
}
