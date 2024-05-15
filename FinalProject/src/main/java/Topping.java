public class Topping implements menuItem{
    public String name;

    public Topping(String name)
    {
        this.name = name;
    }

    @Override
    public String displayItem()
    {
       return this.name;
    }

    
}
