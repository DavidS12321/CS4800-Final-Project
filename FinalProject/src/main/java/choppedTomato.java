public class choppedTomato extends Topping{
    
    public String choppedTomatoName;

    public choppedTomato(String choppedTomatoName)
    {
        super(choppedTomatoName);
    }

    public String displayItem()
    {
        return this.choppedTomatoName;
    }
}
