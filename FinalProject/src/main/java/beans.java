public class beans extends Topping{
    private String beansName;

    public beans(String beansName)
    {
        super(beansName);
    }

    @Override
    public String displayItem()
    {
        return beansName;
    }
}
