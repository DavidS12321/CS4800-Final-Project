public class cheese extends Topping{
    
    public String cheeseName;

    public cheese(String cheeseName)
    {
        super(cheeseName);
    }

    public String displayItem()
    {
        return this.cheeseName;
    }
}
